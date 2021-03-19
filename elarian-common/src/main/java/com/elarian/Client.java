package com.elarian;

import com.elarian.model.ClientConfig;
import com.elarian.model.NotificationHandler;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

import io.netty.buffer.ByteBuf;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketConnector;
import io.rsocket.core.Resume;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.ByteBufPayload;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;
import reactor.util.retry.Retry;

abstract class Client<B, C> {

    private final ClientConfig clientOpts;

    protected RSocket socket;
    private final TcpClientTransport transport;
    private final Resume resume;
    private Function<B, Mono<C>> globalNotificationHandler;
    private final static boolean debug = System.getenv().containsKey("DEBUG");

    protected Function<Payload, Mono<Payload>> requestHandler = new Function<Payload, Mono<Payload>>() {
        @Override
        public Mono<Payload> apply(Payload payload) {
            return new Mono<Payload>() {
                @Override
                public void subscribe(CoreSubscriber<? super Payload> subscriber) {
                    try {
                        B notification = deserializeNotification(getBytesFromPayload(payload));
                        Mono<C> reply = Mono.error(new Error("notification handler is not setup;"));
                        if (globalNotificationHandler != null) {
                            reply = globalNotificationHandler.apply(notification);
                        }
                        reply.subscribe(data -> {
                            subscriber.onNext(ByteBufPayload.create(serializeNotificationReply(data)));
                            subscriber.onComplete();
                        }, throwable -> {
                            throwable.printStackTrace();
                            subscriber.onError(throwable);
                        });
                    } catch (Exception ex) {
                        subscriber.onError(ex);
                    }
                }
            };
        }
    };


    private static void log(String message) {
        if (debug) {
            System.out.println(message);
        }
    }

    protected Client(ClientConfig clientOpts) {
        this.clientOpts = clientOpts;

        transport = TcpClientTransport.create(
                TcpClient
                        .create()
                        .secure()
                        .host("tcp.elarian.dev")
                        .port(8082)
                );

        resume = new Resume()
                .sessionDuration(Duration.ofMillis(clientOpts.connectionConfig.lifetime))
                .cleanupStoreOnKeepAlive()
                .retry(
                        Retry.backoff(Long.MAX_VALUE, Duration.ofSeconds(2))
                        .doBeforeRetry(s -> log("Disconnected. Retrying..."))
                );

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (isConnected()){
                disconnect("Application shutting down!");
            }
        }));
    }

    /**
     * Connect to the elarian server
     * @throws RuntimeException
     */
    public void connect() throws RuntimeException {
        this.connect(null, null);
    }

    /**
     * Connect to the elarian server
     * @param onConnectionSuccess
     * @param onConnectionError
     * @throws RuntimeException
     */
    public void connect(Consumer<Boolean> onConnectionSuccess, Consumer<Throwable> onConnectionError) throws RuntimeException {
        if (this.isConnected()) throw new RuntimeException("Client is already connected");

        byte[] payload = serializeSetupPayload(clientOpts);

        log("Connecting...");
        RSocketConnector connector = RSocketConnector
                .create()
                .metadataMimeType("application/octet-stream")
                .dataMimeType("application/octet-stream")
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .setupPayload(ByteBufPayload.create(payload))
                .acceptor(SocketAcceptor.forRequestResponse(requestHandler))
                .keepAlive(Duration.ofMillis(this.clientOpts.connectionConfig.keepAlive), Duration.ofMillis(this.clientOpts.connectionConfig.lifetime));
        if (this.clientOpts.connectionConfig.isResumable) {
            connector.resume(resume);
        }
        socket = connector
                .connect(transport)
                .block(Duration.ofSeconds(30));
        log("Connected");
        socket.onClose()
                .subscribe(
                        (signal) -> {
                            log("Connection SIGNAL");
                        },
                        (err) -> {
                            log("Connection ERROR: " + err.getMessage());
                            this.disconnect(err.getMessage());
                            if (onConnectionError != null) {
                                onConnectionError.accept(err);
                            }
                        },
                        () -> {
                            log("Connection CLOSED");
                        }
                );
        if (onConnectionSuccess != null) {
            onConnectionSuccess.accept(true);
        }
    }

    /**
     * Disconnect from the elarian server
     */
    public void disconnect() {
        this.disconnect("");
    }

    public void disconnect(String message) {
        if (message != null && !message.isEmpty()) {
            log("Disconnecting from server, REASON: " + message);
        } else {
            log("Disconnecting from server... ");
        }
        socket.dispose();
    }

    public boolean isConnected() {
        return socket != null && !socket.isDisposed();
    }

    protected void registerGlobalNotificationHandler(Function<B, Mono<C>> handler) {
        this.globalNotificationHandler = handler;
    }

    protected abstract byte[] serializeNotificationReply(C data);

    protected abstract byte[] serializeSetupPayload(ClientConfig opts);

    protected abstract B deserializeNotification(byte[] data) throws RuntimeException;

    protected <D> Mono<D> buildCommandReply (byte[] data, Function<byte[], D> deserializer) {
        if (!isConnected()) {
            return Mono.error(new RuntimeException("client is not connected!"));
        }
        return new Mono<D>() {
            @Override
            public void subscribe(CoreSubscriber<? super D> subscriber) {
                Mono<Payload> resp = socket.requestResponse(ByteBufPayload.create(data));
                resp.subscribe(payload -> {
                    try {
                        D reply = deserializer.apply(getBytesFromPayload(payload));
                        if (reply == null) {
                            throw new Error("Failed to deserialize command response!");
                        }
                        subscriber.onNext(reply);
                        subscriber.onComplete();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }, subscriber::onError);
            }
        };
    }

    private byte[] getBytesFromPayload(Payload payload) {
        ByteBuf buf = payload.sliceData();
        byte[] bytes;
        int length = buf.readableBytes();

        if (buf.hasArray()) {
            bytes = buf.array();
        } else {
            bytes = new byte[length];
            buf.getBytes(buf.readerIndex(), bytes);
        }
        payload.release();
        return bytes;
    }

}