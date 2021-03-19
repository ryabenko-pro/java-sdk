package com.elarian;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.awaitility.Awaitility.await;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimulatorTest {

    private static final Simulator client = new Simulator(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);

    @Test
    @Order(1)
    void connectAndDisconnect() {
        client.connect(Fixtures.connectionListener);
        await().until(client::isConnected);
    }

    @Test
    @Order(2)
    void receiveMessage() {}

    @Test
    @Order(3)
    void receivePayment() {}

    @Test
    @Order(4)
    void updatePaymentStatus() {}

    @Test
    @Order(5)
    void disconnect() {
        client.disconnect("Done Test!");
        await().until(() -> !client.isConnected());
    }
}
