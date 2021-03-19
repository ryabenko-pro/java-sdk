package com.elarian;

public interface ConnectionListener {
    void onPending();
    void onConnecting();
    void onClosed();
    void onConnected();
    void onError(Throwable throwable);

}
