package com.lidiabazhenova.task2;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";

    @Test
    public void task2Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);
        List<Map<String, String>> newPeople = new ArrayList<>();

        people.forEach((person) -> {
            Map<String, String> newPerson = new HashMap<>();
            newPerson.put("first name", person.get("first name"));
            newPerson.put("age", person.get("age"));
            newPeople.add(newPerson);
        });
        System.out.println(newPeople);
    }
}
