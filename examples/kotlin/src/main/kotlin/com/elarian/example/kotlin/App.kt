package com.elarian.example.kotlin

import com.elarian.hera.proto.Web.*
import com.elarian.hera.proto.Common.*
import com.elarian.hera.Elarian

fun main() {
    val elarian = Elarian.newInstance("test_api_key")
    val req = GetCustomerStateRequest
            .newBuilder()
            .setOrgId("test_org")
            .setCustomerNumber(
                    CustomerNumber
                            .newBuilder()
                            .setNumber("+254700000000")
                            .setProvider(CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_TELCO)
                            .build()
            )
            .build()
    val res = elarian.getCustomerState(req)
    print(res)
}
