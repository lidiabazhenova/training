package com.lidiabazhenova.task3;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Первое задание, только изначально получаем значения только для выбранных колонок
 */
public class Task3Test {

    @Test
    public void task3Test() throws IOException {
        List<String> keys = new ArrayList<>();
        keys.add("first name");
        keys.add("age");
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(keys);
        List<Map<String, String>> people = CSVReaderUtil.loadCustomPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH, keys);
        Assert.assertEquals(4, people.size());
    }
}