package com.dekopay.writer;

import com.dekopay.model.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class JsonWriter implements Writer {

    Gson gson = new Gson();

    @Override
    public void write(TreeSet<User> users, String fileName) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(gson.toJson(users));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
