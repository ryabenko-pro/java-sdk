package com.elarian.example.kotlin

import com.elarian.hera.Simulator
import com.elarian.hera.proto.CommonModel.Cash
import com.elarian.hera.proto.PaymentModel.*
import com.elarian.hera.proto.SimulatorSocket.ServerToSimulatorNotificationReply
import kotlinx.coroutines.runBlocking
import reactor.core.CoreSubscriber
import reactor.core.publisher.Mono

fun main() {
    runBlocking {
        val elarian = Simulator.newInstance("test_api_key", "test_org", "test_app")
        elarian.registerNotificationHandler { notif -> object : Mono<ServerToSimulatorNotificationReply>() {
                override fun subscribe(callback: CoreSubscriber<in ServerToSimulatorNotificationReply?>) {
                    print("Got a notification -> $notif")
                    callback.onNext(ServerToSimulatorNotificationReply.getDefaultInstance())
                    callback.onComplete()
                }
            }
        }

        // String transactionId, PaymentChannelNumber channelNumber, String customerNumber, Cash value, PaymentStatus status
        val channelNumber = PaymentChannelNumber
            .newBuilder()
            .setNumber("525900")
            .setChannel(PaymentChannel.PAYMENT_CHANNEL_CELLULAR)
            .build()
        val cash = Cash
            .newBuilder()
            .setAmount(100.0)
            .setCurrencyCode("KES")
            .build()
        elarian.receivePayment("fake-txnzz", channelNumber, "+254718769882", cash, PaymentStatus.PAYMENT_STATUS_PENDING_CONFIRMATION)
            .subscribe(
                {
                    print(it)
                },
                {
                    it.printStackTrace()
                }
            )
    }
    Thread.sleep(3000L)
}