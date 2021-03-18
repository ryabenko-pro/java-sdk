package com.elarian.model;

import java.util.List;

public final class MessageBody {
    public String text = null;
    public Template template = null;
    public Media media = null;
    public Location location = null;
    public Email email = null;
    public List<VoiceAction> voice = null;
    public UssdMenu ussd = null;
    public String url = null;

    public MessageBody() {}

    public MessageBody(String text) {
        this.text = text;
    }
}
