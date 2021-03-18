package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public class BaseMessagingChannelState {
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public List<ChannelMessage> messages = new ArrayList<>();
    public MessageReplyToken replyToken;
    public List<CompleteMessagingSession> sessions = new ArrayList<>();
}
