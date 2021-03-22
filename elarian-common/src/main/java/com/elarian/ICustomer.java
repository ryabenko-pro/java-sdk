package com.elarian;

import com.elarian.model.Activity;
import com.elarian.model.ActivityChannel;
import com.elarian.model.ConsentAction;
import com.elarian.model.ConsentUpdateReply;
import com.elarian.model.CustomerNumber;
import com.elarian.model.CustomerState;
import com.elarian.model.CustomerStateUpdateReply;
import com.elarian.model.DataMapValue;
import com.elarian.model.Message;
import com.elarian.model.MessageReply;
import com.elarian.model.MessagingChannel;
import com.elarian.model.Reminder;
import com.elarian.model.SecondaryId;
import com.elarian.model.Tag;

import java.util.List;
import java.util.Map;

import reactor.core.publisher.Mono;

public interface ICustomer {

    Mono<String> getCustomerId();
    Mono<CustomerNumber> getCustomerNumber();

    Mono<CustomerState> getState();
    Mono<CustomerStateUpdateReply> adoptState(ICustomer otherCustomer);

    Mono<MessageReply> replyToMessage(String messageId, Message message);
    Mono<MessageReply> sendMessage(MessagingChannel channel, Message message);

    Mono<CustomerStateUpdateReply> updateActivity(ActivityChannel channel, Activity activity);
    Mono<ConsentUpdateReply> updateMessagingConsent(MessagingChannel channel, ConsentAction action);

    Mono<DataMapValue> leaseAppData();
    Mono<CustomerStateUpdateReply> deleteAppData();
    Mono<CustomerStateUpdateReply> updateAppData(DataMapValue data);

    Mono<CustomerStateUpdateReply> deleteMetadata(List<String> keys);
    Mono<CustomerStateUpdateReply> updateMetadata(Map<String, DataMapValue> metadata);

    Mono<CustomerStateUpdateReply> updateSecondaryIds(List<SecondaryId> secondaryIds);
    Mono<CustomerStateUpdateReply> deleteSecondaryIds(List<SecondaryId> secondaryIds);

    Mono<CustomerStateUpdateReply> updateTags(List<Tag> tags);
    Mono<CustomerStateUpdateReply> deleteTags(List<String> keys);

    Mono<CustomerStateUpdateReply> cancelReminder(String key);
    Mono<CustomerStateUpdateReply> addReminder(Reminder reminder);
}
