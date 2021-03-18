package com.elarian.model;

public final class ConnectionConfig {
    public final long lifetime;
    public final long keepAlive;
    public final Serializer serializer;
    public final Serializer.SerializerType serializerType;
    public final boolean isResumable;

    private static final Serializer<String> defaultSerializer =  new TextSerializer();

    public ConnectionConfig(long lifetime, long keepAlive, boolean resumable, Serializer.SerializerType serializerType, Serializer serializer) {
        this.lifetime = lifetime;
        this.keepAlive = keepAlive;
        this.isResumable = resumable;
        this.serializer = serializer;
        this.serializerType = serializerType;
    }

    public ConnectionConfig(long lifetime, long keepAlive, boolean resumable) {
        this(lifetime, keepAlive, resumable, Serializer.SerializerType.TEXT, defaultSerializer);
    }

    public ConnectionConfig() {
        this(60000, 1000, false, Serializer.SerializerType.TEXT , defaultSerializer);
    }
}
