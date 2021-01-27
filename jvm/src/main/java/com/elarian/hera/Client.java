package com.elarian.hera;

import com.elarian.hera.proto.AppSocket;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketConnector;
import io.rsocket.core.Resume;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Client<B, C> {

    private final ClientOpts clientOpts;
    private final int PORT = 8082;
    private final String HOST = "20.50.102.116";
    private final ConnectionConfig connectionConfig;

    private final Resume resume;
    protected RSocket client;
    private boolean isConnected = false;
    private final TcpClientTransport transport;

    private Function<B, Mono<C>> notificationHandler;

    private static void log(String message) {
        System.out.println(message);
    }

    public Client(ClientOpts clientOpts, ConnectionConfig connConfig) {
        this.clientOpts = clientOpts;
        this.connectionConfig = connConfig;

        transport = TcpClientTransport.create(HOST, PORT);
        resume = new Resume()
                .sessionDuration(Duration.ofSeconds(connConfig.lifetime))
                .retry(
                        Retry.fixedDelay(Long.MAX_VALUE, Duration.ofSeconds(1))
                        .doBeforeRetry(s -> log("Disconnected. Retrying..."))
                );
    }

    /**
     * Connect to the elarian server
     * @throws RuntimeException
     */
    public void connect() throws RuntimeException {
        if (isConnected) throw new RuntimeException("Client is already connected");

        byte[] payload = AppSocket.AppConnectionMetadata.newBuilder()
                .setAppId(clientOpts.appId)
                .setOrgId(clientOpts.orgId)
                .setApiKey(StringValue.newBuilder().setValue(clientOpts.apiKey))
                // .setAuthToken(StringValue.newBuilder().setValue(clientOpts.authToken))
                .setSimplexMode(!clientOpts.allowNotifications)
                .setSimulatorMode(clientOpts.isSimulator || !clientOpts.allowNotifications)
                .build()
                .toByteArray();

        client = RSocketConnector
                .create()
                .keepAlive(Duration.ofSeconds(connectionConfig.keepAlive), Duration.ofSeconds(connectionConfig.lifetime))
                .metadataMimeType("application/octet-stream")
                .dataMimeType("application/octet-stream")
                .setupPayload(DefaultPayload.create(payload))
                .acceptor(SocketAcceptor.forRequestResponse(requestHandler))
                .resume(resume)
                .connect(transport)
                .block();
        isConnected = true;
    }

    /**
     * Disconnect from the elarian server
     */
    public void disconnect() {
        if (isConnected) {
            client.dispose();
            isConnected = false;
        }
    }


    /**
     * Subscribe to notifications
     * @param notificationHandler
     */
    public void subscribe(Function<B, Mono<C>> notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    protected abstract byte[] serializeNotificationReply(C data);

    protected abstract B deserializeNotification(byte[] data) throws InvalidProtocolBufferException;

    protected <D> Mono<D> buildCommandReply (byte[] data, Function<byte[], D> deserializer) {
        return new Mono<D>() {
            @Override
            public void subscribe(CoreSubscriber<? super D> subscriber) {

                Mono<Payload> resp = client.requestResponse(DefaultPayload.create(data));
                resp.subscribe(new Consumer<Payload>() {
                    @Override
                    public void accept(Payload payload) {
                        try {
                            D reply = deserializer.apply(payload.getData().array());
                            if (reply == null) {
                                throw new Error("Failed to deserialize command response!");
                            }
                            subscriber.onNext(reply);
                            subscriber.onComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                            subscriber.onError(e);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        subscriber.onError(throwable);
                    }
                });
            }
        };
    }

    protected Function<Payload, Mono<Payload>> requestHandler = new Function<Payload, Mono<Payload>>() {
        @Override
        public Mono<Payload> apply(Payload payload) {
            return new Mono<Payload>() {
                @Override
                public void subscribe(CoreSubscriber<? super Payload> subscriber) {
                    try {
                        B notification = deserializeNotification(payload.getData().array());
                        Mono<C> reply = Mono.error(new Error("notification handler is not setup; you must call subscribe() to receive notifications"));
                        if (notificationHandler != null) {
                            reply = notificationHandler.apply(notification);
                        }
                        reply.subscribe(new Consumer<C>() {
                            @Override
                            public void accept(C result) {
                                subscriber.onNext(DefaultPayload.create(serializeNotificationReply(result)));
                                subscriber.onComplete();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) {
                                throwable.printStackTrace();
                                subscriber.onError(throwable);
                            }
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        subscriber.onError(ex);
                    }
                }
            };
        }
    };
}
