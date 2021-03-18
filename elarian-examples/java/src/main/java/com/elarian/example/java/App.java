package com.elarian.example.java;


import com.elarian.Elarian;
import com.elarian.model.CustomerNumber;
import com.elarian.model.Message;
import com.elarian.model.MessageBody;
import com.elarian.model.MessagingChannel;
import com.elarian.model.Tag;

import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        log.info("Starting...");

        String appId = "GithubActions";
        String orgId = "og-f5OUHn";
        String apiKey = "el_api_key_db2fc77601f0a075dacfe78d3ab5d5560925a0ae9a1ba5e95f49477b73d09d5a";

        Elarian app = new Elarian(apiKey, orgId, appId);

        app.connect(success -> {
            log.info("Connected!");
            Tag tag = new Tag("some-key", "some-value");
            MessagingChannel channel = new MessagingChannel("2020", MessagingChannel.Channel.SMS);
            Message message = new Message(new MessageBody("This is a test"));
            app.sendMessageByTag(tag, channel, message)
                .subscribe(
                        res -> log.info(res.description),
                        err -> err.printStackTrace()
                );
        }, throwable -> {
            log.warning("Failed to connect: " + throwable.getMessage());
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