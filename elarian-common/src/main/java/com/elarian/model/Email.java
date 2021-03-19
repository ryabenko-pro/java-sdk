package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class Email {
    public String subject;
    public String plain;
    public String html;
    public List<String> cc = new ArrayList<>();
    public List<String> bcc = new ArrayList<>();
    public List<String> attachments = new ArrayList<>();
}
