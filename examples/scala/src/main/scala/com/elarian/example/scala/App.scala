package com.elarian.example.scala

import java.util.Date
import com.elarian.hera.Elarian
import reactor.core.publisher.Mono
import reactor.core.CoreSubscriber
import com.google.protobuf.Timestamp
import com.elarian.hera.proto.AppModel.CustomerReminder
import com.elarian.hera.proto.CommonModel.{CustomerNumber, CustomerNumberProvider}
import com.elarian.hera.proto.AppSocket.{ServerToAppNotificationReply, UpdateCustomerAppDataReply, UpdateCustomerStateReply}

import java.util.function.Consumer



object App {
    def main(args: Array[String]): Unit = {
        val elarian = Elarian.newInstance("test_api_key", "test_org", "test_app")
        elarian.registerNotificationHandler((notif) => new Mono[ServerToAppNotificationReply]() {
            override def subscribe(callback: CoreSubscriber[_ >: ServerToAppNotificationReply]): Unit = {
                println("App: Got a notification -> " + notif.toString)
                callback.onNext(ServerToAppNotificationReply.getDefaultInstance)
                callback.onComplete()
            }
        })
        val customer = CustomerNumber
            .newBuilder()
            .setNumber("+254718769882")
            .setProvider(CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_CELLULAR)
            .build()
        val reminder = CustomerReminder
          .newBuilder()
          .setKey("Scala Key")
          .setRemindAt(Timestamp.newBuilder().setSeconds((new Date().getTime + 5000) / 1000))
          .build()

        elarian.addCustomerReminder(customer, reminder)
          .subscribe(
              new Consumer[UpdateCustomerAppDataReply]() {
                override def accept(res: UpdateCustomerAppDataReply): Unit = {
                    println(res)
                }
              },
              new Consumer[Throwable]() {
                override def accept(err: Throwable): Unit = {
                    err.printStackTrace()
                }
              }
          )
    }
}