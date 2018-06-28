package com.lidiabazhenova.task5;

import com.lidiabazhenova.Person;
import com.lidiabazhenova.common.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Результат первого задания отсортировать по first name
 */
public class Task5Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";
    private static final String key = "first name";

    @Test
    public void task5Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);
        Collections.sort(people, Comparator.comparing(person -> person.get("first name")));
        Assert.assertEquals("Ivan", people.get(0).get(key));
        Assert.assertEquals("Katja", people.get(1).get(key));
        Assert.assertEquals("Olga", people.get(2).get(key));
        Assert.assertEquals("Sergey", people.get(3).get(key));
    }



}
