package com.lidiabazhenova.task2;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Результат первого задания отфильтровать, результатом будет такая же коллекция, только с колонками first name и age
 */
public class Task2Test {

    @Test
    public void task2Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH);

        final List<Map<String, String>> newPeople = people.stream().map((person) -> {
            Map<String, String> newPerson = new HashMap<>();
            newPerson.put(CSVReaderUtil.FIRST_NAME, person.get(CSVReaderUtil.FIRST_NAME));
            newPerson.put(CSVReaderUtil.AGE, person.get(CSVReaderUtil.AGE));
            return newPerson;
        }).collect(Collectors.toList());

        Assert.assertEquals("Ivan", newPeople.get(0).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("18", newPeople.get(0).get(CSVReaderUtil.AGE));
        Assert.assertEquals("Olga", people.get(1).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("5", people.get(1).get(CSVReaderUtil.AGE));
        Assert.assertEquals("Sergey", people.get(2).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("48", people.get(2).get(CSVReaderUtil.AGE));
        Assert.assertEquals("Katja", people.get(3).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("5", people.get(3).get(CSVReaderUtil.AGE));
    }
}