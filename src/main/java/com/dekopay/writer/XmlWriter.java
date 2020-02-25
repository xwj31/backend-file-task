package com.dekopay.writer;

import com.dekopay.model.User;
import com.thoughtworks.xstream.XStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class XmlWriter implements Writer {

    @Override
    public void write(TreeSet<User> users, String fileName) {

        XStream xStream = new XStream();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(xStream.toXML(users));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
