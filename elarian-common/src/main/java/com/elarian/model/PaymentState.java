package com.elarian.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PaymentState {
    List<CustomerNumber> customerNumbers = new ArrayList<>();
    List<PaymentChannel> paymentChannels = new ArrayList<>();
    List<PaymentTransaction> transactionLog = new ArrayList<>();
    List<PaymentTransaction> pendingTransactions = new ArrayList<>();
    Map<String, PaymentBalance> wallets = new HashMap<>();


    public final class PaymentTransaction {
        public String transactionId;
        public String appId;
        public PaymentCounterParty debitParty;
        public PaymentCounterParty creditParty;
        public Cash value;
        public PaymentStatus status;
        public long createdAt;
        public long updatedAt;
    }

    public final class PaymentBalance {
        public String currencyCode;
        public Cash available;
        public Cash actual;
        Map<String, PendingPaymentTransaction> pending = new HashMap<>();
        long sequenceNr;
    }

    public final class PendingPaymentTransaction {
        public long createdAt;
        public Cash value;
        public Cash converted;
    }
}
