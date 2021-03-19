package com.elarian.model;

import reactor.util.annotation.NonNull;

public final class ClientConfig {
    public final String appId;
    public final String orgId;
    public final String apiKey;
    public boolean allowNotifications = true;
    public ConnectionConfig connectionConfig = new ConnectionConfig();


    public ClientConfig(@NonNull String apiKey, @NonNull String orgId, @NonNull String appId, boolean allowNotifications, ConnectionConfig connectionConfig) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
        this.allowNotifications = allowNotifications;
        this.connectionConfig = connectionConfig;
    }

    public ClientConfig(@NonNull String apiKey, @NonNull String orgId, @NonNull String appId) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
    }
}
