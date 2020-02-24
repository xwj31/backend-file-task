package com.dekopay.error;

public class CsvParseError extends  RuntimeException {
    public CsvParseError() {
        super("Error in parsing Csv file");
    }

    public CsvParseError(String message) {
        super("Error in parsing Csv file, Error: " + message);
    }
}
