package com.elarian.hera.android;

class ConnectionConfig {
    public final long lifetime;
    public final long keepAlive;
    public final ClientSerializer serializer;
    public final boolean isResumable;

    public ConnectionConfig(long lifetime, long keepAlive, boolean resumable, ClientSerializer serializer) {
        this.lifetime = lifetime;
        this.keepAlive = keepAlive;
        this.isResumable = resumable;
        this.serializer = serializer;
    }

    public ConnectionConfig(long lifetime, long keepAlive, boolean resumable) {
        this(lifetime, keepAlive, resumable, new ClientSerializer<String>() {
            @Override
            public byte[] serialize(String data) {
                return data.getBytes();
            }

            @Override
            public String deserialize(byte[] data) {
                return new String(data);
            }
        });
    }

    public ConnectionConfig() {
        this(60000, 1000, false, new ClientSerializer<String>() {
            @Override
            public byte[] serialize(String data) {
                return data.getBytes();
            }

            @Override
            public String deserialize(byte[] data) {
                return new String(data);
            }
        });
    }
}
