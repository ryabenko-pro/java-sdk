package com.elarian.model;

/**
 *
 */
public class DataValue {
    public String string = null;
    public byte[] bytes = null;

    private DataValue(String stringValue) {
        this.string = stringValue;
    }

    private DataValue(byte[] byteValue) {
        this.bytes = byteValue;
    }

    /**
     * Make a data map with a string value
     * @param string
     * @return
     */
    public static DataValue of(String string) {
        return new DataValue(string);
    }

    /**
     * Make a data map with byte values
     * @param bytes
     * @return
     */
    public static DataValue of(byte[] bytes) {
        return new DataValue(bytes);
    }

}
