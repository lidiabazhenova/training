package com.lidiabazhenova.task3;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Первое задание, только изначально получаем значения только для выбранных колонок
 */
public class Task3Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";

    @Test
    public void task3Test() throws IOException {
        List<String> keys = new ArrayList<>();
        keys.add("first name");
        keys.add("age");
        List<Map<String, String>> people = CSVReaderUtil.loadCustomPersonsFromFile(USERS_CSV_FILE_PATH, keys);
        Assert.assertEquals(4, people.size()) ;
        System.out.println(people);
    }
}
