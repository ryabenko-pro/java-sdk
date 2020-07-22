package com.elarian.example.scala

import com.elarian.hera.Elarian
import com.elarian.hera.proto.Web.GetCustomerStateRequest


object App {
    def main(args: Array[String]): Unit = {
        val instance = Elarian.newInstance("test_api_key", true);
        val req =  GetCustomerStateRequest
                .newBuilder()
                .setCustomerId("fake_id")
                .setAppId("test_app")
                .build();
        val res = instance.getCustomerState(req)
        System.err.println(res.toString)
    }
}