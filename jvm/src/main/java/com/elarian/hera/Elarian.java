package com.elarian.hera;

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

public final class Elarian extends Client<ServerToAppNotification, ServerToAppNotificationReply> {

    public Elarian(String apiKey, String orgId, String appId) {
        super(new ClientOpts(apiKey, orgId, appId, true, false), new ConnectionConfig());
    }

    public Elarian(String apiKey, String orgId, String appId, boolean allowNotifications) {
        super(new ClientOpts(apiKey, orgId, appId, allowNotifications, false), new ConnectionConfig());
    }

    public static Elarian newInstance(String apiKey, String orgId, String appId) throws RuntimeException {
        Elarian client = new Elarian(apiKey, orgId, appId, true);
        client.connect();
        return client;
    }

    @Override
    protected byte[] serializeNotificationReply(ServerToAppNotificationReply data) {
        return data.toByteArray();
    }

    @Override
    protected ServerToAppNotification deserializeNotification(byte[] data) throws InvalidProtocolBufferException {
        return ServerToAppNotification.newBuilder().mergeFrom(data).build();
    }


    /**
     * Generate auth token
     * @return
     */
    public Mono<GenerateAuthTokenReply> generateAuthToken() {
        GenerateAuthTokenCommand req = GenerateAuthTokenCommand.newBuilder().build();
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
        GetCustomerStateCommand req = GetCustomerStateCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
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
        AdoptCustomerStateCommand req = AdoptCustomerStateCommand
                .newBuilder()
                .setCustomerId(customerId)
                .setOtherCustomerNumber(otherCustomerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
    public Mono<UpdateCustomerStateReply> addCustomerReminder(CustomerNumber customerNumber, CustomerReminder reminder) {
        AddCustomerReminderCommand req = AddCustomerReminderCommand
                .newBuilder()
                .setReminder(reminder)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        AddCustomerReminderTagCommand req = AddCustomerReminderTagCommand
                .newBuilder()
                .setTag(tag)
                .setReminder(reminder)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getTagCommand();
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
        CancelCustomerReminderCommand req = CancelCustomerReminderCommand
                .newBuilder()
                .setKey(key)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        CancelCustomerReminderTagCommand req = CancelCustomerReminderTagCommand
                .newBuilder()
                .setTag(tag)
                .setKey(key)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getTagCommand();
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
        UpdateCustomerTagCommand req = UpdateCustomerTagCommand
                .newBuilder()
                .addAllUpdates(tags)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        DeleteCustomerTagCommand req = DeleteCustomerTagCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        UpdateCustomerSecondaryIdCommand req = UpdateCustomerSecondaryIdCommand
                .newBuilder()
                .addAllUpdates(secondaryIds)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        DeleteCustomerSecondaryIdCommand req = DeleteCustomerSecondaryIdCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        UpdateCustomerMetadataCommand req = UpdateCustomerMetadataCommand
                .newBuilder()
                .putAllUpdates(updates)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        DeleteCustomerMetadataCommand req = DeleteCustomerMetadataCommand
                .newBuilder()
                .addAllDeletions(keys)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
        LeaseCustomerAppDataCommand req = LeaseCustomerAppDataCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getLeaseCustomerAppData();
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
        UpdateCustomerAppDataCommand req = UpdateCustomerAppDataCommand
                .newBuilder()
                .setUpdate(update)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerAppData();
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
        DeleteCustomerAppDataCommand req = DeleteCustomerAppDataCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateCustomerState();
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
    public Mono<SendMessageReply> sendToMessage(CustomerNumber customerNumber, MessagingChannelNumber channelNumber, OutboundMessage message) {
        SendMessageCommand req = SendMessageCommand
                .newBuilder()
                .setMessage(message)
                .setChannelNumber(channelNumber)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getSendMessage();
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
    public Mono<TagCommandReply> sendToMessageByTag(IndexMapping tag, MessagingChannelNumber channelNumber, OutboundMessage message) {
        SendMessageTagCommand req = SendMessageTagCommand
                .newBuilder()
                .setTag(tag)
                .setMessage(message)
                .setChannelNumber(channelNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getTagCommand();
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
        ReplyToMessageCommand req = ReplyToMessageCommand
                .newBuilder()
                .setMessage(message)
                .setMessageId(messageId)
                .setCustomerId(customerId)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getSendMessage();
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
        UpdateMessagingConsentCommand req = UpdateMessagingConsentCommand
                .newBuilder()
                .setUpdate(update)
                .setChannelNumber(channelNumber)
                .setCustomerNumber(customerNumber)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getUpdateMessagingConsent();
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
        InitiatePaymentCommand req = InitiatePaymentCommand
                .newBuilder()
                .setDebitParty(debitParty)
                .setCreditParty(creditParty)
                .setValue(value)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getInitiatePayment();
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
        CustomerActivityCommand req = CustomerActivityCommand
                .newBuilder()
                .setCustomerNumber(customerNumber)
                .setChannelNumber(channelNumber)
                .setSessionId(sessionId)
                .setKey(key)
                .putAllProperties(properties)
                .build();
        return buildCommandReply(req.toByteArray(), (bytes -> {
            try {
                return AppToServerCommandReply.newBuilder().mergeFrom(bytes).build().getCustomerActivity();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }
}
