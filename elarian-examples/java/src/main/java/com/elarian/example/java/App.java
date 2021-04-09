package com.elarian.example.java;

import com.elarian.ConnectionListener;
import com.elarian.Elarian;
import com.elarian.model.Message;
import com.elarian.model.MessageBody;
import com.elarian.model.MessagingChannel;
import com.elarian.model.Tag;

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

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(false);
        t.start();

    }
}