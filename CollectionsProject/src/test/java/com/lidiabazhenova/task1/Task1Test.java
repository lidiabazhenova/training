package com.lidiabazhenova.task1;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Task1Test {

    private static final String USERS_CSV_FILE_PATH = "src/test/resources/users.csv";

    @Test
    public void task1Test() throws IOException {
        Assert.assertEquals(4, CSVReaderUtil.loadAllPersonsFromFile(USERS_CSV_FILE_PATH).size());
    }
}
