package com.elarian.example.kotlin

import com.elarian.hera.proto.Web.GetCustomerStateRequest
import com.elarian.hera.Elarian

fun main() {
    val apiKey = "77bcc4b83574b3626e5b4780169c1dd7d62ed76e4515edc3e584c21e4e89ce91"
    val appId = "app-j90HNs"
    val product = "product-j90HNs"

    val elarian = Elarian.newInstance(apiKey)
    val req = GetCustomerStateRequest
            .newBuilder()
            .setAppId(appId)
            .setCustomerId("el_cst_67a6d10ccffa84ba2c017ae77c9e4d94")
            .build()
    val res = elarian.getCustomerState(req)
    print(res)
}
