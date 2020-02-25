package com.dekopay.reader;

import com.dekopay.error.CsvParseError;
import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CsvReaderTest {

    CsvReader csvReader;

    @BeforeEach
    public void init() {
        csvReader = new CsvReader();
    }

    @Test
    public void CsvReaderReadsValidCsvFile() {
        List<User> userList = csvReader.read("src/main/resources/data/users.csv");
        assertThat(userList.size(), equalTo(2));
    }

    @Test
    public void CsvReaderChecksFileType() {

    }

    @Test
    public void CsvReaderThrowsParseException() {
        assertThrows(CsvParseError.class, () -> csvReader.read("/notValid.csv"));
    }
}
