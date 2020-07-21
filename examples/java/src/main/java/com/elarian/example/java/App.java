package com.elarian.example.java;

import com.elarian.hera.Elarian;
import com.elarian.hera.proto.GrpcWebServiceGrpc;
import com.elarian.hera.proto.GrpcWebServiceGrpc.GrpcWebServiceBlockingStub;
import com.elarian.hera.proto.Web.*;
import io.grpc.stub.StreamObserver;

public class App {
    public static void main(String[] args) throws InterruptedException {
        GrpcWebServiceBlockingStub instance = Elarian.newInstance("test_api_key", true);

        GetCustomerStateRequest req =  GetCustomerStateRequest
                .newBuilder()
                .setCustomerId("fake_id")
                .setAppId("test_app")
                .build();
        GetCustomerStateReply res = instance.getCustomerState(req);
        System.err.println(res.toString());

        GrpcWebServiceGrpc.GrpcWebServiceStub asyncInstance = Elarian.newAsyncInstance("test_api_key", true);
        asyncInstance.getCustomerState(req, new StreamObserver<GetCustomerStateReply>() {
            @Override
            public void onNext(GetCustomerStateReply value) {
                System.err.println(value.toString());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }
        });

        Thread.sleep(5000);
    }
}