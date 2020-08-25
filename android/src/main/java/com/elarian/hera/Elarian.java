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
    private static final String HOST = "api.elarian.dev";

    private static Channel makeChannel() {
        return ManagedChannelBuilder
                .forAddress(HOST, PORT)
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

    public static GrpcWebServiceBlockingStub newInstance(String authToken) {
        GrpcWebServiceBlockingStub stub = GrpcWebServiceGrpc.newBlockingStub(makeChannel());
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(authToken));
        return stub;
    }


    public static GrpcWebServiceStub newAsyncInstance(String authToken) {
        GrpcWebServiceStub stub = GrpcWebServiceGrpc.newStub(makeChannel());
        stub = MetadataUtils.attachHeaders(stub, makeHeaders(authToken));
        return stub;
    }
}
