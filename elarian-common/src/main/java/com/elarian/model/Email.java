package com.elarian.model;

import java.util.List;

public final class Email {
    public String subject;
    public String plain;
    public String html;
    public List<String> cc;
    public List<String> bcc;
    public List<String> attachments;
}
