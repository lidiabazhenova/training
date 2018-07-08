package com.lidiabazhenova.task6;

import com.lidiabazhenova.common.CSVReaderUtil;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Преобразовать произвольный массив строк в лист
 */
public class Task6Test {

    @Test
    public void task6Test() throws IOException {
        final String[] stringArray = new String[]{CSVReaderUtil.FIRST_NAME, CSVReaderUtil.LAST_NAME, CSVReaderUtil.AGE, CSVReaderUtil.SEX};
        List<String> stringList = Arrays.asList(stringArray);
        Assert.assertEquals(4, stringList.size());
    }
}
