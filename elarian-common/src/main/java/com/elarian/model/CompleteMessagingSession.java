package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class CompleteMessagingSession {
    public String sessionId;
    public long duration;
    public List<String> appIds = new ArrayList<>();
    public MessagingSessionEndReason endReason;
}
