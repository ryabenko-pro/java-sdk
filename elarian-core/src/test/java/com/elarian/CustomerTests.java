package com.elarian;

import com.elarian.model.CustomerNumber;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerTests {

    private final Elarian client = new Elarian(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);
    private final Simulator simulator = new Simulator(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);
    private Customer customer;

    @BeforeAll
    void connect() {
        client.connect();
        simulator.connect();
        customer = new Customer(client, new CustomerNumber("+254718769882", CustomerNumber.Provider.CELLULAR));
    }

    @AfterAll
    void disconnect() {
        simulator.disconnect();
        client.disconnect();
    }

    @Test
    void getState() {}

    @Test
    void adoptState() {}

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
