package com.lidiabazhenova.task8;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Есть две коллекции List<Map<String, List<String>>> с разным содержанием. Сравните их
 */
public class Task8Test {

    @Test
    public void task8Test() throws IOException {
        List<Map<String, List<String>>> list1 = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        map1.put("mykey1", Arrays.asList("1", "2", "3"));
        map1.put("mykey2", Arrays.asList("4", "5", "6"));
        list1.add(map1);

        map2.put("mykey1", Arrays.asList("7", "8", "9"));
        map2.put("mykey2", Arrays.asList("10", "11", "12"));
        list1.add(map2);

        List<Map<String, List<String>>> list2 = new ArrayList<>();
        Map<String, List<String>> map3 = new HashMap<>();
        Map<String, List<String>> map4 = new HashMap<>();

        map3.put("mykey1", Arrays.asList("one", "two", "three"));
        map3.put("mykey2", Arrays.asList("four", "five", "six"));
        list2.add(map3);

        map4.put("mykey1", Arrays.asList("seven", "eight", "nine"));
        map4.put("mykey2", Arrays.asList("ten", "eleven", "twelve"));
        list2.add(map4);

        Assert.assertFalse(list1.equals(list2));
    }
}
