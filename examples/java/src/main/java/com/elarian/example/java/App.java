package com.elarian.example.java;


import com.elarian.hera.Elarian;
import com.elarian.hera.proto.AppModel.*;
import com.elarian.hera.proto.AppSocket.*;
import com.elarian.hera.proto.CommonModel.*;
import com.elarian.hera.proto.MessagingModel.*;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.logging.Logger;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        log.info("Starting...");

        String appId = "test_app";
        String orgId = "test_org";
        String apiKey = "test_api_key";
        String senderId = "Elarian";
        CustomerNumber customerNumber = CustomerNumber
                .newBuilder()
                .setNumber("+254718769882")
                .setProvider(CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_CELLULAR)
                .build();
        MessagingChannelNumber channel = MessagingChannelNumber
                .newBuilder()
                .setNumber(senderId)
                .setChannel(MessagingChannel.MESSAGING_CHANNEL_SMS)
                .build();

        Elarian app = Elarian.newInstance(apiKey, orgId, appId, Throwable::printStackTrace);
        app.registerNotificationHandler((notification -> new Mono<ServerToAppNotificationReply>(){
            @Override
            public void subscribe(CoreSubscriber<? super ServerToAppNotificationReply> callback) {
                log.info("App: Got a notification -> " + notification.toString());
                callback.onNext(ServerToAppNotificationReply.getDefaultInstance());
                callback.onComplete();
            }
        }));


        CustomerReminder reminder = CustomerReminder
                .newBuilder()
                .setRemindAt(Timestamp.newBuilder().setSeconds((new Date().getTime() + 10000) / 1000).build())
                .setKey("Some Key Key")
                .setPayload(StringValue.newBuilder().setValue("PAYLOAD").build())
                .build();
        app.addCustomerReminder(customerNumber, reminder)
                .subscribe(
                        res -> log.info("Set the reminder: " + res.toString()),
                        throwable -> {
                            log.warning("Failed to set reminder");
                            throwable.printStackTrace();
                        });
        OutboundMessage msg = OutboundMessage
                .newBuilder()
                .setBody(OutboundMessageBody
                        .newBuilder()
                        .setText("This is an sms test")
                        .build()
                )
                .build();
        app.sendMessage(customerNumber, channel, msg)
                .subscribe(
                        res -> log.info("Sent message: " + res.toString()),
                        throwable -> {
                            log.warning("Failed to sent message");
                            throwable.printStackTrace();
                        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(false);
        t.start();

    }
}