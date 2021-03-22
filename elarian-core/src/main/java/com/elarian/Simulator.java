package com.elarian;

import com.elarian.model.*;
import com.elarian.hera.proto.AppSocket;
import com.elarian.hera.proto.CommonModel;
import com.elarian.hera.proto.MessagingModel;
import com.elarian.hera.proto.PaymentModel;
import com.elarian.hera.proto.SimulatorSocket;
import com.google.protobuf.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public final class Simulator extends Client<SimulatorSocket.ServerToSimulatorNotification, SimulatorSocket.ServerToSimulatorNotificationReply> {

    private final Function<byte[], SimulatorReply> replyDeserializer = (data) -> {
        try {
            SimulatorSocket.SimulatorToServerCommandReply reply = SimulatorSocket.SimulatorToServerCommandReply.newBuilder().mergeFrom(data).build();
            SimulatorReply res = new SimulatorReply();
            res.status = reply.getStatus();
            res.description = reply.getDescription();
            res.message = Utils.makeMessage(reply.getMessage());
            return res;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    };
    private NotificationHandler<SendMessageSimulatorNotification, MessageBody> onSendMessageNotificationHandler;
    private NotificationHandler<MakeVoiceCallSimulatorNotification, MessageBody> onMakeVoiceCallNotificationHandler;
    private NotificationHandler<SendCustomerPaymentSimulatorNotification, MessageBody> onSendCustomerPaymentNotificationHandler;
    private NotificationHandler<SendChannelPaymentSimulatorNotification, MessageBody> onSendChannelPaymentNotificationHandler;
    private NotificationHandler<CheckoutPaymentSimulatorNotification, MessageBody> onCheckoutPaymentNotificationHandler;

    public Simulator(String apiKey, String orgId, String appId) {
        this(apiKey, orgId, appId, new ConnectionConfig());
    }

    public Simulator(String apiKey, String orgId, String appId, ConnectionConfig connectionConfig) {
        super(new ClientConfig(apiKey, orgId, appId, true, connectionConfig));

        registerGlobalNotificationHandler((Function<SimulatorSocket.ServerToSimulatorNotification, Mono<SimulatorSocket.ServerToSimulatorNotificationReply>>) notif -> new Mono<SimulatorSocket.ServerToSimulatorNotificationReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super SimulatorSocket.ServerToSimulatorNotificationReply> subscriber) {

                boolean isSendMessageNotification = notif.hasSendMessage();
                boolean isMakeVoiceCallNotification = notif.hasMakeVoiceCall();
                boolean isCheckoutPaymentNotification = notif.hasCheckoutPayment();
                boolean isSendChannelPaymentNotification = notif.hasSendChannelPayment();
                boolean isSendCustomerPaymentNotification = notif.hasSendCustomerPayment();

                NotificationCallback<MessageBody> callback = (message, data) -> {
                    SimulatorSocket.ServerToSimulatorNotificationReply reply = SimulatorSocket.ServerToSimulatorNotificationReply
                            .newBuilder()
                            .build();
                    subscriber.onNext(reply);
                    subscriber.onComplete();
                };

                if (isSendMessageNotification && onSendMessageNotificationHandler != null) {
                    SendMessageSimulatorNotification payload = new SendMessageSimulatorNotification();
                    SimulatorSocket.SendMessageSimulatorNotification msg = notif.getSendMessage();
                    payload.orgId = msg.getOrgId();
                    payload.customerId = msg.getCustomerId();
                    payload.messageId = msg.getMessageId();
                    payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());
                    payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());
                    payload.message = Utils.makeMessage(msg.getMessage());

                    onSendMessageNotificationHandler.handle(payload, null, null, callback);

                } else if (isMakeVoiceCallNotification && onMakeVoiceCallNotificationHandler != null) {
                    MakeVoiceCallSimulatorNotification payload = new MakeVoiceCallSimulatorNotification();
                    SimulatorSocket.MakeVoiceCallSimulatorNotification msg = notif.getMakeVoiceCall();
                    payload.orgId = msg.getOrgId();
                    payload.customerId = msg.getCustomerId();
                    payload.sessionId = msg.getSessionId();
                    payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());
                    payload.channelNumber = Utils.makeMessagingChannel(msg.getChannelNumber());

                    onMakeVoiceCallNotificationHandler.handle(payload, null, null, callback);

                } else if (isSendCustomerPaymentNotification && onSendCustomerPaymentNotificationHandler != null) {
                    SendCustomerPaymentSimulatorNotification payload = new SendCustomerPaymentSimulatorNotification();
                    SimulatorSocket.SendCustomerPaymentSimulatorNotification msg = notif.getSendCustomerPayment();
                    payload.orgId = msg.getOrgId();
                    payload.customerId = msg.getCustomerId();
                    payload.appId = msg.getAppId();
                    payload.transactionId = msg.getTransactionId();
                    payload.customerNumber = Utils.makeCustomerNumber(msg.getCustomerNumber());
                    payload.channelNumber = Utils.makePaymentChannel(msg.getChannelNumber());
                    payload.value = new Cash(msg.getValue().getCurrencyCode(), msg.getValue().getAmount());

                    if (msg.hasWallet()) {
                        payload.wallet = new PaymentWalletCounterParty(msg.getWallet().getCustomerId(), msg.getWallet().getWalletId());
                    }

                    if (msg.hasPurse()) {
                        payload.purse = new PaymentPurseCounterParty(msg.getPurse().getPurseId());
                    }

                    onSendCustomerPaymentNotificationHandler.handle(payload, null, null, callback);

                } else if (isSendChannelPaymentNotification && onSendChannelPaymentNotificationHandler != null) {
                    SendChannelPaymentSimulatorNotification payload = new SendChannelPaymentSimulatorNotification();
                    SimulatorSocket.SendChannelPaymentSimulatorNotification msg = notif.getSendChannelPayment();
                    payload.orgId = msg.getOrgId();
                    payload.appId = msg.getAppId();
                    payload.transactionId = msg.getTransactionId();
                    payload.channelNumber = Utils.makePaymentChannel(msg.getChannelNumber());
                    payload.account = msg.getAccount().getValue();
                    payload.value = new Cash(msg.getValue().getCurrencyCode(), msg.getValue().getAmount());

                    if (msg.hasWallet()) {
                        payload.wallet = new PaymentWalletCounterParty(msg.getWallet().getCustomerId(), msg.getWallet().getWalletId());
                    }

                    if (msg.hasPurse()) {
                        payload.purse = new PaymentPurseCounterParty(msg.getPurse().getPurseId());
                    }

                    onSendChannelPaymentNotificationHandler.handle(payload, null, null, callback);

                } else if (isCheckoutPaymentNotification && onCheckoutPaymentNotificationHandler != null) {

                    CheckoutPaymentSimulatorNotification payload = new CheckoutPaymentSimulatorNotification();
                    SimulatorSocket.CheckoutPaymentSimulatorNotification msg = notif.getCheckoutPayment();
                    payload.orgId = msg.getOrgId();
                    payload.appId = msg.getAppId();
                    payload.transactionId = msg.getTransactionId();
                    payload.channelNumber = Utils.makePaymentChannel(msg.getChannelNumber());
                    payload.value = new Cash(msg.getValue().getCurrencyCode(), msg.getValue().getAmount());

                    if (msg.hasWallet()) {
                        payload.wallet = new PaymentWalletCounterParty(msg.getWallet().getCustomerId(), msg.getWallet().getWalletId());
                    }

                    if (msg.hasPurse()) {
                        payload.purse = new PaymentPurseCounterParty(msg.getPurse().getPurseId());
                    }

                    onCheckoutPaymentNotificationHandler.handle(payload, null, null, callback);

                } else {
                    callback.callback(null, null);
                }
            }
        });
    }

    @Override
    protected byte[] serializeSetupPayload(ClientConfig clientOpts) {
        AppSocket.AppConnectionMetadata.Builder builder = AppSocket.AppConnectionMetadata.newBuilder()
                .setAppId(clientOpts.appId)
                .setOrgId(clientOpts.orgId)
                .setApiKey(StringValue.newBuilder().setValue(clientOpts.apiKey));
        builder.setSimulatorMode(true);
        builder.setSimplexMode(false);
        return builder.build().toByteArray();
    }

    @Override
    protected byte[] serializeNotificationReply(SimulatorSocket.ServerToSimulatorNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected SimulatorSocket.ServerToSimulatorNotification deserializeNotification(byte[] data) throws RuntimeException {
        try {
            return SimulatorSocket.ServerToSimulatorNotification.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setOnSendMessageNotificationHandler(NotificationHandler<SendMessageSimulatorNotification, MessageBody> onSendMessageNotificationHandler) {
        this.onSendMessageNotificationHandler = onSendMessageNotificationHandler;
    }

    public void setOnCheckoutPaymentNotificationHandler(NotificationHandler<CheckoutPaymentSimulatorNotification, MessageBody> onCheckoutPaymentNotificationHandler) {
        this.onCheckoutPaymentNotificationHandler = onCheckoutPaymentNotificationHandler;
    }

    public void setOnMakeVoiceCallNotificationHandler(NotificationHandler<MakeVoiceCallSimulatorNotification, MessageBody> onMakeVoiceCallNotificationHandler) {
        this.onMakeVoiceCallNotificationHandler = onMakeVoiceCallNotificationHandler;
    }

    public void setOnSendChannelPaymentNotificationHandler(NotificationHandler<SendChannelPaymentSimulatorNotification, MessageBody> onSendChannelPaymentNotificationHandler) {
        this.onSendChannelPaymentNotificationHandler = onSendChannelPaymentNotificationHandler;
    }

    public void setOnSendCustomerPaymentNotificationHandler(NotificationHandler<SendCustomerPaymentSimulatorNotification, MessageBody> onSendCustomerPaymentNotificationHandler) {
        this.onSendCustomerPaymentNotificationHandler = onSendCustomerPaymentNotificationHandler;
    }

    /**
     * Receive a message
     *
     * @param customerNumber
     * @param channelNumber
     * @param messageParts
     * @param sessionId
     * @return
     */
    public Mono<SimulatorReply> receiveMessage(String customerNumber, MessagingChannel channelNumber, List<SimulatorMessageBody> messageParts, String sessionId) {
        SimulatorSocket.ReceiveMessageSimulatorCommand cmd = SimulatorSocket.ReceiveMessageSimulatorCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .setChannelNumber(MessagingModel.MessagingChannelNumber
                        .newBuilder()
                        .setNumber(channelNumber.number)
                        .setChannelValue(channelNumber.channel.getValue())
                        .build())
                .addAllParts(messageParts.stream().map((item) -> {
                    MessagingModel.InboundMessageBody.Builder result = MessagingModel.InboundMessageBody.newBuilder();
                    if (item.text != null) {
                        return result.setText(item.text).build();
                    }
                    if (item.media != null) {
                        return result.setMedia(MessagingModel.MediaMessageBody
                                .newBuilder()
                                .setUrl(item.media.url)
                                .setMedia(CommonModel.MediaType.forNumber(item.media.type.getValue()))
                                .build())
                                .build();
                    }
                    if (item.location != null) {
                        return result.setLocation(MessagingModel.LocationMessageBody
                                .newBuilder()
                                .setLongitude(item.location.longitude)
                                .setLatitude(item.location.latitude)
                                .setLabel(StringValue.of(item.location.label))
                                .setAddress(StringValue.of(item.location.address))
                                .build()).build();
                    }
                    if (item.email != null) {
                        return result.setEmail(MessagingModel.EmailMessageBody
                                .newBuilder()
                                .setBodyPlain(item.email.plain)
                                .setBodyHtml(item.email.html)
                                .setSubject(item.email.subject)
                                .addAllCcList(item.email.cc)
                                .addAllBccList(item.email.bcc)
                                .addAllAttachments(item.email.attachments)
                                .build()).build();
                    }
                    if (item.voice != null) {
                        return result.setVoice(MessagingModel.VoiceCallInputMessageBody
                                .newBuilder()
                                .setDirectionValue(item.voice.direction.getValue())
                                .setStatusValue(item.voice.status.getValue())
                                .setStartedAt(Timestamp.newBuilder().setSeconds(item.voice.startedAt).build())
                                .setHangupCauseValue(item.voice.hangupCause.getValue())
                                .setDtmfDigits(item.voice.dtmfDigits == null ? StringValue.getDefaultInstance() : StringValue.of(item.voice.dtmfDigits))
                                .setRecordingUrl(item.voice.recordingUrl == null ? StringValue.getDefaultInstance()  : StringValue.of(item.voice.recordingUrl))
                                .setDialData(MessagingModel.VoiceCallDialInput
                                        .newBuilder()
                                        .setDestinationNumber(item.voice.dialData.destinationNumber)
                                        .setStartedAt(Timestamp.newBuilder().setSeconds(item.voice.dialData.startedAt).build())
                                        .setDuration(Duration.newBuilder().setSeconds(item.voice.dialData.duration).build())
                                        .build())
                                .setQueueData(MessagingModel.VoiceCallQueueInput
                                        .newBuilder()
                                        .setEnqueuedAt(Timestamp.newBuilder().setSeconds(item.voice.queueData.enqueuedAt).build())
                                        .setDequeuedAt(Timestamp.newBuilder().setSeconds(item.voice.queueData.dequeuedAt).build())
                                        .setDequeuedToNumber(StringValue.of(item.voice.queueData.dequeuedToNumber))
                                        .setDequeuedToSessionId(StringValue.of(item.voice.queueData.dequeuedToSessionId))
                                        .setQueueDuration(Duration.newBuilder().setSeconds(item.voice.queueData.queueDuration).build())
                                        .build())
                                .build()).build();
                    }
                    if (item.ussd != null) {
                        return result.setUssd(StringValue.of(item.ussd)).build();
                    }
                    return result.build();
                }).collect(Collectors.toList()))
                .setSessionId(StringValue.newBuilder().setValue(sessionId))
                .build();
        SimulatorSocket.SimulatorToServerCommand req = SimulatorSocket.SimulatorToServerCommand
                .newBuilder()
                .setReceiveMessage(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

    /**
     * Receive payment
     *
     * @param transactionId
     * @param channelNumber
     * @param customerNumber
     * @param value
     * @param status
     * @return
     */
    public Mono<SimulatorReply> receivePayment(String transactionId, PaymentChannel channelNumber, String customerNumber, Cash value, PaymentStatus status) {
        SimulatorSocket.ReceivePaymentSimulatorCommand cmd = SimulatorSocket.ReceivePaymentSimulatorCommand
                .newBuilder()
                .setValue(CommonModel.Cash
                        .newBuilder()
                        .setAmount(value.amount)
                        .setCurrencyCode(value.currencyCode)
                        .build())
                .setStatusValue(status.getValue())
                .setTransactionId(transactionId)
                .setChannelNumber(PaymentModel.PaymentChannelNumber
                        .newBuilder()
                        .setNumber(channelNumber.number)
                        .setChannelValue(channelNumber.channel.getValue())
                        .build())
                .setCustomerNumber(customerNumber)
                .build();
        SimulatorSocket.SimulatorToServerCommand req = SimulatorSocket.SimulatorToServerCommand
                .newBuilder()
                .setReceivePayment(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

    /**
     * Update payment status
     *
     * @param transactionId
     * @param status
     * @return
     */
    public Mono<SimulatorReply> updatePaymentStatus(String transactionId, PaymentStatus status) {
        SimulatorSocket.UpdatePaymentStatusSimulatorCommand cmd = SimulatorSocket.UpdatePaymentStatusSimulatorCommand
                .newBuilder()
                .setTransactionId(transactionId)
                .setStatusValue(status.getValue())
                .build();
        SimulatorSocket.SimulatorToServerCommand req = SimulatorSocket.SimulatorToServerCommand
                .newBuilder()
                .setUpdatePaymentStatus(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

}
