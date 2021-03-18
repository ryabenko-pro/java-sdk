package com.elarian;

import org.junit.jupiter.api.Test;

public class SimulatorTest {

    private final Simulator client = new Simulator(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);

    @Test
    void connect() {}

    @Test
    void receiveMessage() {}

    @Test
    void receivePayment() {}

    @Test
    void updatePaymentStatus() {}

    @Test
    void disconnect() {}
}
