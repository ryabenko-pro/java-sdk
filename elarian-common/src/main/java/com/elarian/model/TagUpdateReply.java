package com.elarian.model;

public final class TagUpdateReply {
    public final boolean status;
    public final String workId;
    public final String description;

    public TagUpdateReply(boolean status, String workId, String description) {
        this.status = status;
        this.workId = workId;
        this.description = description;
    }
}
