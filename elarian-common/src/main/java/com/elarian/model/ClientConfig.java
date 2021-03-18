package com.elarian.model;

public final class ClientConfig {
    public final String appId;
    public final String orgId;
    public final String apiKey;
    public boolean allowNotifications = true;
    public ConnectionConfig connectionConfig = new ConnectionConfig();


    public ClientConfig(String apiKey, String orgId, String appId, boolean allowNotifications, ConnectionConfig connectionConfig) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
        this.allowNotifications = allowNotifications;
        this.connectionConfig = connectionConfig;
    }

    public ClientConfig(String apiKey, String orgId, String appId) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
    }
}
