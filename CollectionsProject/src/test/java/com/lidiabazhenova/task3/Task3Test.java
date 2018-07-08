package com.lidiabazhenova.task3;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Первое задание, только изначально получаем значения только для выбранных колонок
 */
public class Task3Test {

    @Test
    public void task3Test() throws IOException {
        List<String> keys = new ArrayList<>();
        keys.add("first name");
        keys.add("age");
        List<Map<String, String>> people = CSVReaderUtil.loadCustomPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH, keys);
        Assert.assertEquals(4, people.size());
    }
}