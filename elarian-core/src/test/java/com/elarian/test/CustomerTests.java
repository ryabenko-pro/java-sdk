package com.elarian.test;

import com.elarian.Customer;
import com.elarian.Elarian;
import com.elarian.Simulator;
import com.elarian.model.Activity;
import com.elarian.model.ConsentAction;
import com.elarian.model.ConsentUpdateReply;
import com.elarian.model.CustomerNumber;
import com.elarian.model.CustomerState;
import com.elarian.model.CustomerStateUpdateReply;
import com.elarian.model.DataMapValue;
import com.elarian.model.Message;
import com.elarian.model.MessageBody;
import com.elarian.model.MessageReply;
import com.elarian.model.Reminder;
import com.elarian.model.SecondaryId;
import com.elarian.model.Tag;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTests {

    private static Customer customer;
    private static final Elarian client = new Elarian(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);
    private static final Simulator simulator = new Simulator(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);

    @BeforeAll
    static void connect() {
        client.connect(Fixtures.connectionListener);
        simulator.connect(Fixtures.connectionListener);
        customer = new Customer(client, new CustomerNumber("+254718769000", CustomerNumber.Provider.CELLULAR));
        await().until(client::isConnected);
        await().until(simulator::isConnected);
    }

    @AfterAll
    static void disconnect() {
        simulator.disconnect();
        client.disconnect();
        await().until(() -> !client.isConnected());
        await().until(() -> !simulator.isConnected());
    }

    @Test
    @Order(1)
    void getState() {
        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertNotNull(state.customerId);
    }

    @Test
    @Order(2)
    void adoptState() {
        CustomerStateUpdateReply reply = customer.adoptState(
                new Customer(client, new CustomerNumber("+254718769001", CustomerNumber.Provider.CELLULAR)))
                .block(Duration.ofSeconds(5));
        assertNotNull(reply);
    }

    @Test
    @Order(3)
    void sendMessage() {
        MessageBody body = new MessageBody("Hello Hello");
        Message message = new Message(body);
        MessageReply reply = customer.sendMessage(Fixtures.smsChannel, message).block(Duration.ofSeconds(5));
        assertNotNull(reply);
    }

    @Test
    @Order(4)
    void replyToMessage() {
        MessageBody body = new MessageBody("Hello Hello");
        Message message = new Message(body);
        MessageReply reply = customer.replyToMessage("some-message-id", message).block(Duration.ofSeconds(5));
        assertNotNull(reply);
    }

    @Test
    @Order(5)
    void updateActivity() {
        Activity activity = new Activity("some-key", new HashMap<>(), "some-session");
        CustomerStateUpdateReply reply = customer.updateActivity(Fixtures.activityChannel, activity).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);
    }

    @Test
    @Order(6)
    void updateMessagingConsent() {
        ConsentUpdateReply reply = customer.updateMessagingConsent(Fixtures.smsChannel, ConsentAction.ALLOW).block(Duration.ofSeconds(5));
        assertNotNull(reply);
    }

    @Test
    @Order(7)
    void updateAppData() {
        DataMapValue data = DataMapValue.of("some-string-payload");
        CustomerStateUpdateReply reply = customer.updateAppData(data).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);
    }

    @Test
    @Order(8)
    void leaseAppData() {
        DataMapValue reply = customer.leaseAppData().block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertEquals(reply.string, "some-string-payload");
    }

    @Test
    @Order(9)
    void deleteAppData() {
        CustomerStateUpdateReply reply = customer.deleteAppData().block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);
    }

    @Test
    @Order(10)
    void updateMetadata() {
        HashMap<String, DataMapValue> metadata = new HashMap<>();
        metadata.put("passport_number", DataMapValue.of("xyz"));
        metadata.put("id_number", DataMapValue.of("abc"));
        metadata.put("bio_data", DataMapValue.of(new byte[] { 0, 3, 22, 86, 99 }));
        CustomerStateUpdateReply reply = customer.updateMetadata(metadata).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        HashMap<String, DataMapValue> updated = new HashMap<>();
        updated.put("id_number", DataMapValue.of("123"));
        reply = customer.updateMetadata(updated).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertEquals("123", state.identityState.metadata.get("id_number").string);
    }

    @Test
    @Order(11)
    void deleteMetadata() {
        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertTrue(state.identityState.metadata.keySet().containsAll(Arrays.asList("bio_data", "id_number", "passport_number")));
        assertArrayEquals(new byte[] { 0, 3, 22, 86, 99 }, state.identityState.metadata.get("bio_data").bytes);
        assertEquals("xyz", state.identityState.metadata.get("passport_number").string);

        CustomerStateUpdateReply reply = customer.deleteMetadata(Arrays.asList("bio_data", "id_number")).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertFalse(state.identityState.metadata.keySet().containsAll(Arrays.asList("bio_data", "id_number")));
        assertTrue(state.identityState.metadata.keySet().containsAll(Arrays.asList("passport_number")));
    }

    @Test
    @Order(12)
    void updateSecondaryIds() {
        List<SecondaryId> secondaryIds = Arrays.asList(
                new SecondaryId("passport", "8367333"),
                new SecondaryId("driver_license", "2341234")
        );

        CustomerStateUpdateReply reply = customer.updateSecondaryIds(secondaryIds).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertTrue(state.identityState.secondaryIds.stream().map(i -> i.key).collect(Collectors.toList()).containsAll(Arrays.asList("passport", "driver_license")));
        assertTrue(state.identityState.secondaryIds.stream().map(i -> i.value).collect(Collectors.toList()).containsAll(Arrays.asList("8367333", "2341234")));

    }

    @Test
    @Order(13)
    void deleteSecondaryIds() {
        List<SecondaryId> secondaryIds = Arrays.asList(
                new SecondaryId("passport", "8367333"),
                new SecondaryId("driver_license", "2341234")
        );
        CustomerStateUpdateReply reply = customer.deleteSecondaryIds(secondaryIds).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertTrue(state.identityState.secondaryIds.isEmpty());
    }

    @Test
    @Order(14)
    void updateTags() {
        List<Tag> tags = Arrays.asList(
                new Tag("user_segment", "money"),
                new Tag("user_target", "tester")
        );

        CustomerStateUpdateReply reply = customer.updateTags(tags).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertTrue(state.identityState.tags.stream().map(i -> i.key).collect(Collectors.toList()).containsAll(Arrays.asList("user_segment", "user_target")));
        assertTrue(state.identityState.tags.stream().map(i -> i.value).collect(Collectors.toList()).containsAll(Arrays.asList("tester", "money")));
    }

    @Test
    @Order(15)
    void deleteTags() {
        CustomerStateUpdateReply reply = customer.deleteTags(Arrays.asList("user_segment", "user_target")).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);

        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertTrue(state.identityState.tags.isEmpty());
    }

    @Test
    @Order(16)
    void addReminder() {
        Reminder reminder = new Reminder("rem-key", "some-payload", (System.currentTimeMillis() + 60000) / 1000);
        CustomerStateUpdateReply reply = customer.addReminder(reminder).block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);
    }

    @Test
    @Order(17)
    void cancelReminder() {
        CustomerStateUpdateReply reply = customer.cancelReminder("rem-key").block(Duration.ofSeconds(5));
        assertNotNull(reply);
        assertTrue(reply.status);
    }

}
