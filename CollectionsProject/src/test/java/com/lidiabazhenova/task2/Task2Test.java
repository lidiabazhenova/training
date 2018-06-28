package com.lidiabazhenova.task2;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Результат первого задания отфильтровать, результатом будет такая же коллекция, только с колонками first name и age
 */
public class Task2Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";
    private static final String key1 = "first name";
    private static final String key2 = "age";

    @Test
    public void task2Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);

        final List<Map<String, String>> newPeople = people.stream().map((person) -> {
            Map<String, String> newPerson = new HashMap<>();
            newPerson.put(key1, person.get(key1));
            newPerson.put(key2, person.get(key2));
            return newPerson;
        }).collect(Collectors.toList());
        
        Assert.assertEquals("Ivan", newPeople.get(0).get(key1));
        Assert.assertEquals("18", newPeople.get(0).get(key2));
        Assert.assertEquals("Olga", people.get(1).get(key1));
        Assert.assertEquals("5", people.get(1).get(key2));
        Assert.assertEquals("Sergey", people.get(2).get(key1));
        Assert.assertEquals("48", people.get(2).get(key2));
        Assert.assertEquals("Katja", people.get(3).get(key1));
        Assert.assertEquals("5", people.get(3).get(key2));


    }
}
