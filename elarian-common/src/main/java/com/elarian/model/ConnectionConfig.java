package com.elarian.model;

public final class ConnectionConfig {
    public final long lifetime;
    public final long keepAlive;
    public final boolean isResumable;

    public ConnectionConfig(long lifetime, long keepAlive, boolean resumable) {
        this.lifetime = lifetime;
        this.keepAlive = keepAlive;
        this.isResumable = resumable;
    }

    public ConnectionConfig() {
        this(60000, 1000, false);
    }
}
