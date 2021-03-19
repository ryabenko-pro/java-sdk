package com.elarian.model;

public final class MessageReactionState {
    public long createdAt;
    public MessageReaction reaction;

    public MessageReactionState(MessageReaction reaction, long createdAt) {
        this.reaction = reaction;
        this.createdAt = createdAt;
    }
}
