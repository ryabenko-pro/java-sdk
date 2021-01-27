package com.elarian.example.java;


import com.elarian.hera.Elarian;
import com.elarian.hera.Simulator;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;
import com.elarian.hera.proto.AppSocket.*;
import com.elarian.hera.proto.CommonModel.*;
import com.elarian.hera.proto.MessagingModel.*;
import com.elarian.hera.proto.SimulatorSocket.*;

public class App {

    public static void log(String message) {
        System.out.println(message);
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


        /*
        Simulator sim = Simulator.newInstance(apiKey, orgId, appId);
        sim.subscribe(new Function<ServerToSimulatorNotification, Mono<ServerToSimulatorNotificationReply>>() {
            @Override
            public Mono<ServerToSimulatorNotificationReply> apply(ServerToSimulatorNotification notification) {
                return new Mono<ServerToSimulatorNotificationReply>() {
                    @Override
                    public void subscribe(CoreSubscriber<? super ServerToSimulatorNotificationReply> callback) {
                        log("Simulator: Got a notification -> " + notification.toString());
                        callback.onNext(ServerToSimulatorNotificationReply.getDefaultInstance());
                        callback.onComplete();
                    }
                };
            }
        });*/

        Elarian app = Elarian.newInstance(apiKey, orgId, appId);
        app.subscribe((notification -> {
            return new Mono<ServerToAppNotificationReply>(){
                @Override
                public void subscribe(CoreSubscriber<? super ServerToAppNotificationReply> callback) {
                    log("App: Got a notification -> " + notification.toString());
                    callback.onNext(ServerToAppNotificationReply.getDefaultInstance());
                    callback.onComplete();
                }
            };
        }));


        OutboundMessage message = OutboundMessage
                .newBuilder()
                .setBody(OutboundMessageBody
                        .newBuilder()
                        .setText("Hello from Elarian Java")
                        .build()
                )
                .build();
        app.sendToMessage(customerNumber, channel, message)
                .subscribe(new Consumer<SendMessageReply>() {
                    @Override
                    public void accept(SendMessageReply res) {
                        log("Send the message: " + res.toString());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        log("Failed to send message");
                        throwable.printStackTrace();
                    }
                });

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}