package com.dekopay.reader;

import com.dekopay.error.JsonParseError;
import com.dekopay.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader implements Reader {

    Gson gson;
    List<User> userList;
    Type listType;

    public JsonReader() {
        gson = new Gson();
        listType = new TypeToken<List<User>>(){}.getType();
    }

    @Override
    public List<User> read(String fileLocation) {

        try(java.io.Reader reader = new FileReader(fileLocation)) {
            userList = gson.fromJson(reader, listType);
        } catch (IOException | JsonSyntaxException exception) {
            throw new JsonParseError(exception.getMessage());
        }
        return userList;
    }
}
