package com.elarian.example.java;

import com.elarian.hera.Elarian;
import com.elarian.hera.proto.GrpcWebServiceGrpc.GrpcWebServiceBlockingStub;
import com.elarian.hera.proto.Web.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        GrpcWebServiceBlockingStub instance = Elarian.newInstance("test_api_key");

        GetCustomerStateRequest req =  GetCustomerStateRequest
                .newBuilder()
                .setCustomerId("fake_id")
                .setOrgId("test_org")
                .build();
        GetCustomerStateReply res = instance.getCustomerState(req);
        System.out.println(res.toString());
    }
}