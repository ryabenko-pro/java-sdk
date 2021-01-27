package com.elarian.hera;

public class ClientOpts {
    public final String apiKey;
    public final String orgId;
    public final String appId;

    public ClientOpts(String apiKey, String orgId, String appId) {
        this.apiKey = apiKey;
        this.orgId = orgId;
        this.appId = appId;
    }
}
