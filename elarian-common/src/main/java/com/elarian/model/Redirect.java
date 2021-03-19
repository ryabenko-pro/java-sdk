package com.elarian.model;

public final class Redirect implements VoiceAction {
    public String url;

    public Redirect(String url) {
        this.url = url;
    }
}
