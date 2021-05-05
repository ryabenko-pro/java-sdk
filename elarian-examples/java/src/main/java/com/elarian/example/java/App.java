package com.elarian.example.java;

import com.elarian.*;
import com.elarian.model.*;

import java.util.logging.Logger;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        log.info("Starting...");

        String appId = System.getenv("APP_ID");
        String orgId = System.getenv("ORG_ID");
        String apiKey = System.getenv("API_KEY");

        Elarian app = new Elarian(apiKey, orgId, appId);

        app.connect(new ConnectionListener() {
            @Override
            public void onPending() {
                log.warning("Pending...");
            }

            @Override
            public void onConnecting() {
                log.warning("Connecting...");
            }

            @Override
            public void onClosed() {
                log.warning("Connection Closed");
            }

            @Override
            public void onConnected() {
                log.info("Connected!");
                Tag tag = new Tag("some-key", "some-value");
                MessagingChannel channel = new MessagingChannel("2020", MessagingChannel.Channel.SMS);
                Message message = new Message(new MessageBody("This is a test"));
                app.sendMessageByTag(tag, channel, message)
                        .subscribe(
                                res -> log.info(res.description),
                                err -> err.printStackTrace()
                        );
            }
            @Override
            public void onError(Throwable throwable) {
                log.warning("Failed to connect: " + throwable.getMessage());
            }
        });

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}