package com.elarian.hera;

import io.rsocket.transport.netty.client.TcpClientTransport;

public final class Elarian {

    private static final int PORT = 443;
    private static final String HOST = "api.elarian.dev";

    private static Channel makeChannel() {
        return ManagedChannelBuilder
                .forAddress(HOST, PORT)
                .userAgent("elarian-jvm-sdk/0.0.0")
                .useTransportSecurity()
                .build();
    }

    private static Metadata makeHeaders(String apiKey, String authToken) {
        if (apiKey == null && authToken == null) {
            throw new IllegalArgumentException("Either of apiKey or authToken is required");
        }
        Metadata metadata = new Metadata();
        String headerKey = "api-key";
        String headerValue = apiKey;
        if (authToken != null) {
            headerKey = "auth-token";
            headerValue = authToken;
        }
        metadata.put(Metadata.Key.of(headerKey, Metadata.ASCII_STRING_MARSHALLER), headerValue);
        return metadata;
    }

    private static GrpcWebServiceBlockingStub newInstance(String apiKey, String authToken) {
        GrpcWebServiceBlockingStub stub = GrpcWebServiceGrpc.newBlockingStub(makeChannel());
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(apiKey, authToken));
        return stub;
    }

    public static GrpcWebServiceBlockingStub newInstance(String apiKey) {
        return newInstance(apiKey, null);
    }

    private static GrpcWebServiceStub newAsyncInstance(String apiKey, String authToken) {
        GrpcWebServiceStub stub = GrpcWebServiceGrpc.newStub(makeChannel());
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(apiKey, authToken));
        return stub;
    }

    public static GrpcWebServiceStub newAsyncInstance(String apiKey) {
        return newAsyncInstance(apiKey, null);
    }
}
