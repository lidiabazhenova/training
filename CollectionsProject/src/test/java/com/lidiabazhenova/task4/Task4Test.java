package com.lidiabazhenova.task4;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Из результатов первого задания получить коллекцию, содержащую только только имена колонок
 */
public class Task4Test {
    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";

    @Test
    public void task4OneKeyTest() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH);
        final Set<String> keyset = people.get(0).keySet();
        Assert.assertEquals(4, keyset.size());
    }

}

