package com.lidiabazhenova.task1;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Получить все значения в коллекцию, где данные будут доступны по рядам таблицы,
 * а значения для конкретного ряда по ключу - имени колонки
 */
public class Task1Test {

    @Test
    public void task1Test() throws IOException {
        Assert.assertEquals(4, CSVReaderUtil.loadAllPersonsFromFile(CSVReaderUtil.USERS_CSV_FILE_PATH).size());
    }
}
