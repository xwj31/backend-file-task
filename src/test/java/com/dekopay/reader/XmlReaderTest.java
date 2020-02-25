package com.dekopay.reader;

import com.dekopay.error.XmlParseError;
import com.dekopay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlReaderTest {

    XmlReader xmlReader;

    @BeforeEach
    public void init() {
        xmlReader = new XmlReader();
    }

    @Test
    public void XmlReaderReadsValidXmlFile() {
        List<User> userList = xmlReader.read("src/main/resources/data/users.xml");
        assertThat(userList.size(), equalTo(3));
    }

    @Test
    public void XmlReaderThrowsParseException() {
        assertThrows(XmlParseError.class, () -> xmlReader.read("notValid.xml"));
    }
}
