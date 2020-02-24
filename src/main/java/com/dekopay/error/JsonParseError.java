package com.dekopay.error;

public class JsonParseError extends RuntimeException {

    public JsonParseError() {
        super("Error in parsing Json file");
    }

    public JsonParseError(String message) {
        super("Error in prasing Json file " + message);
    }
}
