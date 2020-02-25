package com.dekopay.error;

public class JsonParseError extends RuntimeException {

    public JsonParseError(String message) {
        super("Error in parsing Json file " + message);
    }
}
