package com.elarian;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.awaitility.Awaitility.await;

@TestMethodOrder(OrderAnnotation.class)
public class ElarianTests {

    private static final Elarian client = new Elarian(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);

    @Test
    @Order(1)
    void connect() {
        client.connect(Fixtures.connectionListener);
        await().until(client::isConnected);
    }

    @Test
    @Order(2)
    void generateAuthToken() {}

    @Test
    @Order(3)
    void addCustomerReminderByTag() {}

    @Test
    @Order(4)
    void cancelCustomerReminderByTag() {}

    @Test
    @Order(5)
    void sendMessageByTag() {}

    @Test
    @Order(6)
    void initiatePayment() {}

    @Test
    @Order(7)
    void disconnect() {
        client.disconnect("Done Test!");
        await().until(() -> !client.isConnected());
    }
}
