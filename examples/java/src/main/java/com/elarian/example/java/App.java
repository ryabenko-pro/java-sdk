package com.elarian.example.java;


import com.elarian.hera.Elarian;
import com.elarian.hera.proto.AppModel.CustomerReminder;
import com.elarian.hera.proto.AppSocket;
import com.elarian.hera.proto.AppSocket.ServerToAppNotificationReply;
import com.elarian.hera.proto.CommonModel.CustomerNumber;
import com.elarian.hera.proto.CommonModel.CustomerNumberProvider;
import com.elarian.hera.proto.MessagingModel.MessagingChannel;
import com.elarian.hera.proto.MessagingModel.MessagingChannelNumber;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.function.Consumer;

public class App {

    private static void log(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {


        log("Starting...");

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

        Elarian app = Elarian.newInstance(apiKey, orgId, appId);
        app.registerNotificationHandler((notification -> new Mono<ServerToAppNotificationReply>(){
            @Override
            public void subscribe(CoreSubscriber<? super ServerToAppNotificationReply> callback) {
                App.log("App: Got a notification -> " + notification.toString());
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
                    res -> log("Set the reminder: " + res.toString()),
                    throwable -> {
                        log("Failed to set reminder");
                        throwable.printStackTrace();
                    });

        app.addCustomerReminder(null, null).subscribe(
                new Consumer<AppSocket.UpdateCustomerAppDataReply>() {
                    @Override
                    public void accept(AppSocket.UpdateCustomerAppDataReply updateCustomerAppDataReply) {

                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                }
        );

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