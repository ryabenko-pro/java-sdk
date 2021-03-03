package com.elarian.hera.android;

import com.google.protobuf.StringValue;
import reactor.core.publisher.Mono;
import com.elarian.hera.proto.CommonModel.*;
import com.elarian.hera.proto.PaymentModel.*;
import com.elarian.hera.proto.MessagingModel.*;
import com.elarian.hera.proto.SimulatorSocket.*;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Simulator extends Client<ServerToSimulatorNotification, ServerToSimulatorNotificationReply> {

    public Simulator(String authToken, String orgId, String appId) {
        super(new ClientOpts(authToken, orgId, appId, true), new ConnectionConfig());
    }

    public static Simulator newInstance(String authToken, String orgId, String appId) throws RuntimeException {
        return newInstance(authToken, orgId, appId, null);
    }

    public static Simulator newInstance(String authToken, String orgId, String appId, Consumer<Throwable> onConnectionError) throws RuntimeException {
        Simulator client = new Simulator(authToken, orgId, appId);
        client.connect(onConnectionError);
        return client;
    }

    private final Function<byte[], SimulatorToServerCommandReply> replyDeserializer = (data) -> {
        try {
            return SimulatorToServerCommandReply.newBuilder().mergeFrom(data).build();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    };


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

    @Override
    protected byte[] serializeNotificationReply(ServerToSimulatorNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected ServerToSimulatorNotification deserializeNotification(byte[] data) throws InvalidProtocolBufferException {
        return ServerToSimulatorNotification.parseFrom(data);
    }
}
