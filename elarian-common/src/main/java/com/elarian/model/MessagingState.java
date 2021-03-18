package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class MessagingState {
    List<MessagingChannelState> channels = new ArrayList<>();

    public final class MessagingChannelState {
        public BlockedMessagingChannelState blocked = null;
        public ActiveMessagingChannelState active = null;
        public InSessionMessagingChannelState inSession = null;
    }


    public final class BlockedMessagingChannelState {
        CustomerNumber customer_number             = 1;
        MessagingChannelNumber channel_number      = 2;
        repeated ChannelMessage messages           = 3;
        MessageReplyToken reply_token              = 4;
        repeated CompleteMessagingSession sessions = 5;
        google.protobuf.Timestamp blocked_at       = 6;

    }

    public final class ActiveMessagingChannelState {
        CustomerNumber customer_number             = 1;
        MessagingChannelNumber channel_number      = 2;
        repeated ChannelMessage messages           = 3;
        MessageReplyToken reply_token              = 4;
        repeated CompleteMessagingSession sessions = 5;
        google.protobuf.Timestamp allowed_at       = 6;
    }

    public final class InSessionMessagingChannelState {
        CustomerNumber customer_number             = 1;
        MessagingChannelNumber channel_number      = 2;
        repeated ChannelMessage messages           = 3;
        MessageReplyToken reply_token              = 4;
        repeated CompleteMessagingSession sessions = 5;
        google.protobuf.Timestamp allowed_at       = 6;
        string session_id                          = 7;
        google.protobuf.Timestamp started_at       = 8;
        google.protobuf.Timestamp expires_at       = 9;
        repeated string app_ids                    = 10;
    }
}
