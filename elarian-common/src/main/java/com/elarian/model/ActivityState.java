package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class ActivityState {
    List<ActivityState.Session> sessions = new ArrayList<>();
    List<CustomerNumber> customerNumbers = new ArrayList<>();

    public final class Session {
        public CustomerNumber customerNumber;
        public ActivityChannel channelNumber;
        public String sessionId;
        public String appId;
        public List<Activity> activities;
        public long createdAt;
        public long updatedAt;
    }
}
