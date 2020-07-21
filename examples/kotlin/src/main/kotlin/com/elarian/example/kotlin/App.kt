package com.elarian.example.kotlin

import com.elarian.hera.proto.Web.GetCustomerStateRequest
import com.elarian.hera.Elarian

fun main() {
    val elarian = Elarian.newInstance("test_api_key", true)
    val req = GetCustomerStateRequest
            .newBuilder()
            .setAppId("test_app")
            .setCustomerId("fake")
            .build()
    val res = elarian.getCustomerState(req)
    print(res)
}
