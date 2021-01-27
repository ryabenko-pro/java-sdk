package com.elarian.hera;

public class ConnectionConfig {
    public final long lifetime, keepAlive, reconnectInterval;
    public final ClientSerializer serializer;

    public ConnectionConfig(long lifetime, long keepAlive, long reconnectInterval, ClientSerializer serializer) {
        this.lifetime = lifetime;
        this.keepAlive = keepAlive;
        this.reconnectInterval = reconnectInterval;
        this.serializer = serializer;
    }

    public ConnectionConfig(long lifetime, long keepAlive, long reconnectInterval) {
        this(lifetime, keepAlive, reconnectInterval, new ClientSerializer<String>() {
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
        this(60000, 1000, 1000, new ClientSerializer<String>() {
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
