package com.elarian.hera.android;

import com.elarian.hera.proto.ActivityModel;
import reactor.core.publisher.Mono;
import com.elarian.hera.proto.AppModel.*;
import com.elarian.hera.proto.AppSocket.*;
import com.elarian.hera.proto.CommonModel.*;
import com.elarian.hera.proto.PaymentModel.*;
import com.elarian.hera.proto.MessagingModel.*;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class Elarian extends Client<ServerToAppNotification, ServerToAppNotificationReply> {

    public Elarian(String authToken, String orgId, String appId) {
        super(new ClientOpts(authToken, orgId, appId, false), new ConnectionConfig());
    }

    public static Elarian newInstance(String authToken, String orgId, String appId) throws RuntimeException {
        return newInstance(authToken, orgId, appId, null);
    }

    public static Elarian newInstance(String authToken, String orgId, String appId, Consumer<Throwable> onConnectionError) throws RuntimeException {
        Elarian client = new Elarian(authToken, orgId, appId);
        client.connect(onConnectionError);
        return client;
    }

    @Override
    protected byte[] serializeNotificationReply(ServerToAppNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected ServerToAppNotification deserializeNotification(byte[] data) throws InvalidProtocolBufferException {
        return ServerToAppNotification.parseFrom(data);
    }


    /**
     * Generate auth token
     * @return
     */
    public Mono<GenerateAuthTokenReply> generateAuthToken() {
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setGenerateAuthToken(GenerateAuthTokenCommand.newBuilder().build())
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply
                        .newBuilder()
                        .mergeFrom(bytes)
                        .build()
                        .getGenerateAuthToken();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Get customer state
     * @param customerNumber
     * @return
     */
    public Mono<GetCustomerStateReply> getCustomerState(CustomerNumber customerNumber) {
        GetCustomerStateCommand cmd = GetCustomerStateCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setGetCustomerState(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply
                        .newBuilder()
                        .mergeFrom(bytes)
                        .build()
                        .getGetCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Adopt other customer's state
     * @param customerId
     * @param otherCustomerNumber
     * @return
     */
    public Mono<UpdateCustomerStateReply> adoptCustomerState(String customerId, CustomerNumber otherCustomerNumber) {
        AdoptCustomerStateCommand cmd = AdoptCustomerStateCommand
                .newBuilder()
                .setCustomerId(customerId)
                .setOtherCustomerNumber(otherCustomerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setAdoptCustomerState(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Add customer reminder
     * @param customerNumber
     * @param reminder
     * @return
     */
    public Mono<UpdateCustomerAppDataReply> addCustomerReminder(CustomerNumber customerNumber, CustomerReminder reminder) {
        AddCustomerReminderCommand cmd = AddCustomerReminderCommand
                .newBuilder()
                .setReminder(reminder)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setAddCustomerReminder(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerAppData();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Add customer reminder by tag
     * @param tag
     * @param reminder
     * @return
     */
    public Mono<TagCommandReply> addCustomerReminderByTag(IndexMapping tag, CustomerReminder reminder) {
        AddCustomerReminderTagCommand cmd = AddCustomerReminderTagCommand
                .newBuilder()
                .setTag(tag)
                .setReminder(reminder)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setAddCustomerReminderTag(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getTagCommand();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Cancel customer reminder
     * @param customerNumber
     * @param key
     * @return
     */
    public Mono<UpdateCustomerStateReply> cancelCustomerReminder(CustomerNumber customerNumber, String key) {
        CancelCustomerReminderCommand cmd = CancelCustomerReminderCommand
                .newBuilder()
                .setKey(key)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setCancelCustomerReminder(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Cancel customer reminder by tag
     * @param tag
     * @param key
     * @return
     */
    public Mono<TagCommandReply> cancelCustomerReminderByTag(IndexMapping tag, String key) {
        CancelCustomerReminderTagCommand cmd = CancelCustomerReminderTagCommand
                .newBuilder()
                .setTag(tag)
                .setKey(key)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setCancelCustomerReminderTag(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getTagCommand();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Update customer tags
     * @param customerNumber
     * @param tags
     * @return
     */
    public Mono<UpdateCustomerStateReply> updateCustomerTags(CustomerNumber customerNumber, List<CustomerIndex> tags) {
        UpdateCustomerTagCommand cmd = UpdateCustomerTagCommand
                .newBuilder()
                .addAllUpdates(tags)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setUpdateCustomerTag(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Delete customer tags
     * @param customerNumber
     * @param keys
     * @return
     */
    public Mono<UpdateCustomerStateReply> deleteCustomerTags(CustomerNumber customerNumber, List<String> keys) {
        DeleteCustomerTagCommand cmd = DeleteCustomerTagCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setDeleteCustomerTag(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }


    /**
     * Update customer secondary ids
     * @param customerNumber
     * @param secondaryIds
     * @return
     */
    public Mono<UpdateCustomerStateReply> updateCustomerSecondaryId(CustomerNumber customerNumber, List<CustomerIndex> secondaryIds) {
        UpdateCustomerSecondaryIdCommand cmd = UpdateCustomerSecondaryIdCommand
                .newBuilder()
                .addAllUpdates(secondaryIds)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setUpdateCustomerSecondaryId(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Delete customer secondary ids
     * @param customerNumber
     * @param keys
     * @return
     */
    public Mono<UpdateCustomerStateReply> deleteCustomerSecondaryIds(CustomerNumber customerNumber, List<IndexMapping> keys) {
        DeleteCustomerSecondaryIdCommand cmd = DeleteCustomerSecondaryIdCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setDeleteCustomerSecondaryId(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }


    /**
     * Update customer metadata
     * @param customerNumber
     * @param updates
     * @return
     */
    public Mono<UpdateCustomerStateReply> updateCustomerMetadata(CustomerNumber customerNumber, Map<String, DataMapValue> updates) {
        UpdateCustomerMetadataCommand cmd = UpdateCustomerMetadataCommand
                .newBuilder()
                .putAllUpdates(updates)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setUpdateCustomerMetadata(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Delete customer metadata
     * @param customerNumber
     * @param keys
     * @return
     */
    public Mono<UpdateCustomerStateReply> deleteCustomerMetadata(CustomerNumber customerNumber, List<String> keys) {
        DeleteCustomerMetadataCommand cmd = DeleteCustomerMetadataCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setDeleteCustomerMetadata(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Lease a customer's app data
     * @param customerNumber
     * @return
     */
    public Mono<LeaseCustomerAppDataReply> leaseCustomerAppData(CustomerNumber customerNumber) {
        LeaseCustomerAppDataCommand cmd = LeaseCustomerAppDataCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setLeaseCustomerAppData(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getLeaseCustomerAppData();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Update customer app data
     * @param customerNumber
     * @param update
     * @return
     */
    public Mono<UpdateCustomerAppDataReply> updateCustomerAppData(CustomerNumber customerNumber, DataMapValue update) {
        UpdateCustomerAppDataCommand cmd = UpdateCustomerAppDataCommand
                .newBuilder()
                .setUpdate(update)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setUpdateCustomerAppData(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerAppData();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Delete customer app data
     * @param customerNumber
     * @return
     */
    public Mono<UpdateCustomerStateReply> deleteCustomerAppData(CustomerNumber customerNumber) {
        DeleteCustomerAppDataCommand cmd = DeleteCustomerAppDataCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setDeleteCustomerAppData(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateCustomerState();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }


    /**
     * Send a message
     * @param customerNumber
     * @param channelNumber
     * @param message
     * @return
     */
    public Mono<SendMessageReply> sendMessage(CustomerNumber customerNumber, MessagingChannelNumber channelNumber, OutboundMessage message) {
        SendMessageCommand cmd = SendMessageCommand
                .newBuilder()
                .setMessage(message)
                .setChannelNumber(channelNumber)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setSendMessage(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getSendMessage();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Send a message by tag
     * @param tag
     * @param channelNumber
     * @param message
     * @return
     */
    public Mono<TagCommandReply> sendMessageByTag(IndexMapping tag, MessagingChannelNumber channelNumber, OutboundMessage message) {
        SendMessageTagCommand cmd = SendMessageTagCommand
                .newBuilder()
                .setTag(tag)
                .setMessage(message)
                .setChannelNumber(channelNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setSendMessageTag(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getTagCommand();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Reply to a message
     * @param customerId
     * @param messageId
     * @param message
     * @return
     */
    public Mono<SendMessageReply> replyToMessage(String customerId, String messageId, OutboundMessage message) {
        ReplyToMessageCommand cmd = ReplyToMessageCommand
                .newBuilder()
                .setMessage(message)
                .setMessageId(messageId)
                .setCustomerId(customerId)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setReplyToMessage(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getSendMessage();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Update messaging consent
     * @param customerNumber
     * @param channelNumber
     * @param update
     * @return
     */
    public Mono<UpdateMessagingConsentReply> updateMessagingConsent(CustomerNumber customerNumber, MessagingChannelNumber channelNumber, MessagingConsentUpdate update) {
        UpdateMessagingConsentCommand cmd = UpdateMessagingConsentCommand
                .newBuilder()
                .setUpdate(update)
                .setChannelNumber(channelNumber)
                .setCustomerNumber(customerNumber)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setUpdateMessagingConsent(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getUpdateMessagingConsent();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Initiate a payment
     * @param debitParty
     * @param creditParty
     * @param value
     * @return
     */
    public Mono<InitiatePaymentReply> initiatePayment(PaymentCounterParty debitParty, PaymentCounterParty creditParty, Cash value) {
        InitiatePaymentCommand cmd = InitiatePaymentCommand
                .newBuilder()
                .setDebitParty(debitParty)
                .setCreditParty(creditParty)
                .setValue(value)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setInitiatePayment(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getInitiatePayment();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    /**
     * Update customer activity
     * @param customerNumber
     * @param channelNumber
     * @param sessionId
     * @param key
     * @param properties
     * @return
     */
    public Mono<CustomerActivityReply> updateCustomerActivity(CustomerNumber customerNumber, ActivityModel.ActivityChannelNumber channelNumber, String sessionId, String key, Map<String, String> properties) {
        CustomerActivityCommand cmd = CustomerActivityCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .setChannelNumber(channelNumber)
                .setSessionId(sessionId)
                .setKey(key)
                .putAllProperties(properties)
                .build();
        AppToServerCommand req = AppToServerCommand
                .newBuilder()
                .setCustomerActivity(cmd)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.parseFrom(bytes).getCustomerActivity();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }
}
