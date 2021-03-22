package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class Dial implements VoiceAction {
    public List<CustomerNumber> customerNumbers = new ArrayList<>();
    public boolean record = false;
    public boolean sequential = true;
    public String ringbackTone = "";
    public String callerId = "";
    public int maxDuration;

    public Dial(List<CustomerNumber> customerNumbers, boolean record, boolean sequential, String ringbackTone, String callerId, int maxDuration) {
        this.customerNumbers = customerNumbers;
        this.record = record;
        this.sequential = sequential;
        this.ringbackTone = ringbackTone;
        this.callerId = callerId;
        this.maxDuration = maxDuration;
    }
}
