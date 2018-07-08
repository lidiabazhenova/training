package com.lidiabazhenova.task10;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Получить из коллекции List<Map<String, String>> коллекцию, где будут извлеченные значения из мапы по заданному клучу
 */
public class Task10Test {

    @Test
    public void task10Test() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH);

        final List<String> valuesByKey = people.stream()
                .map((person) -> person.get(CSVReaderUtil.LAST_NAME))
                .collect(Collectors.toList());

        Assert.assertEquals("Ivanou", valuesByKey.get(0));
        Assert.assertEquals("Ivanova", valuesByKey.get(1));
        Assert.assertEquals("Vasiliev", valuesByKey.get(2));
        Assert.assertEquals("Novikava", valuesByKey.get(3));
    }
}
