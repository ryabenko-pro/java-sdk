package com.elarian;


import com.elarian.model.Activity;
import com.elarian.model.ActivityChannel;
import com.elarian.model.ConsentAction;
import com.elarian.model.CustomerNumber;
import com.elarian.model.MessagingChannel;
import com.elarian.model.Reminder;

import reactor.core.publisher.Mono;

public final class Customer implements ICustomer {

    String customerId;
    CustomerNumber customerNumber;

    Elarian client;

    public Customer(Elarian client, String customerId) {
        this.client = client;
        this.customerId = customerId;
    }

    public Customer(Elarian client, CustomerNumber customerNumber) {
        this.client = client;
        this.customerNumber = customerNumber;
    }

    public Mono<CustomerState> getState() {
        // this.client.buildCommandReply();
    }

    public Mono<CustomerStateUpdateReply> adoptState(Customer otherCustomer) {

    }

    public Mono<MessageReply> sendMessage(MessagingChannel channel, Message message) {

    }

    public Mono<MessageReply> replyToMessage(String messageId, Message message) {

    }

    public Mono<CustomerStateUpdateReply> updateActivity(ActivityChannel channel, Activity activity) {

    }

    public Mono<ConsentUpdateReply> updateMessagingConsent(MessagingChannel channel, ConsentAction action) {

    }

    public Mono<?> leaseAppData() {

    }

    public Mono<CustomerStateUpdateReply> updateAppData() {

    }

    public Mono<CustomerStateUpdateReply> deleteAppData() {

    }

    public Mono<CustomerStateUpdateReply> updateMetadata(Map<String, String> metadata) {

    }

    public Mono<CustomerStateUpdateReply> deleteMetadata(List<String> keys) {

    }

    public Mono<CustomerStateUpdateReply> updateSecondaryIds(List<SecondaryId> secondaryIds) {

    }

    public Mono<CustomerStateUpdateReply> deleteSecondaryIds(List<SecondaryId> secondaryIds) {

    }

    public Mono<CustomerStateUpdateReply> updateTags(List<Tag> tags) {

    }

    public Mono<CustomerStateUpdateReply> deleteTags(List<String> keys) {

    }

    public Mono<CustomerStateUpdateReply> addReminder(Reminder reminder) {

    }

    public Mono<CustomerStateUpdateReply> cancelReminder(String key) {

    }
}
