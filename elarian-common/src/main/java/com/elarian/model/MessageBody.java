package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class MessageBody {
    public String text = null;
    public Template template = null;
    public Media media = null;
    public Location location = null;
    public Email email = null;
    public List<VoiceAction> voice = new ArrayList<>();
    public UssdMenu ussd = null;
    public String url = null;

    public MessageBody() {}

    public MessageBody(String text) {
        this.text = text;
    }
}

