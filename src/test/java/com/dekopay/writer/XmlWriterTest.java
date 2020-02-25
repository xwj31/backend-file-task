package com.dekopay.writer;

import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class XmlWriterTest {

    XmlWriter xmlWriter;
    TreeSet<User> treeSet;

    @BeforeEach
    public void init() {
        xmlWriter = new XmlWriter();
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
    public void XmlWriterWritesValidXml() {
        xmlWriter.write(treeSet, "src/main/resources/data/usersoutput.xml");
    }


}
