package com.elarian.example.scala

import com.elarian.hera.Elarian
import com.elarian.hera.proto.Web.GetCustomerStateRequest


object App {
    def main(args: Array[String]): Unit = {
        val instance = Elarian.newInstance("test_api_key")
        val req =  GetCustomerStateRequest
                .newBuilder()
                .setCustomerId("fake_id")
                .setOrgId("test_org")
                .build()
        val res = instance.getCustomerState(req)
        System.out.println(res.toString)
    }
}