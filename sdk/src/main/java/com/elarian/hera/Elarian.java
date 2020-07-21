package com.elarian.hera;


import com.elarian.hera.proto.GrpcWebServiceGrpc;
import com.elarian.hera.proto.GrpcWebServiceGrpc.GrpcWebServiceStub;
import com.elarian.hera.proto.GrpcWebServiceGrpc.GrpcWebServiceBlockingStub;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;

public final class Elarian {

    private static final int PORT = 443;
    private static final String HOST_SANDBOX = "api.elarian.dev";
    private static final String HOST_PRODUCTION = "api.elarian.com";

    private static Channel makeChannel(boolean sandbox) {
        String host = HOST_PRODUCTION;
        if (sandbox) {
            host = HOST_SANDBOX;
        }

        return ManagedChannelBuilder
                .forAddress(host, PORT)
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

    private static GrpcWebServiceBlockingStub newInstance(String apiKey, String authToken, boolean sandbox) {
        GrpcWebServiceBlockingStub stub = GrpcWebServiceGrpc.newBlockingStub(makeChannel(sandbox));
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(apiKey, authToken));
        return stub;
    }

    public static GrpcWebServiceBlockingStub newInstance(String apiKey, boolean sandbox) {
        return newInstance(apiKey, null, sandbox);
    }

    private static GrpcWebServiceStub newAsyncInstance(String apiKey, String authToken, boolean sandbox) {
        GrpcWebServiceStub stub = GrpcWebServiceGrpc.newStub(makeChannel(sandbox));
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(apiKey, authToken));
        return stub;
    }

    public static GrpcWebServiceStub newAsyncInstance(String apiKey, boolean sandbox) {
        return newAsyncInstance(apiKey, null, sandbox);
    }
}
