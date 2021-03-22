package com.elarian.model;


import java.util.HashMap;
import java.util.Map;

public final class Template {
    public String id;
    public Map<String, String> params = new HashMap<>();
    public Template(String id, Map<String, String> params) {
        this.id = id;
        this.params.putAll(params);
    }
}
