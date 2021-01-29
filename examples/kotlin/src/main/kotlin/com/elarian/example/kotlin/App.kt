package com.elarian.example.kotlin

import kotlinx.coroutines.*
import com.elarian.hera.Elarian
import reactor.core.publisher.Mono
import reactor.core.CoreSubscriber
import com.elarian.hera.proto.AppModel.*
import com.elarian.hera.proto.AppSocket.*
import com.elarian.hera.proto.CommonModel.*
import com.google.protobuf.StringValue
import com.google.protobuf.Timestamp
import java.util.*
import java.util.function.Consumer

fun main() {
    runBlocking {
        println("Starting...")
        val elarian = Elarian.newInstance("test_api_key", "test_org", "test_app")
        println("Connected")
        elarian.registerNotificationHandler { notif -> object : Mono<ServerToAppNotificationReply>() {
                override fun subscribe(callback: CoreSubscriber<in ServerToAppNotificationReply?>) {
                    print("App: Got a notification -> $notif")
                    callback.onNext(ServerToAppNotificationReply.getDefaultInstance())
                    callback.onComplete()
                }
            }
        }
        val customer = CustomerNumber
            .newBuilder()
            .setNumber("+254718769882")
            .setProvider(CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_CELLULAR)
            .build()
        val reminder = CustomerReminder
            .newBuilder()
            .setKey("Some Key")
            .setRemindAt(Timestamp.newBuilder().setSeconds((Date().time + 5000) / 1000))
            .setPayload(StringValue.newBuilder().setValue("PPPPP"))
            .build()
        elarian.addCustomerReminder(customer, reminder)
            .subscribe(
                { println(it) },
                { it.printStackTrace() }
            )
    }
    Thread.sleep(20000L)
}