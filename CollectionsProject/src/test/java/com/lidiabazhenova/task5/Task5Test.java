package com.lidiabazhenova.task5;

import com.lidiabazhenova.common.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Результат первого задания отсортировать по first name
 */
public class Task5Test {

    @Test
    public void task5Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH);
        Collections.sort(people, Comparator.comparing(person -> person.get("first name")));
        Assert.assertEquals("Ivan", people.get(0).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("Katja", people.get(1).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("Olga", people.get(2).get(CSVReaderUtil.FIRST_NAME));
        Assert.assertEquals("Sergey", people.get(3).get(CSVReaderUtil.FIRST_NAME));
    }

}