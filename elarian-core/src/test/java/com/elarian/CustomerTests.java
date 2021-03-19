package com.elarian;

import static org.junit.jupiter.api.Assertions.*;
import com.elarian.model.CustomerNumber;
import com.elarian.model.CustomerState;
import com.elarian.model.CustomerStateUpdateReply;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class CustomerTests {

    private static final Elarian client = new Elarian(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);
    private static final Simulator simulator = new Simulator(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);
    private static Customer customer;

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
    void getState() {
        CustomerState state = customer.getState().block(Duration.ofSeconds(5));
        assertNotNull(state);
        assertNotNull(state.customerId);
    }

    @Test
    void adoptState() {
        CustomerStateUpdateReply reply = customer.adoptState(
                new Customer(client, new CustomerNumber("+2547187690001", CustomerNumber.Provider.CELLULAR)))
                .block(Duration.ofSeconds(5));
        assertNotNull(reply);
    }

    @Test
    void sendMessage() {}

    @Test
    void replyToMessage() {}

    @Test
    void updateActivity() {}

    @Test
    void updateMessagingConsent() {}

    @Test
    void leaseAppData() {}

    @Test
    void updateAppData() {}

    @Test
    void deleteAppData() {}

    @Test
    void updateMetadata() {}

    @Test
    void deleteMetadata() {}

    @Test
    void updateSecondaryIds() {}

    @Test
    void deleteSecondaryIds() {}

    @Test
    void updateTags() {}

    @Test
    void deleteTags() {}

    @Test
    void addReminder() {}

    @Test
    void cancelReminder() {}

}
