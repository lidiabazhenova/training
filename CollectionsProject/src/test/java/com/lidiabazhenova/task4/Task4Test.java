package com.lidiabazhenova.task4;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Из результатов первого задания получить коллекцию, содержащую только только имена колонок
 */
public class Task4Test {

    @Test
    public void task4OneKeyTest() throws IOException {
        List<Map<String, String>> people = CSVReaderUtil.loadAllPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH);
        final Set<String> keySet = people.get(0).keySet();
        Assert.assertEquals(4, keySet.size());
    }

}