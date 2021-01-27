package com.elarian.hera;

public class Client {

    private ClientOpts clientOpts;
    private ConnectionConfig connectionConfig;

    public Client(ClientOpts clientOpts, ConnectionConfig connConfig) {
        this.clientOpts = clientOpts;
        this.connectionConfig = connConfig;
    }

    public Client(ClientOpts clientOpts) {
        this(clientOpts, new ConnectionConfig());
    }

}
