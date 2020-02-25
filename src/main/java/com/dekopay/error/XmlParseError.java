package com.dekopay.error;

public class XmlParseError extends RuntimeException {

    public XmlParseError(String message) {
        super("Error in parsing Xml file, Error " + message);
    }
}
