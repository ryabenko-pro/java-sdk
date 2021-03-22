package com.elarian;

import com.elarian.model.*;
import com.elarian.hera.proto.AppModel;
import com.elarian.hera.proto.AppSocket;
import com.elarian.hera.proto.CommonModel;
import com.elarian.hera.proto.MessagingModel;
import com.elarian.model.WalletPaymentStatusNotification;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;

import java.util.List;
import java.util.function.Function;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public final class Elarian extends Client<AppSocket.ServerToAppNotification, AppSocket.ServerToAppNotificationReply> {

    private final Function<byte[], AppSocket.AppToServerCommandReply> replyDeserializer = (data) -> {
        try {
            return AppSocket.AppToServerCommandReply.newBuilder().mergeFrom(data).build();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    };
    private NotificationHandler<ReminderNotification, MessageBody> onReminderNotificationHandler;
    private NotificationHandler<MessagingSessionInitializedNotification, MessageBody> onMessagingSessionStartedNotificationHandler;
    private NotificationHandler<MessagingSessionInitializedNotification, MessageBody> onMessagingSessionRenewedNotificationHandler;
    private NotificationHandler<MessagingSessionEndedNotification, MessageBody> onMessagingSessionEndedNotificationHandler;
    private NotificationHandler<MessagingConsentUpdateNotification, MessageBody> onMessagingConsentUpdateNotificationHandler;
    private NotificationHandler<ReceivedSmsNotification, MessageBody> onReceivedSmsNotificationHandler;
    private NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedFbMessengerNotificationHandler;
    private NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedTelegramNotificationHandler;
    private NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedWhatsappNotificationHandler;
    private NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedEmailNotificationHandler;
    private NotificationHandler<VoiceCallNotification, List<VoiceAction>> onVoiceCallNotificationHandler;
    private NotificationHandler<UssdSessionNotification, UssdMenu> onUssdSessionNotificationHandler;
    private NotificationHandler<MessageStatusNotification, MessageBody> onMessageStatusNotificationHandler;
    private NotificationHandler<SentMessageReactionNotification, MessageBody> onSentMessageReactionNotificationHandler;
    private NotificationHandler<ReceivedPaymentNotification, MessageBody> onReceivedPaymentNotificationHandler;
    private NotificationHandler<PaymentStatusNotification, MessageBody> onPaymentStatusNotificationHandler;
    private NotificationHandler<WalletPaymentStatusNotification, MessageBody> onWalletPaymentStatusNotificationHandler;
    private NotificationHandler<CustomerActivityNotification, MessageBody> onCustomerActivityNotificationHandler;

    public Elarian(String apiKey, String orgId, String appId) {
        this(apiKey, orgId, appId, true, new ConnectionConfig());
    }

    public Elarian(String apiKey, String orgId, String appId, boolean allowNotifications, ConnectionConfig connectionConfig) {
        super(new ClientConfig(apiKey, orgId, appId, allowNotifications, connectionConfig));

        registerGlobalNotificationHandler(notif -> new Mono<AppSocket.ServerToAppNotificationReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super AppSocket.ServerToAppNotificationReply> subscriber) {

                NotificationCallback<MessageBody> responder = (incoming, appData) -> {
                    MessagingModel.OutboundMessage message = Utils.buildOutgoingMessage(new Message(incoming));
                    CommonModel.DataMapValue.Builder data = CommonModel.DataMapValue.newBuilder();
                    if (appData != null) {
                        if (appData.bytes != null) {
                            data.setBytesVal(ByteString.copyFrom(appData.bytes));
                        } else if (appData.string != null) {
                            data.setStringVal(appData.string);
                        }
                    }
                    AppSocket.ServerToAppNotificationReply reply = AppSocket.ServerToAppNotificationReply.newBuilder()
                            .setMessage(message)
                            .setDataUpdate(AppSocket.AppDataUpdate.newBuilder()
                                    .setData(data)
                                    .build())
                            .build();
                    subscriber.onNext(reply);
                    subscriber.onComplete();
                };

                if (notif.hasPurse()) {
                    handlePurseNotification(notif.getPurse(), responder);
                } else if (notif.hasCustomer()) {
                    handleCustomerNotification(notif.getCustomer(), responder);
                } else {
                    responder.callback(null, null);
                }
            }
        });
    }

    public void setOnVoiceCallNotificationHandler(NotificationHandler<VoiceCallNotification, List<VoiceAction>> onVoiceCallNotificationHandler) {
        this.onVoiceCallNotificationHandler = onVoiceCallNotificationHandler;
    }

    public void setOnWalletPaymentStatusNotificationHandler(NotificationHandler<WalletPaymentStatusNotification, MessageBody> onWalletPaymentStatusNotificationHandler) {
        this.onWalletPaymentStatusNotificationHandler = onWalletPaymentStatusNotificationHandler;
    }


    public void setOnUssdSessionNotificationHandler(NotificationHandler<UssdSessionNotification, UssdMenu> onUssdSessionNotificationHandler) {
        this.onUssdSessionNotificationHandler = onUssdSessionNotificationHandler;
    }

    public void setOnSentMessageReactionNotificationHandler(NotificationHandler<SentMessageReactionNotification, MessageBody> onSentMessageReactionNotificationHandler) {
        this.onSentMessageReactionNotificationHandler = onSentMessageReactionNotificationHandler;
    }

    public void setOnReminderNotificationHandler(NotificationHandler<ReminderNotification, MessageBody> onReminderNotificationHandler) {
        this.onReminderNotificationHandler = onReminderNotificationHandler;
    }

    public void setOnReceivedWhatsappNotificationHandler(NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedWhatsappNotificationHandler) {
        this.onReceivedWhatsappNotificationHandler = onReceivedWhatsappNotificationHandler;
    }

    public void setOnReceivedTelegramNotificationHandler(NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedTelegramNotificationHandler) {
        this.onReceivedTelegramNotificationHandler = onReceivedTelegramNotificationHandler;
    }

    public void setOnReceivedPaymentNotificationHandler(NotificationHandler<ReceivedPaymentNotification, MessageBody> onReceivedPaymentNotificationHandler) {
        this.onReceivedPaymentNotificationHandler = onReceivedPaymentNotificationHandler;
    }

    public void setOnReceivedSmsNotificationHandler(NotificationHandler<ReceivedSmsNotification, MessageBody> onReceivedSmsNotificationHandler) {
        this.onReceivedSmsNotificationHandler = onReceivedSmsNotificationHandler;
    }

    public void setOnReceivedEmailNotificationHandler(NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedEmailNotificationHandler) {
        this.onReceivedEmailNotificationHandler = onReceivedEmailNotificationHandler;
    }

    public void setOnPaymentStatusNotificationHandler(NotificationHandler<PaymentStatusNotification, MessageBody> onPaymentStatusNotificationHandler) {
        this.onPaymentStatusNotificationHandler = onPaymentStatusNotificationHandler;
    }

    public void setOnReceivedFbMessengerNotificationHandler(NotificationHandler<ReceivedMediaNotification, MessageBody> onReceivedFbMessengerNotificationHandler) {
        this.onReceivedFbMessengerNotificationHandler = onReceivedFbMessengerNotificationHandler;
    }

    public void setOnMessagingSessionStartedNotificationHandler(NotificationHandler<MessagingSessionInitializedNotification, MessageBody> onMessagingSessionStartedNotificationHandler) {
        this.onMessagingSessionStartedNotificationHandler = onMessagingSessionStartedNotificationHandler;
    }

    public void setOnMessagingSessionRenewedNotificationHandler(NotificationHandler<MessagingSessionInitializedNotification, MessageBody> onMessagingSessionRenewedNotificationHandler) {
        this.onMessagingSessionRenewedNotificationHandler = onMessagingSessionRenewedNotificationHandler;
    }

    public void setOnMessagingSessionEndedNotificationHandler(NotificationHandler<MessagingSessionEndedNotification, MessageBody> onMessagingSessionEndedNotificationHandler) {
        this.onMessagingSessionEndedNotificationHandler = onMessagingSessionEndedNotificationHandler;
    }

    public void setOnCustomerActivityNotificationHandler(NotificationHandler<CustomerActivityNotification, MessageBody> onCustomerActivityNotificationHandler) {
        this.onCustomerActivityNotificationHandler = onCustomerActivityNotificationHandler;
    }

    public void setOnMessageStatusNotificationHandler(NotificationHandler<MessageStatusNotification, MessageBody> onMessageStatusNotificationHandler) {
        this.onMessageStatusNotificationHandler = onMessageStatusNotificationHandler;
    }

    public void setOnMessagingConsentUpdateNotificationHandler(NotificationHandler<MessagingConsentUpdateNotification, MessageBody> onMessagingConsentUpdateNotificationHandler) {
        this.onMessagingConsentUpdateNotificationHandler = onMessagingConsentUpdateNotificationHandler;
    }


    /**
     * Generate auth token
     *
     * @return
     */
    public Mono<AuthToken> generateAuthToken() {
        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setGenerateAuthToken(AppSocket.GenerateAuthTokenCommand.newBuilder().build())
                .build();

        return new Mono<AuthToken>() {
            @Override
            public void subscribe(CoreSubscriber<? super AuthToken> subscriber) {
                buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.GenerateAuthTokenReply res = reply.getGenerateAuthToken();
                    AuthToken token = new AuthToken(res.getToken(), res.getLifetime().getSeconds());
                    subscriber.onNext(token);
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    /**
     * Set a reminder to be triggered at the specified time for customers with the particular tag
     *
     * @param tag
     * @param reminder
     * @return
     */
    public Mono<TagUpdateReply> addCustomerReminderByTag(Tag tag, Reminder reminder) {

        AppModel.CustomerReminder.Builder rem = AppModel.CustomerReminder
                .newBuilder()
                .setKey(reminder.key)
                .setRemindAt(Timestamp.newBuilder()
                        .setSeconds(reminder.remindAt)
                        .build());

        if (reminder.payload != null) {
            rem.setPayload(StringValue.of(reminder.payload));
        }

        if (reminder.interval >= 60) {
            rem.setInterval(Duration.newBuilder()
                    .setSeconds(reminder.interval)
                    .build());
        }

        AppSocket.AddCustomerReminderTagCommand cmd = AppSocket.AddCustomerReminderTagCommand
                .newBuilder()
                .setTag(CommonModel.IndexMapping
                        .newBuilder()
                        .setKey(tag.key)
                        .setValue(StringValue.of(tag.value))
                        .build())
                .setReminder(rem)
                .build();
        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setAddCustomerReminderTag(cmd)
                .build();

        return new Mono<TagUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super TagUpdateReply> subscriber) {
                buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.TagCommandReply res = reply.getTagCommand();
                    TagUpdateReply tagUpdate = new TagUpdateReply(res.getStatus(), res.getWorkId().getValue(), res.getDescription());
                    subscriber.onNext(tagUpdate);
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    /**
     * Cancels a previously set reminder with tag and key
     *
     * @param tag
     * @param key
     * @return
     */
    public Mono<TagUpdateReply> cancelCustomerReminderByTag(Tag tag, String key) {
        AppSocket.CancelCustomerReminderTagCommand cmd = AppSocket.CancelCustomerReminderTagCommand
                .newBuilder()
                .setTag(CommonModel.IndexMapping
                        .newBuilder()
                        .setKey(tag.key)
                        .setValue(StringValue.of(tag.value))
                        .build())
                .setKey(key)
                .build();
        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setCancelCustomerReminderTag(cmd)
                .build();

        return new Mono<TagUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super TagUpdateReply> subscriber) {
                buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.TagCommandReply res = reply.getTagCommand();
                    TagUpdateReply tagUpdate = new TagUpdateReply(res.getStatus(), res.getWorkId().getValue(), res.getDescription());
                    subscriber.onNext(tagUpdate);
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    /**
     * Send a message by tag
     *
     * @param tag
     * @param channel
     * @param message
     * @return
     */
    public Mono<TagUpdateReply> sendMessageByTag(Tag tag, MessagingChannel channel, Message message) {
        AppSocket.SendMessageTagCommand cmd = AppSocket.SendMessageTagCommand
                .newBuilder()
                .setTag(CommonModel.IndexMapping
                        .newBuilder()
                        .setKey(tag.key)
                        .setValue(StringValue.of(tag.value))
                        .build())
                .setMessage(Utils.buildOutgoingMessage(message))
                .setChannelNumber(MessagingModel.MessagingChannelNumber
                        .newBuilder()
                        .setNumber(channel.number)
                        .setChannelValue(channel.channel.getValue())
                        .build())
                .build();
        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setSendMessageTag(cmd)
                .build();
        return new Mono<TagUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super TagUpdateReply> subscriber) {
                buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.TagCommandReply res = reply.getTagCommand();
                    TagUpdateReply tagUpdate = new TagUpdateReply(res.getStatus(), res.getWorkId().getValue(), res.getDescription());
                    subscriber.onNext(tagUpdate);
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    // From customer
    public Mono<InitiatePaymentReply> initiatePayment(PaymentCustomerCounterParty debitParty, PaymentCustomerCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentCustomerCounterParty debitParty, PaymentPurseCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentCustomerCounterParty debitParty, PaymentWalletCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentCustomerCounterParty debitParty, PaymentChannelCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    // From purse
    public Mono<InitiatePaymentReply> initiatePayment(PaymentPurseCounterParty debitParty, PaymentCustomerCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentPurseCounterParty debitParty, PaymentPurseCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentPurseCounterParty debitParty, PaymentWalletCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentPurseCounterParty debitParty, PaymentChannelCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    // From Wallet
    public Mono<InitiatePaymentReply> initiatePayment(PaymentWalletCounterParty debitParty, PaymentCustomerCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentWalletCounterParty debitParty, PaymentPurseCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentWalletCounterParty debitParty, PaymentWalletCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentWalletCounterParty debitParty, PaymentChannelCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    // From Channel
    public Mono<InitiatePaymentReply> initiatePayment(PaymentChannelCounterParty debitParty, PaymentCustomerCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentChannelCounterParty debitParty, PaymentPurseCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentChannelCounterParty debitParty, PaymentWalletCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    public Mono<InitiatePaymentReply> initiatePayment(PaymentChannelCounterParty debitParty, PaymentChannelCounterParty creditParty, Cash value) {
        return initiatePayment(new PaymentCounterParty(debitParty), new PaymentCounterParty(creditParty), value);
    }

    /**
     * Initiate a payment transaction
     *
     * @param debitParty
     * @param creditParty
     * @param value
     * @return
     */
    private Mono<InitiatePaymentReply> initiatePayment(PaymentCounterParty debitParty, PaymentCounterParty creditParty, Cash value) {
        AppSocket.InitiatePaymentCommand cmd = AppSocket.InitiatePaymentCommand
                .newBuilder()
                .setDebitParty(Utils.buildPaymentCounterParty(debitParty))
                .setCreditParty(Utils.buildPaymentCounterParty(creditParty))
                .setValue(CommonModel.Cash
                        .newBuilder()
                        .setAmount(value.amount)
                        .setCurrencyCode(value.currencyCode)
                        .build())
                .build();
        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setInitiatePayment(cmd)
                .build();

        return new Mono<InitiatePaymentReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super InitiatePaymentReply> subscriber) {
                buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.InitiatePaymentReply res = reply.getInitiatePayment();
                    InitiatePaymentReply result = new InitiatePaymentReply();
                    result.status = PaymentStatus.valueOf(res.getStatusValue());
                    result.transactionId = res.getTransactionId().getValue();
                    result.description = res.getDescription();
                    result.debitCustomerId = res.getDebitCustomerId().getValue();
                    result.creditCustomerId = res.getCreditCustomerId().getValue();
                    subscriber.onNext(result);
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }


    private void handlePurseNotification(AppSocket.ServerToAppPurseNotification notif, NotificationCallback<MessageBody> callback) {
        if (onPaymentStatusNotificationHandler != null) {
            PaymentStatusNotification payload = new PaymentStatusNotification();
            payload.orgId = notif.getOrgId();
            payload.appId = notif.getAppId();
            payload.purseId = notif.getPurseId();
            payload.createdAt = notif.getCreatedAt().getSeconds();
            payload.transactionId = notif.getPaymentStatus().getTransactionId();
            payload.status = PaymentStatus.valueOf(notif.getPaymentStatus().getStatusValue());
            onPaymentStatusNotificationHandler.handle(payload, null, null, callback);
        } else {
            callback.callback(null, null);
        }
    }

    private void handleCustomerNotification(AppSocket.ServerToAppCustomerNotification notif, NotificationCallback<MessageBody> callback) {
        DataMapValue appData = null;
        if (notif.hasAppData()) {
            String strVal = notif.getAppData().getStringVal();
            ByteString byteString = notif.getAppData().getBytesVal();
            if (byteString != null && !byteString.isEmpty()) {
                appData = DataMapValue.of(byteString.toByteArray());
            } else if (strVal != null && !strVal.isEmpty()) {
                appData = DataMapValue.of(strVal);
            }
        }

        Customer customer = new Customer(this, notif.getCustomerId());

        if (notif.hasReminder() && onReminderNotificationHandler != null) {

            ReminderNotification payload = Utils.fillInCustomerNotification(notif, new ReminderNotification());
            payload.workId = notif.getReminder().getWorkId().getValue();
            AppModel.CustomerReminder reminder = notif.getReminder().getReminder();
            payload.reminder = new Reminder(reminder.getKey(), reminder.getPayload().getValue(), reminder.getRemindAt().getSeconds(), reminder.getInterval().getSeconds());
            CommonModel.CustomerIndex tag = notif.getReminder().getTag();
            payload.tag = new Tag(tag.getMapping().getKey(), tag.getMapping().getValue().getValue(), tag.getExpiresAt().getSeconds());

            onReminderNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasMessagingSessionStarted() && onMessagingSessionStartedNotificationHandler != null) {

            MessagingSessionInitializedNotification payload = Utils.fillInCustomerNotification(notif, new MessagingSessionInitializedNotification());
            AppSocket.MessagingSessionStartedNotification msg = notif.getMessagingSessionStarted();
            payload.sessionId = msg.getSessionId();
            payload.expiresAt = msg.getExpiresAt().getSeconds();
            payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

            customer.customerNumber = payload.customerNumber;

            onMessagingSessionStartedNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasMessagingSessionRenewed() && onMessagingSessionRenewedNotificationHandler != null) {

            MessagingSessionInitializedNotification payload = Utils.fillInCustomerNotification(notif, new MessagingSessionInitializedNotification());
            AppSocket.MessagingSessionRenewedNotification msg = notif.getMessagingSessionRenewed();
            payload.sessionId = msg.getSessionId();
            payload.expiresAt = msg.getExpiresAt().getSeconds();
            payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

            customer.customerNumber = payload.customerNumber;

            onMessagingSessionRenewedNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasMessagingSessionEnded() && onMessagingSessionEndedNotificationHandler != null) {

            MessagingSessionEndedNotification payload = Utils.fillInCustomerNotification(notif, new MessagingSessionEndedNotification());
            AppSocket.MessagingSessionEndedNotification msg = notif.getMessagingSessionEnded();
            payload.sessionId = msg.getSessionId();
            payload.duration = msg.getDuration().getSeconds();
            payload.reason = MessagingSessionEndReason.valueOf(msg.getReasonValue());
            payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

            customer.customerNumber = payload.customerNumber;

            onMessagingSessionEndedNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasMessagingConsentUpdate() && onMessagingConsentUpdateNotificationHandler != null) {

            MessagingConsentUpdateNotification payload = Utils.fillInCustomerNotification(notif, new MessagingConsentUpdateNotification());
            AppSocket.MessagingConsentUpdateNotification msg = notif.getMessagingConsentUpdate();
            payload.update = ConsentAction.valueOf(msg.getUpdateValue());
            payload.status = MessagingConsentUpdateStatus.valueOf(msg.getStatusValue());
            payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

            customer.customerNumber = payload.customerNumber;

            onMessagingConsentUpdateNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasReceivedMessage()) {
            AppSocket.ReceivedMessageNotification msg = notif.getReceivedMessage();
            MessagingChannel.Channel channel = MessagingChannel.Channel.valueOf(msg.getChannelNumber().getChannel().getNumber());

            switch (channel.getValue()) {
                case 1: // MessagingChannel.Channel.SMS
                    ReceivedSmsNotification sms = Utils.fillInCustomerNotification(notif, new ReceivedSmsNotification());
                    sms.messageId = msg.getMessageId();
                    sms.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
                    sms.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

                    customer.customerNumber = sms.customerNumber;

                    sms.text = null;
                    if (msg.getPartsCount() > 0) {
                        sms.text = msg.getParts(0).getText();
                    }
                    if (onReceivedSmsNotificationHandler != null) {
                        onReceivedSmsNotificationHandler.handle(sms, customer, appData, callback);
                        return;
                    }
                    break;
                case 2: // MessagingChannel.Channel.VOICE
                    if (onVoiceCallNotificationHandler != null) {
                        VoiceCallNotification voiceNotif = Utils.fillInCustomerNotification(notif, new VoiceCallNotification());
                        voiceNotif.messageId = msg.getMessageId();
                        voiceNotif.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
                        voiceNotif.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());
                        voiceNotif.sessionId = msg.getSessionId().getValue();

                        customer.customerNumber = voiceNotif.customerNumber;

                        if (msg.getPartsCount() > 0) {
                            voiceNotif.voice = Utils.makeVoiceCallInput(msg.getParts(0).getVoice());
                        }

                        onVoiceCallNotificationHandler.handle(voiceNotif, customer, appData, (actions, data) -> {
                            MessageBody body = new MessageBody();
                            body.voice = actions;
                            callback.callback(body, data);
                        });
                        return;
                    }
                    break;
                case 3: // MessagingChannel.Channel.USSD:
                    if (onUssdSessionNotificationHandler != null) {
                        UssdSessionNotification ussd = Utils.fillInCustomerNotification(notif, new UssdSessionNotification());
                        ussd.messageId = msg.getMessageId();
                        ussd.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
                        ussd.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());

                        customer.customerNumber = ussd.customerNumber;

                        ussd.sessionId = msg.getSessionId().getValue();
                        ussd.input = null;
                        if (msg.getPartsCount() > 0) {
                            ussd.input = msg.getParts(0).getUssd().getValue();
                        }
                        onUssdSessionNotificationHandler.handle(ussd, customer, appData, (message, data) -> {
                            MessageBody body = new MessageBody();
                            body.ussd = message;
                            callback.callback(body, data);
                        });
                        return;
                    }
                    break;
                case 4: // MessagingChannel.Channel.FB_MESSENGER
                    if (onReceivedFbMessengerNotificationHandler != null) {
                        ReceivedMediaNotification fb_messenger = Utils.fillInCustomerNotification(notif, new ReceivedMediaNotification());
                        Utils.fillInMediaMessageNotification(msg, fb_messenger, customer);
                        onReceivedFbMessengerNotificationHandler.handle(fb_messenger, customer, appData, callback);
                        return;
                    }
                    break;
                case 5: // MessagingChannel.Channel.TELEGRAM
                    if (onReceivedTelegramNotificationHandler != null) {
                        ReceivedMediaNotification telegram = Utils.fillInCustomerNotification(notif, new ReceivedMediaNotification());
                        Utils.fillInMediaMessageNotification(msg, telegram, customer);
                        onReceivedTelegramNotificationHandler.handle(telegram, customer, appData, callback);
                        return;
                    }
                    break;
                case 6: // MessagingChannel.Channel.WHATSAPP
                    if (onReceivedWhatsappNotificationHandler != null) {
                        ReceivedMediaNotification whatsapp = Utils.fillInCustomerNotification(notif, new ReceivedMediaNotification());
                        Utils.fillInMediaMessageNotification(msg, whatsapp, customer);
                        onReceivedWhatsappNotificationHandler.handle(whatsapp, customer, appData, callback);
                        return;
                    }
                    break;
                case 7: // MessagingChannel.Channel.EMAIL
                    if (onReceivedEmailNotificationHandler != null) {
                        ReceivedMediaNotification email = Utils.fillInCustomerNotification(notif, new ReceivedMediaNotification());
                        Utils.fillInMediaMessageNotification(msg, email, customer);
                        onReceivedEmailNotificationHandler.handle(email, customer, appData, callback);
                        return;
                    }
                    break;
            }
            callback.callback(null, appData);

        } else if (notif.hasMessageStatus() && onMessageStatusNotificationHandler != null) {

            MessageStatusNotification payload = Utils.fillInCustomerNotification(notif, new MessageStatusNotification());
            payload.messageId = notif.getMessageStatus().getMessageId();
            payload.status = MessageDeliveryStatus.valueOf(notif.getMessageStatus().getStatusValue());

            onMessageStatusNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasSentMessageReaction() && onSentMessageReactionNotificationHandler != null) {

            SentMessageReactionNotification payload = Utils.fillInCustomerNotification(notif, new SentMessageReactionNotification());

            payload.messageId = notif.getSentMessageReaction().getMessageId();
            payload.channelNumber = Utils.makeMessagingChannel(notif.getSentMessageReaction().getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(notif.getSentMessageReaction().getCustomerNumber());
            payload.reaction = MessageReaction.valueOf(notif.getSentMessageReaction().getReactionValue());

            customer.customerNumber = payload.customerNumber;

            onSentMessageReactionNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasReceivedPayment() && onReceivedPaymentNotificationHandler != null) {

            ReceivedPaymentNotification payload = Utils.fillInCustomerNotification(notif, new ReceivedPaymentNotification());

            payload.purseId = notif.getReceivedPayment().getPurseId();
            payload.transactionId = notif.getReceivedPayment().getTransactionId();
            payload.channelNumber = Utils.makePaymentChannel(notif.getReceivedPayment().getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(notif.getCustomerActivity().getCustomerNumber());
            payload.status = PaymentStatus.valueOf(notif.getReceivedPayment().getStatus().getNumber());
            payload.value = new Cash(notif.getReceivedPayment().getValue().getCurrencyCode(), notif.getReceivedPayment().getValue().getAmount());

            customer.customerNumber = payload.customerNumber;

            onReceivedPaymentNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasPaymentStatus() && onPaymentStatusNotificationHandler != null) {

            PaymentStatusNotification payload = Utils.fillInCustomerNotification(notif, new PaymentStatusNotification());
            payload.transactionId = notif.getPaymentStatus().getTransactionId();
            payload.status = PaymentStatus.valueOf(notif.getPaymentStatus().getStatusValue());

            onPaymentStatusNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasWalletPaymentStatus() && onWalletPaymentStatusNotificationHandler != null) {

            WalletPaymentStatusNotification payload = Utils.fillInCustomerNotification(notif, new WalletPaymentStatusNotification());
            payload.walletId = notif.getWalletPaymentStatus().getWalletId();
            payload.transactionId = notif.getWalletPaymentStatus().getTransactionId();
            payload.status = PaymentStatus.valueOf(notif.getWalletPaymentStatus().getStatusValue());

            onWalletPaymentStatusNotificationHandler.handle(payload, customer, appData, callback);

        } else if (notif.hasCustomerActivity() && onCustomerActivityNotificationHandler != null) {

            CustomerActivityNotification payload = Utils.fillInCustomerNotification(notif, new CustomerActivityNotification());
            payload.sessionId = notif.getCustomerActivity().getSessionId();
            payload.activity = new Activity(
                    notif.getCustomerActivity().getActivity().getKey(),
                    notif.getCustomerActivity().getActivity().getPropertiesMap(),
                    notif.getCustomerActivity().getSessionId(),
                    notif.getCustomerActivity().getActivity().getCreatedAt().getSeconds()
            );
            payload.channelNumber = Utils.makeActivityChannel(notif.getCustomerActivity().getChannelNumber());
            payload.customerNumber = Utils.makeCustomerNumber(notif.getCustomerActivity().getCustomerNumber());

            customer.customerNumber = payload.customerNumber;

            onCustomerActivityNotificationHandler.handle(payload, customer, appData, callback);
        } else {
            callback.callback(null, appData);
        }
    }

    @Override
    protected byte[] serializeNotificationReply(AppSocket.ServerToAppNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected byte[] serializeSetupPayload(ClientConfig opts) {
        AppSocket.AppConnectionMetadata.Builder builder = AppSocket.AppConnectionMetadata.newBuilder()
                .setAppId(opts.appId)
                .setOrgId(opts.orgId)
                .setApiKey(StringValue.newBuilder().setValue(opts.apiKey));

        builder.setSimplexMode(!opts.allowNotifications);
        builder.setSimulatorMode(false);
        return builder.build().toByteArray();
    }

    @Override
    protected AppSocket.ServerToAppNotification deserializeNotification(byte[] data) throws RuntimeException {
        try {
            return AppSocket.ServerToAppNotification.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
