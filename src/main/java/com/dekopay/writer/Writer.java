package com.dekopay.writer;

import com.dekopay.model.User;

import java.util.TreeSet;

public interface Writer {

    void write(TreeSet<User> users, String fileName);

}
