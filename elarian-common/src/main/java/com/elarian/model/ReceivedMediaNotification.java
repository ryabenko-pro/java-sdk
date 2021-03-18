package com.elarian.model;

public final class ReceivedMediaNotification extends ReceivedMessageNotification {
    public Media media;
    public Location location;
    public Email email;
    public String sessionId;
    public String inReplyTo;
}
