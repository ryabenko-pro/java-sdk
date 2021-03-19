package com.elarian.model;

public class DataMapValue {
    public String string = null;
    public byte[] bytes = null;

    public DataMapValue(String stringValue) {
        this.string = stringValue;
    }

    public DataMapValue(byte[] byteValue) {
        this.bytes = byteValue;
    }
}
