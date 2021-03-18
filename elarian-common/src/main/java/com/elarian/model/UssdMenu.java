package com.elarian.model;

public final class UssdMenu {
    public String text;
    public boolean isTerminal;

    public UssdMenu(String text, boolean isTerminal) {
        this.text = text;
        this.isTerminal = isTerminal;
    }
}
