package com.elarian.model;

/**
 *
 */
public class DataMapValue {
    public String string = null;
    public byte[] bytes = null;

    private DataMapValue(String stringValue) {
        this.string = stringValue;
    }

    private DataMapValue(byte[] byteValue) {
        this.bytes = byteValue;
    }

    /**
     * Make a data map with a string value
     * @param string
     * @return
     */
    public static DataMapValue of(String string) {
        return new DataMapValue(string);
    }

    /**
     * Make a data map with byte values
     * @param bytes
     * @return
     */
    public static DataMapValue of(byte[] bytes) {
        return new DataMapValue(bytes);
    }

}
