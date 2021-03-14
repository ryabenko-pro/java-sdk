package com.elarian;

class ClientOpts {
    public final String appId;
    public final String orgId;
    public final String apiKey;
    public boolean isSimulator = false;
    public boolean allowNotifications = true;


    public ClientOpts(String apiKey, String orgId, String appId, boolean allowNotifications, boolean isSimulator) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
        this.isSimulator = isSimulator;
        this.allowNotifications = allowNotifications;
    }

    public ClientOpts(String apiKey, String orgId, String appId) {
        this.orgId = orgId;
        this.appId = appId;
        this.apiKey = apiKey;
    }
}
