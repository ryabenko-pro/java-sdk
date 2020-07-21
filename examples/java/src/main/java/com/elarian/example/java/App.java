package com.elarian.example.java;

import com.elarian.hera.Elarian;
import com.elarian.hera.proto.GrpcWebServiceGrpc.GrpcWebServiceBlockingStub;
import com.elarian.hera.proto.Web;

public class App {
    public static void main(String[] args) {
        GrpcWebServiceBlockingStub instance = Elarian.newInstance("77bcc4b83574b3626e5b4780169c1dd7d62ed76e4515edc3e584c21e4e89ce91", true);
        Web.SendMessageRequest req =  Web.SendMessageRequest
                .newBuilder()
                .setProductId("product-j90HNs")
                .setAppId("app-j90HNs")
                .build();
        Web.SendMessageReply res = instance.sendMessage(req);
        System.out.println(res.toString());
    }
}