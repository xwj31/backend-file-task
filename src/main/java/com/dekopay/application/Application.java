package com.dekopay.application;

import com.dekopay.model.User;
import com.dekopay.reader.CsvReader;
import com.dekopay.reader.JsonReader;
import com.dekopay.reader.XmlReader;
import com.dekopay.writer.CsvWriter;
import com.dekopay.writer.JsonWriter;
import com.dekopay.writer.XmlWriter;

import java.util.TreeSet;

public class Application {

    public static void main(String... args) {
        CsvReader csvReader = new CsvReader();
        JsonReader jsonReader = new JsonReader();
        XmlReader xmlReader = new XmlReader();

        CsvWriter csvWriter = new CsvWriter();
        JsonWriter jsonWriter = new JsonWriter();
        XmlWriter xmlWriter = new XmlWriter();

        TreeSet<User> userSet = new TreeSet<>();
                userSet.addAll(csvReader.read(args[0]));
                userSet.addAll(jsonReader.read(args[1]));
                userSet.addAll(xmlReader.read(args[2]));
                csvWriter.write(userSet, args[3]);
                jsonWriter.write(userSet, args[4]);
                xmlWriter.write(userSet, args[5]);
    }
}

