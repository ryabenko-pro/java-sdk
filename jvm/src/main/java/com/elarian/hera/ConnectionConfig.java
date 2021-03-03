package com.elarian.hera;

class ConnectionConfig {
    public final long lifetime;
    public final long keepAlive;
    public final ClientSerializer serializer;

    public ConnectionConfig(long lifetime, long keepAlive, ClientSerializer serializer) {
        this.lifetime = lifetime;
        this.keepAlive = keepAlive;
        this.serializer = serializer;
    }

    public ConnectionConfig(long lifetime, long keepAlive) {
        this(lifetime, keepAlive, new ClientSerializer<String>() {
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
        this(60000, 1000, new ClientSerializer<String>() {
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
