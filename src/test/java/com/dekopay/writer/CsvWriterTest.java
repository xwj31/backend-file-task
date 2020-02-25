package com.dekopay.writer;

import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class CsvWriterTest {

    CsvWriter csvWriter;
    TreeSet<User> treeSet;

    @BeforeEach
    public void init() {
        csvWriter = new CsvWriter();
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
    public void CsvWriterWritesValidCsvFile() {
        csvWriter.write(treeSet,"src/main/resources/data/usersoutput.csv");
    }
}
