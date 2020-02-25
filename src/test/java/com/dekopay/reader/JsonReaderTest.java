package com.dekopay.reader;

import com.dekopay.error.JsonParseError;
import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonReaderTest {

    JsonReader jsonReader;

    @BeforeEach
    public void init() { jsonReader = new JsonReader();}

    @Test
    public void JsonReaderReadsValidJsonFile() {
        List<User> userList = jsonReader.read("src/main/resources/data/users.json");
        assertThat(userList.size(), equalTo(5));
    }

    @Test
    public void JsonReaderChecksFileType() {

    }

    @Test
    public void JsonReaderThrowsParseException() {
        assertThrows(JsonParseError.class, () -> jsonReader.read("notValid.json"));
    }
}
