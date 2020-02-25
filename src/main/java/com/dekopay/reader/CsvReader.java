package com.dekopay.reader;

import com.dekopay.error.CsvParseError;
import com.dekopay.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvReader implements Reader {

    @Override
    public List<User> read(String fileLocation) {
        Optional<List<User>> inputList;
        File file = new File(fileLocation);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            inputList = Optional.of(bufferedReader.lines()
                    .skip(1) // skip the header of the csv
                    .map(mapToItem)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            throw new CsvParseError(e.getMessage());
        }
        return inputList.orElseThrow(CsvParseError::new);
    }

    Function<String, User> mapToItem = (line) -> {
        String[] record = line.split(",");

        User user = new User();

        user.setUserId(Long.valueOf(record[0]));
        user.setFirstName(record[1]);
        user.setLastName(record[2]);
        user.setUserName(record[3]);
        user.setUserType(User.type.valueOf(record[4]));
        user.setLastLoginTime(record[5]);
        return user;
    };
}
