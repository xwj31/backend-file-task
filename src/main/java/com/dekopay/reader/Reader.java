package com.dekopay.reader;

import com.dekopay.model.User;

import java.util.List;

public interface Reader {

    List<User> read(String fileLocation);
}
