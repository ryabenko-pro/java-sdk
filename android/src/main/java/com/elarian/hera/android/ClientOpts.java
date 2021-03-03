package com.elarian.hera.android;

class ClientOpts {
    public final String authToken;
    public final String orgId;
    public final String appId;
    public boolean isSimulator = false;


    public ClientOpts(String authToken, String orgId, String appId, boolean isSimulator) {
        this.orgId = orgId;
        this.appId = appId;
        this.authToken = authToken;
        this.isSimulator = isSimulator;
    }

    public ClientOpts(String authToken, String orgId, String appId) {
        this.orgId = orgId;
        this.appId = appId;
        this.authToken = authToken;
    }
}
