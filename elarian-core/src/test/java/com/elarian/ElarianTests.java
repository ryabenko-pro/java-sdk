package com.elarian;

import org.junit.jupiter.api.Test;

public class ElarianTests {

    private final Elarian client = new Elarian(Fixtures.API_KEY, Fixtures.ORG_ID, Fixtures.APP_ID);

    @Test
    void connect() {}

    @Test
    void generateAuthToken() {}

    @Test
    void addCustomerReminderByTag() {}

    @Test
    void cancelCustomerReminderByTag() {}

    @Test
    void sendMessageByTag() {}

    @Test
    void initiatePayment() {}

    @Test
    void disconnect() {}
}
