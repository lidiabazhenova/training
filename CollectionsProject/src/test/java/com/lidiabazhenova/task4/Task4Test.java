package com.lidiabazhenova.task4;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class Task4Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";
    Set<String> keyset;

    @Test
    public void task4OneKeyTest() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);
        final Set<String> keyset = people.get(0).keySet();
        Assert.assertEquals(4, keyset.size());
    }

    @Test
    public void task4AllKeysTest() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);

        people.forEach((person) -> {
            keyset = person.keySet();
            System.out.println(keyset);
        });



    }
}

