package com.elarian.model;

import java.util.List;

public final class ReceivedMessage {
    public String messageId;
    public long createdAt;
    public String sessionId;
    public String inReplyTo;
    public CustomerNumber.Provider provider;
    public String appId;
    // Parts
    public List<String> texts;
    public List<Media> media;
    public List<Location> locations;
    public List<Email> emails;
    public List<VoiceCallDialInput> voice;
    public List<String> ussd;
}
