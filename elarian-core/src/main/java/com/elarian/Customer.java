package com.elarian;


import com.elarian.hera.proto.AppModel;
import com.elarian.hera.proto.AppSocket;
import com.elarian.hera.proto.CommonModel;
import com.elarian.model.*;
import com.google.protobuf.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public final class Customer implements ICustomer {

    String customerId;
    CustomerNumber customerNumber;

    Elarian client;

    private final Function<byte[], AppSocket.AppToServerCommandReply> replyDeserializer = (data) -> {
        try {
            return AppSocket.AppToServerCommandReply.newBuilder().mergeFrom(data).build();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    };

    public Customer(Elarian client, String customerId) {
        this.client = client;
        this.customerId = customerId;
    }

    public Customer(Elarian client, CustomerNumber customerNumber) {
        this.client = client;
        this.customerNumber = customerNumber;
    }

    public Mono<CustomerState> getState() {
        AppSocket.GetCustomerStateCommand.Builder cmd = AppSocket.GetCustomerStateCommand
                .newBuilder();

        if (customerNumber != null) {
            cmd.setCustomerNumber(CommonModel.CustomerNumber
                    .newBuilder()
                    .setNumber(customerNumber.number)
                    .setProviderValue(customerNumber.provider.getValue())
                    .build());
        } else if (customerId != null) {
            cmd.setCustomerId(customerId);
        } else {
            throw new RuntimeException("Invalid customer. customerId and/or customerNumber need to be set");
        }

        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setGetCustomerState(cmd)
                .build();

         return new Mono<CustomerState>() {
             @Override
             public void subscribe(CoreSubscriber<? super CustomerState> subscriber) {
                 client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                     AppSocket.GetCustomerStateReply res = reply.getGetCustomerState();
                     if (!res.getStatus()) {
                         subscriber.onError(new RuntimeException(res.getDescription()));
                         return;
                     }

                     AppSocket.CustomerStateReplyData data = res.getData();

                     // TODO: Fill in data
                     customerId = data.getCustomerId();
                     CustomerState state = new CustomerState(customerId);
                     if (data.hasIdentityState()) {
                         state.identityState = new IdentityState();
                     }

                     if (data.hasActivityState()) {
                         state.activityState = new ActivityState();
                     }

                     if (data.hasMessagingState()) {
                         state.messagingState = new MessagingState();
                     }

                     if (data.hasPaymentState()) {
                         state.paymentState = new PaymentState();
                     }

                     subscriber.onNext(state);
                     subscriber.onComplete();
                 }, subscriber::onError);
             }
         };
    }

    public Mono<CustomerStateUpdateReply> adoptState(Customer otherCustomer) {

        AppSocket.AdoptCustomerStateCommand.Builder cmd = AppSocket.AdoptCustomerStateCommand
                .newBuilder();

        if (customerId == null) {
            throw new RuntimeException("Invalid customer. customerId needs to be set");
        }

        cmd.setCustomerId(customerId);
        if (otherCustomer.customerId != null) {
            cmd.setOtherCustomerId(otherCustomer.customerId);
        } else if (otherCustomer.customerNumber != null) {
            cmd.setOtherCustomerNumber(CommonModel.CustomerNumber
                    .newBuilder()
                    .setNumber(otherCustomer.customerNumber.number)
                    .setProviderValue(otherCustomer.customerNumber.provider.getValue())
                    .build());
        }

        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setAdoptCustomerState(cmd)
                .build();

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };

    }

    public Mono<MessageReply> sendMessage(MessagingChannel channel, Message message) {

    }

    public Mono<MessageReply> replyToMessage(String messageId, Message message) {

    }

    public Mono<CustomerStateUpdateReply> updateActivity(ActivityChannel channel, Activity activity) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };

    }

    public Mono<ConsentUpdateReply> updateMessagingConsent(MessagingChannel channel, ConsentAction action) {

    }

    public Mono<?> leaseAppData() {

    }

    public Mono<CustomerStateUpdateReply> updateAppData() {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> deleteAppData() {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> updateMetadata(Map<String, String> metadata) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> deleteMetadata(List<String> keys) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> updateSecondaryIds(List<SecondaryId> secondaryIds) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> deleteSecondaryIds(List<SecondaryId> secondaryIds) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> updateTags(List<Tag> tags) {
        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    public Mono<CustomerStateUpdateReply> deleteTags(List<String> keys) {

        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }

    /**
     *
     * @param reminder
     * @return
     */
    public Mono<CustomerStateUpdateReply> addReminder(Reminder reminder) {
        AppModel.CustomerReminder.Builder rem = AppModel.CustomerReminder
                .newBuilder()
                .setKey(reminder.key)
                .setRemindAt(Timestamp
                        .newBuilder()
                        .setSeconds(reminder.remindAt)
                        .build());

        if (reminder.payload != null) {
            rem.setPayload(StringValue.of(reminder.payload));
        }

        if (reminder.interval > 0) {
            rem.setInterval(Duration
                    .newBuilder()
                    .setSeconds(reminder.interval)
                    .build());
        }

        AppSocket.AddCustomerReminderCommand.Builder cmd = AppSocket.AddCustomerReminderCommand
                .newBuilder()
                .setReminder(rem);

        if (customerNumber != null) {
            cmd.setCustomerNumber(CommonModel.CustomerNumber
                    .newBuilder()
                    .setNumber(customerNumber.number)
                    .setProviderValue(customerNumber.provider.getValue())
                    .build());
        } else if (customerId != null) {
            cmd.setCustomerId(customerId);
        } else {
            throw new RuntimeException("Invalid customer. customerId and/or customerNumber need to be set");
        }

        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setAddCustomerReminder(cmd)
                .build();


        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }


    /**
     *
     * @param key
     * @return
     */
    public Mono<CustomerStateUpdateReply> cancelReminder(String key) {

        AppSocket.CancelCustomerReminderCommand.Builder cmd = AppSocket.CancelCustomerReminderCommand
                .newBuilder()
                .setKey(key);

        if (customerNumber != null) {
            cmd.setCustomerNumber(CommonModel.CustomerNumber
                    .newBuilder()
                    .setNumber(customerNumber.number)
                    .setProviderValue(customerNumber.provider.getValue())
                    .build());
        } else if (customerId != null) {
            cmd.setCustomerId(customerId);
        } else {
            throw new RuntimeException("Invalid customer. customerId and/or customerNumber need to be set");
        }

        AppSocket.AppToServerCommand req = AppSocket.AppToServerCommand
                .newBuilder()
                .setCancelCustomerReminder(cmd)
                .build();


        return new Mono<CustomerStateUpdateReply>() {
            @Override
            public void subscribe(CoreSubscriber<? super CustomerStateUpdateReply> subscriber) {
                client.buildCommandReply(req.toByteArray(), replyDeserializer).subscribe(reply -> {
                    AppSocket.UpdateCustomerStateReply res = reply.getUpdateCustomerState();
                    if (!res.getStatus()) {
                        subscriber.onError(new RuntimeException(res.getDescription()));
                        return;
                    }
                    subscriber.onNext(new CustomerStateUpdateReply(
                            true,
                            res.getCustomerId().getValue(),
                            res.getDescription()));
                    subscriber.onComplete();
                }, subscriber::onError);
            }
        };
    }
}
