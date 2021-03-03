package com.elarian.hera;

import com.elarian.hera.proto.AppSocket;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.netty.buffer.ByteBuf;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketConnector;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.ByteBufPayload;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;


abstract class Client<B, C> {

    private final ClientOpts clientOpts;
    private final ConnectionConfig connectionConfig;

    protected RSocket socket;
    private int reconnect = 100;
    private final TcpClientTransport transport;
    private Function<B, Mono<C>> notificationHandler;
    private final static boolean debug = System.getenv().containsKey("DEBUG");


    private static void log(String message) {
        if (debug) {
            System.out.println(message);
        }
    }

    public Client(ClientOpts clientOpts, ConnectionConfig connConfig) {
        this.clientOpts = clientOpts;
        this.connectionConfig = connConfig;

        transport = TcpClientTransport.create(
                TcpClient
                        .create()
                        .secure()
                        .host("tcp.elarian.dev")
                        .port(8082)
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
        this.connect(null);
    }

    /**
     * Connect to the elarian server
     * @param onConnectionError
     * @throws RuntimeException
     */
    public void connect(Consumer<Throwable> onConnectionError) throws RuntimeException {
        if (this.isConnected()) throw new RuntimeException("Client is already connected");

        byte[] payload = AppSocket.AppConnectionMetadata.newBuilder()
                .setAppId(clientOpts.appId)
                .setOrgId(clientOpts.orgId)
                .setApiKey(StringValue.newBuilder().setValue(clientOpts.apiKey))
                // .setAuthToken(StringValue.newBuilder().setValue(clientOpts.authToken))
                .setSimplexMode(!clientOpts.allowNotifications)
                .setSimulatorMode(clientOpts.isSimulator || !clientOpts.allowNotifications)
                .build()
                .toByteArray();

        log("Connecting...");
        socket = RSocketConnector
                .create()
                .metadataMimeType("application/octet-stream")
                .dataMimeType("application/octet-stream")
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .setupPayload(ByteBufPayload.create(payload))
                .acceptor(SocketAcceptor.forRequestResponse(requestHandler))
                .keepAlive(Duration.ofMillis(connectionConfig.keepAlive), Duration.ofMillis(connectionConfig.lifetime))
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
                            if (--reconnect > 0) {
                                log("Reconnecting, attempt #" + reconnect);
                                socket.dispose();
                                socket = null;
                                connect(onConnectionError);
                            }
                        }
                );
    }

    /**
     * Disconnect from the elarian server
     */
    public void disconnect() {
        this.disconnect("");
    }

    public void disconnect(String message) {
         this.reconnect = 0;
        if (message != null && !message.isEmpty()) {
            log("Disconnecting from server, REASON: " + message);
        } else {
            log("Disconnecting from server... ");
        }
        socket.dispose();
    }

    protected boolean isConnected() {
        return socket != null && !socket.isDisposed();
    }

    /**
     * Subscribe to notifications
     * @param notificationHandler
     */
    public void registerNotificationHandler(Function<B, Mono<C>> notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    protected abstract byte[] serializeNotificationReply(C data);

    protected abstract B deserializeNotification(byte[] data) throws InvalidProtocolBufferException;

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

    protected <D> Mono<D> buildCommandReply (byte[] data, Function<byte[], D> deserializer) {
        if (!isConnected()) {
            return Mono.error(new RuntimeException("Elarian client is not connected!"));
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
                        e.printStackTrace();
                        subscriber.onError(e);
                    }
                }, subscriber::onError);
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
                        B notification = deserializeNotification(getBytesFromPayload(payload));
                        Mono<C> reply = Mono.error(new Error("notification handler is not setup; you must call subscribe() to receive notifications"));
                        if (notificationHandler != null) {
                            reply = notificationHandler.apply(notification);
                        }
                        reply.subscribe(data -> {
                            subscriber.onNext(ByteBufPayload.create(serializeNotificationReply(data)));
                            subscriber.onComplete();
                        }, throwable -> {
                            throwable.printStackTrace();
                            subscriber.onError(throwable);
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
