package com.elarian.example.kotlin

import kotlinx.coroutines.*
import com.elarian.hera.proto.Web.*
import com.elarian.hera.proto.Common.*
import com.elarian.hera.Elarian

fun main() {
    val elarian = Elarian.newInstance("test_api_key")
    runBlocking {
        val req = StreamNotificationRequest
            .newBuilder()
            .setOrgId("test_org")
            .setAppId("test_app")
            .build()

        val stream = elarian.streamNotifications(req)
        while(stream.hasNext()) {
            val notif = stream.next()
            println(notif)
        }
    }

    Thread.sleep(20000L)
}