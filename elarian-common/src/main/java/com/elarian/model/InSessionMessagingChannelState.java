package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class InSessionMessagingChannelState extends BaseMessagingChannelState {
    public String sessionId;
    public List<String> appIds = new ArrayList<>();
    public long startedAt;
    public long expiresAt;
    public long allowedAt;
}
