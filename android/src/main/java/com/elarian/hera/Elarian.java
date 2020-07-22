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
                .userAgent("elarian-android-sdk/0.0.0")
                .useTransportSecurity()
                .build();
    }

    private static Metadata makeHeaders(String authToken) {
        if (authToken == null) {
            throw new IllegalArgumentException("authToken is required");
        }
        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER), authToken);
        return metadata;
    }

    public static GrpcWebServiceBlockingStub newInstance(String authToken, boolean sandbox) {
        GrpcWebServiceBlockingStub stub = GrpcWebServiceGrpc.newBlockingStub(makeChannel(sandbox));
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(authToken));
        return stub;
    }


    public static GrpcWebServiceStub newAsyncInstance(String authToken, boolean sandbox) {
        GrpcWebServiceStub stub = GrpcWebServiceGrpc.newStub(makeChannel(sandbox));
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(authToken));
        return stub;
    }
}
