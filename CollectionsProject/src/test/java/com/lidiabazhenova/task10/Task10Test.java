package com.lidiabazhenova.task10;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Получить из коллекции List<Map<String, String>> коллекцию, где будут извлеченные значения из мапы по заданному клучу
 */
public class Task10Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";
    private static final String key = "last name";

    @Test
    public void task10Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);

        final List<String> valuesByKey = people.stream().map((person) -> person.get(key)).collect(Collectors.toList());

        System.out.println(valuesByKey);

        Assert.assertEquals("Ivanou", valuesByKey.get(0));
        Assert.assertEquals("Ivanova", valuesByKey.get(1));
        Assert.assertEquals("Vasiliev", valuesByKey.get(2));
        Assert.assertEquals("Novikava", valuesByKey.get(3));
    }
}
