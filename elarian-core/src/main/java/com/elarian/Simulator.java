package com.elarian;

import com.elarian.hera.proto.AppSocket.*;
import com.elarian.hera.proto.SimulatorSocket.*;
import com.elarian.hera.proto.PaymentModel.*;
import com.elarian.hera.proto.CommonModel.*;
import com.elarian.hera.proto.MessagingModel.*;
import com.elarian.model.ClientConfig;
import com.elarian.model.ConnectionConfig;
import com.elarian.model.NotificationCallback;
import com.elarian.model.NotificationHandler;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;

import java.util.List;
import java.util.function.Function;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public final class Simulator extends Client<ServerToSimulatorNotification, ServerToSimulatorNotificationReply> {

    private NotificationHandler<SendMessageSimulatorNotification, OutboundMessage, String> onSendMessageNotificationHandler;
    private NotificationHandler<MakeVoiceCallSimulatorNotification, OutboundMessage, String> onMakeVoiceCallNotificationHandler;
    private NotificationHandler<SendCustomerPaymentSimulatorNotification, OutboundMessage, String> onSendCustomerPaymentNotificationHandler;
    private NotificationHandler<SendChannelPaymentSimulatorNotification, OutboundMessage, String> onSendChannelPaymentNotificationHandler;
    private NotificationHandler<CheckoutPaymentSimulatorNotification, OutboundMessage, String> onCheckoutPaymentNotificationHandler;

    private final Function<byte[], SimulatorToServerCommandReply> replyDeserializer = (data) -> {
        try {
            return SimulatorToServerCommandReply.newBuilder().mergeFrom(data).build();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    };

    public Simulator(String apiKey, String orgId, String appId) {
        this(apiKey, orgId, appId, new ConnectionConfig());
    }

    public Simulator(String apiKey, String orgId, String appId, ConnectionConfig connectionConfig) {
        super(new ClientConfig(apiKey, orgId, appId, true, connectionConfig));

        registerGlobalNotificationHandler(new Function<ServerToSimulatorNotification, Mono<ServerToSimulatorNotificationReply>>() {
            @Override
            public Mono<ServerToSimulatorNotificationReply> apply(ServerToSimulatorNotification notif) {
                return new Mono<ServerToSimulatorNotificationReply>() {
                    @Override
                    public void subscribe(CoreSubscriber<? super ServerToSimulatorNotificationReply> subscriber) {

                        boolean isSendMessageNotification = notif.hasSendMessage();
                        boolean isMakeVoiceCallNotification = notif.hasMakeVoiceCall();
                        boolean isCheckoutPaymentNotification = notif.hasCheckoutPayment();
                        boolean isSendChannelPaymentNotification = notif.hasSendChannelPayment();
                        boolean isSendCustomerPaymentNotification = notif.hasSendCustomerPayment();

                        NotificationCallback<OutboundMessage, String> callback = (message, data) -> {
                            ServerToSimulatorNotificationReply reply = ServerToSimulatorNotificationReply
                                    .newBuilder()
                                    .build();
                            subscriber.onNext(reply);
                            subscriber.onComplete();
                        };

                        if (isSendMessageNotification && onSendMessageNotificationHandler != null) {
                            onSendMessageNotificationHandler.handle(notif.getSendMessage(), null, null, callback);
                        } else if (isMakeVoiceCallNotification && onMakeVoiceCallNotificationHandler != null) {
                            onMakeVoiceCallNotificationHandler.handle(notif.getMakeVoiceCall(), null, null, callback);
                        } else if (isSendCustomerPaymentNotification && onSendCustomerPaymentNotificationHandler != null) {
                            onSendCustomerPaymentNotificationHandler.handle(notif.getSendCustomerPayment(), null, null, callback);
                        } else if (isSendChannelPaymentNotification && onSendChannelPaymentNotificationHandler != null) {
                            onSendChannelPaymentNotificationHandler.handle(notif.getSendChannelPayment(), null, null, callback);
                        } else if (isCheckoutPaymentNotification && onCheckoutPaymentNotificationHandler != null){
                            onCheckoutPaymentNotificationHandler.handle(notif.getCheckoutPayment(), null, null, callback);
                        } else {
                            callback.callback(null, null);
                        }
                    }
                };
            }
        });
    }

    @Override
    protected byte[] serializeSetupPayload(ClientConfig clientOpts) {
        AppConnectionMetadata.Builder builder = AppConnectionMetadata.newBuilder()
                .setAppId(clientOpts.appId)
                .setOrgId(clientOpts.orgId)
                .setApiKey(StringValue.newBuilder().setValue(clientOpts.apiKey));
        builder.setSimulatorMode(true);
        builder.setSimplexMode(false);
        return builder.build().toByteArray();
    }

    @Override
    protected byte[] serializeNotificationReply(ServerToSimulatorNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected ServerToSimulatorNotification deserializeNotification(byte[] data) throws RuntimeException {
        try {
            return ServerToSimulatorNotification.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setOnSendMessageNotificationHandler(NotificationHandler<SendMessageSimulatorNotification, OutboundMessage, String> onSendMessageNotificationHandler) {
        this.onSendMessageNotificationHandler = onSendMessageNotificationHandler;
    }

    public void setOnCheckoutPaymentNotificationHandler(NotificationHandler<CheckoutPaymentSimulatorNotification, OutboundMessage, String> onCheckoutPaymentNotificationHandler) {
        this.onCheckoutPaymentNotificationHandler = onCheckoutPaymentNotificationHandler;
    }

    public void setOnMakeVoiceCallNotificationHandler(NotificationHandler<MakeVoiceCallSimulatorNotification, OutboundMessage, String> onMakeVoiceCallNotificationHandler) {
        this.onMakeVoiceCallNotificationHandler = onMakeVoiceCallNotificationHandler;
    }

    public void setOnSendChannelPaymentNotificationHandler(NotificationHandler<SendChannelPaymentSimulatorNotification, OutboundMessage, String> onSendChannelPaymentNotificationHandler) {
        this.onSendChannelPaymentNotificationHandler = onSendChannelPaymentNotificationHandler;
    }

    public void setOnSendCustomerPaymentNotificationHandler(NotificationHandler<SendCustomerPaymentSimulatorNotification, OutboundMessage, String> onSendCustomerPaymentNotificationHandler) {
        this.onSendCustomerPaymentNotificationHandler = onSendCustomerPaymentNotificationHandler;
    }

    /**
     * Receive a message
     * @param customerNumber
     * @param channelNumber
     * @param parts
     * @param sessionId
     * @return
     */
    public Mono<SimulatorToServerCommandReply> receiveMessage(String customerNumber, MessagingChannelNumber channelNumber, List<InboundMessageBody> parts, String sessionId) {
        ReceiveMessageSimulatorCommand cmd = ReceiveMessageSimulatorCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .setChannelNumber(channelNumber)
                .addAllParts(parts)
                .setSessionId(StringValue.newBuilder().setValue(sessionId))
                .build();
        SimulatorToServerCommand req = SimulatorToServerCommand
                .newBuilder()
                .setReceiveMessage(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

    /**
     * Receive payment
     * @param transactionId
     * @param channelNumber
     * @param customerNumber
     * @param value
     * @param status
     * @return
     */
    public Mono<SimulatorToServerCommandReply> receivePayment(String transactionId, PaymentChannelNumber channelNumber, String customerNumber, Cash value, PaymentStatus status) {
        ReceivePaymentSimulatorCommand cmd = ReceivePaymentSimulatorCommand
                .newBuilder()
                .setValue(value)
                .setStatus(status)
                .setTransactionId(transactionId)
                .setChannelNumber(channelNumber)
                .setCustomerNumber(customerNumber)
                .build();
        SimulatorToServerCommand req = SimulatorToServerCommand
                .newBuilder()
                .setReceivePayment(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

    /**
     * Update payment status
     * @param transactionId
     * @param status
     * @return
     */
    public Mono<SimulatorToServerCommandReply> updatePaymentStatus(String transactionId, PaymentStatus status) {
        UpdatePaymentStatusSimulatorCommand cmd = UpdatePaymentStatusSimulatorCommand
                .newBuilder()
                .setTransactionId(transactionId)
                .setStatus(status)
                .build();
        SimulatorToServerCommand req = SimulatorToServerCommand
                .newBuilder()
                .setUpdatePaymentStatus(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), replyDeserializer);
    }

}
