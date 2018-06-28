package com.lidiabazhenova.task6;

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
        final String[] stringArray = new String[]{ "first name", "last name", "age", "sex" };
        List<String> stringList = Arrays.asList(stringArray);
        Assert.assertEquals(4, stringList.size());
    }
}
