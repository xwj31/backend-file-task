package com.dekopay.writer;

import com.dekopay.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class CsvWriter implements Writer {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "User ID,First Name,Last Name,Username,User Type,Last Login Time";

    @Override
    public void write(TreeSet<User> users, String fileName) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER);

            fileWriter.append(NEW_LINE_SEPARATOR);

            for (User user : users) {
                fileWriter.append(String.valueOf(user.getUserId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getFirstName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getUserName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getUserType().name());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getLastLoginTime());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
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
