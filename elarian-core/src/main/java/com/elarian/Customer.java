package com.elarian;

import com.elarian.hera.proto.CommonModel.*;

public final class Customer implements ICustomer {

    String customerId;
    CustomerNumber customerNumber;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

}
