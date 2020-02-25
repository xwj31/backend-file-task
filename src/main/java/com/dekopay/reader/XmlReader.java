package com.dekopay.reader;

import com.dekopay.error.XmlParseError;
import com.dekopay.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements Reader {

    @Override
    public List<User> read(String fileLocation) {

        File file = new File(fileLocation);
        List<User> userSet = new ArrayList<>();
        NodeList nodeList;

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("user");

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new XmlParseError(e.getMessage());
        }

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                User user = new User();
                user.setUserId(Long.valueOf(element.getElementsByTagName("userid").item(0).getTextContent()));
                user.setFirstName(element.getElementsByTagName("firstname").item(0).getTextContent());
                user.setLastName(element.getElementsByTagName("surname").item(0).getTextContent());
                user.setUserName(element.getElementsByTagName("username").item(0).getTextContent());
                user.setUserType(User.type.valueOf(element.getElementsByTagName("type").item(0).getTextContent()));
                user.setLastLoginTime(element.getElementsByTagName("lastlogintime").item(0).getTextContent());
                userSet.add(user);
            }
        }
        return userSet;
    }
}
