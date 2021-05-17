package com.elarian.example.java;

import com.elarian.ConnectionListener;
import com.elarian.Customer;
import com.elarian.Elarian;
import com.elarian.model.Cash;
import com.elarian.model.CustomerNumber;
import com.elarian.model.DataValue;
import com.elarian.model.InitiatePaymentReply;
import com.elarian.model.Message;
import com.elarian.model.MessageBody;
import com.elarian.model.MessagingChannel;
import com.elarian.model.NotificationHandler;
import com.elarian.model.PaymentChannel;
import com.elarian.model.PaymentCustomerCounterParty;
import com.elarian.model.PaymentPurseCounterParty;
import com.elarian.model.PaymentStatus;
import com.elarian.model.ReceivedPaymentNotification;
import com.elarian.model.Reminder;
import com.elarian.model.ReminderNotification;
import com.elarian.model.Say;
import com.elarian.model.TextToSpeechVoice;
import com.elarian.model.UssdMenu;
import com.elarian.model.UssdSessionNotification;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());
    static Elarian app;
    static PaymentChannel mpesaChannel;
    static MessagingChannel smsChannel, voiceChannel;

    static void approveLoan(Customer customer, String name, float balance) {
        log.warning("Approving loan of " + balance + " for " + name);

        long repaymentDate = System.currentTimeMillis() + 60000;

        CustomerNumber number = customer.getCustomerNumber().block();

        InitiatePaymentReply res = app.initiatePayment(
                new PaymentPurseCounterParty(System.getenv("PURSE_ID")),
                new PaymentCustomerCounterParty(
                        number,
                        mpesaChannel
                ),
                new Cash("KES", balance)
        ).block();

        if (res.status != PaymentStatus.SUCCESS &&
                res.status != PaymentStatus.QUEUED &&
                res.status != PaymentStatus.PENDING_CONFIRMATION) {
            log.warning("Failed to send loan money: " + res.description);
            return;
        }
        Map<String, DataValue> meta = new HashMap<>();
        meta.put("balance", DataValue.of(String.valueOf(balance)));
        customer.updateMetadata(meta).block();

        @SuppressWarnings("DefaultLocale")
        String text = String.format("Congratulations %s!\n" +
                "Your loan of KES %.2f has been approved!\n" +
                "You are expected to pay it back by %s", name, balance, new Date(repaymentDate));
        Message message = new Message(new MessageBody(text));
        customer.sendMessage(smsChannel, message).block();
        customer.addReminder(new Reminder("moni", "", repaymentDate)).block();
    }


    @SuppressWarnings("DefaultLocale")
    static NotificationHandler<ReminderNotification, Message> reminderHandler = (notification, customer, appData, responder) -> {
        CustomerNumber customerNumber = customer.getCustomerNumber().block();
        log.warning("Processing Reminder for " + customerNumber.number);

        Map<String, DataValue> meta = customer.getMetadata().block();
        String name = "Unknown customer";
        float balance = 0;
        int strike = 1;

        if (meta.containsKey("name")) {
            name = meta.get("name").string;
        }

        if (meta.containsKey("balance")) {
            balance = Float.parseFloat(meta.get("balance").string);
        }

        if (meta.containsKey("strike")) {
            strike = Integer.parseInt(meta.get("strike").string);
        }

        MessageBody body;
        MessagingChannel channel = smsChannel;
        if (strike == 1) {
            body = new MessageBody(String.format("Hello %s, this is a friendly reminder to pay back my KES %.2f", name, balance));
        } else if (strike == 2) {
            body = new MessageBody(String.format("Hey %s, you still need to pay back my KES %.2f", name, balance));
        } else {
            channel = voiceChannel;
            body = new MessageBody();
            body.voice = Collections.singletonList(
                    new Say(String.format("Yo %s!!!! you need to pay back my KES %.2f", name, balance), true, TextToSpeechVoice.MALE)
            );
        }

        customer.sendMessage(channel, new Message(body)).block();

        meta.put("strike", DataValue.of(String.valueOf(strike + 1)));
        customer.updateMetadata(meta).block();

        customer.addReminder(new Reminder("moni", "", System.currentTimeMillis() + 60000)).block();
    };

    static NotificationHandler<UssdSessionNotification, UssdMenu> ussdSessionHandler =
            (notification, customer, appData, responder) -> {
                try {
                    String input = notification.input;
                    log.info(
                            "Processing USSD from "
                                    + notification.customerNumber.number);
                    customer
                            .getMetadata()
                            .subscribe(
                                    meta -> {
                                        String name = null;
                                        float balance = 0;
                                        if (meta.containsKey("name")) {
                                            name = meta.get("name").string;
                                        }
                                        if (meta.containsKey("balance")) {
                                            balance = Float.parseFloat(meta.get("balance").string);
                                        }

                                        String screen = "home";
                                        if (appData != null && appData.string != null) {
                                            screen = appData.string;
                                        }

                                        String nextScreen = screen;
                                        if (screen.contentEquals("home") && !input.contentEquals("")) {
                                            if (input.contentEquals("1")) {
                                                nextScreen = "request-name";
                                            } else if (input.contentEquals("2")) {
                                                nextScreen = "quit";
                                            }
                                        }

                                        if (screen.contentEquals("home") && input.contentEquals("")) {
                                            if (name != null) {
                                                nextScreen = "info";
                                            }
                                        }

                                        String text;
                                        switch (nextScreen) {
                                            case "quit":
                                                responder.callback(
                                                        new UssdMenu("Happy Coding!", true), DataValue.of("home"));
                                                break;
                                            case "info":
                                                text = String.format("Hey %s", name);
                                                text +=
                                                        balance > 0
                                                                ? String.format("you still owe me KES %.2f!", balance)
                                                                : "you have repaid your loan, good for you!";
                                                responder.callback(new UssdMenu(text, true), DataValue.of("home"));
                                                break;
                                            case "request-name":
                                                text = "Alright, what is your name?";
                                                responder.callback(
                                                        new UssdMenu(text, false), DataValue.of("request-amount"));
                                                break;
                                            case "request-amount":
                                                name = input;
                                                text = String.format("Okay %s, how much do you need?", name);
                                                responder.callback(
                                                        new UssdMenu(text, false), DataValue.of("approve-amount"));
                                                break;
                                            case "approve-amount":
                                                balance = Float.parseFloat(input);
                                                text = String.format("Awesome! %s we are reviewing your application and will be in touch shortly!\nHave a lovely day!", name);
                                                responder.callback(new UssdMenu(text, true), DataValue.of("home"));
                                                approveLoan((Customer) customer, name, balance);
                                                break;
                                            case "home":
                                            default:
                                                text = "Welcome to MoniMoni!\n1. Apply for loan\n2. Quit";
                                                responder.callback(new UssdMenu(text, false), DataValue.of("home"));
                                                break;
                                        }

                                        if (name != null) {
                                            meta.put("name", DataValue.of(name));
                                        }
                                        meta.put("balance", DataValue.of(String.valueOf(balance)));
                                        customer
                                                .updateMetadata(meta)
                                                .subscribe(
                                                        re -> { },
                                                        err -> {
                                                            log.warning("Failed to Update Meta: " + err.getMessage());
                                                        });
                                    },
                                    err -> {
                                        log.warning("Failed to fetch meta");
                                        err.printStackTrace();
                                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                    log.warning(ex.getMessage());
                }
            };

    @SuppressWarnings("DefaultLocale")
    static NotificationHandler<ReceivedPaymentNotification, Message> paymentReceivedHandler =
            (notification, customer, appData, responder) -> {
                log.warning("Processing payment from " + notification.customerNumber.number);
                responder.callback(null, appData);

                Map<String, DataValue> meta = customer.getMetadata().block();
                Cash value = notification.value;
                double newBalance = 0;
                String name = "Unknown Customer";
                if (meta.containsKey("balance")) {
                    newBalance = Float.parseFloat(meta.get("balance").string) - value.amount;
                }
                if (meta.containsKey("name")) {
                    name = meta.get("name").string;
                }

                meta.put("balance", DataValue.of(String.valueOf(newBalance)));
                customer.updateMetadata(meta).block();

                if (newBalance <= 0) {
                    customer.cancelReminder("moni").block();
                    String text =
                            String.format(
                                    "Thank you for your payment %s, your loan has been fully repaid!!", name);
                    Message message = new Message(new MessageBody(text));
                    customer.sendMessage(smsChannel, message).block();
                    customer.deleteMetadata(Arrays.asList("name", "strike", "balance")).block();
                    customer.deleteAppData().block();
                } else {
                    String text = String.format("Hey %s!\nThank you for your payment, but you still owe me KES %.2f", name, newBalance);
                    Message message = new Message(new MessageBody(text));
                    customer.sendMessage(smsChannel, message).block();
                }
            };

    static {
        String appId = System.getenv("APP_ID");
        String orgId = System.getenv("ORG_ID");
        String apiKey = System.getenv("API_KEY");

        app = new Elarian(apiKey, orgId, appId);
        smsChannel = new MessagingChannel(System.getenv("SMS_SHORT_CODE"), MessagingChannel.Channel.SMS);
        voiceChannel = new MessagingChannel(System.getenv("VOICE_NUMBER"), MessagingChannel.Channel.VOICE);
        mpesaChannel = new PaymentChannel(System.getenv("MPESA_PAYBILL"), PaymentChannel.Channel.CELLULAR);

        app.setOnReminderNotificationHandler(reminderHandler);
        app.setOnUssdSessionNotificationHandler(ussdSessionHandler);
        app.setOnReceivedPaymentNotificationHandler(paymentReceivedHandler);
    }

    public static void main(String[] args) {
        log.info("Starting...");

        app.connect(
                new ConnectionListener() {
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
                        String ussCode = System.getenv("USSD_CODE");
                        log.info("App is connected, waiting for customers on " + ussCode);
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
