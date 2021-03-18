package com.elarian.model;

public final class AuthToken {
    public final String token;
    public final long lifetime;

    public AuthToken(String token, long lifetime) {
        this.token = token;
        this.lifetime = lifetime;
    }
}
