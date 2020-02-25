package com.dekopay.writer;

import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class JsonWriterTest {

    JsonWriter jsonWriter;
    TreeSet<User> treeSet;

    @BeforeEach
    public void init() {
        jsonWriter = new JsonWriter();
        treeSet = new TreeSet<>();

        User user = new User();
        user.setUserId(1L);
        user.setFirstName("foo");
        user.setLastName("bar");
        user.setUserType(User.type.Employee);
        user.setUserName("f");
        user.setLastLoginTime("ggg");
        treeSet.add(user);
    }

    @Test
    public void JsonWriterWritesValidJsonFile() {
        jsonWriter.write(treeSet,"src/main/resources/data/usersoutput.json");
    }
}
