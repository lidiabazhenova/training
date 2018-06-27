package com.lidiabazhenova.task8;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class Task8Test {

    @Test
    public void task8Test() throws IOException {

        List<Map<String, List<String>>> list1 = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        map1.put("mykey1", Arrays.asList("one", "two", "three"));
        map1.put("mykey2", Arrays.asList("four", "five", "six"));
        list1.add(map1);

        map2.put("mykey1", Arrays.asList("seven", "eight", "nine"));
        map2.put("mykey2", Arrays.asList("ten", "eleven", "twelve"));
        list1.add(map2);

        List<Map<String, List<String>>> list2 = new ArrayList<>();
        Map<String, List<String>> map3 = new HashMap<>();
        Map<String, List<String>> map4 = new HashMap<>();

        map3.put("mykey1", Arrays.asList("one", "two", "three"));
        map3.put("mykey2", Arrays.asList("four", "five", "six"));
        list2.add(map3);

        map4.put("mykey1", Arrays.asList("nine", "eight", "seven"));
        map4.put("mykey2", Arrays.asList("ten", "twelve", "eleven"));
        list2.add(map4);

        Comparator<String> myComparator = (s1, s2) -> {
            if (s1 == null && s2 == null) return 0;
            if (s1 == null) return 1;
            if (s2 == null) return -1;
            return s1.compareTo(s2);
        };

        list1.forEach((map) -> {
            for (List<String> listString : map.values()) {
                Collections.sort(listString, myComparator);
            }
        });

        list2.forEach((map) -> {
            for (List<String> listString : map.values()) {
                Collections.sort(listString, myComparator);
            }
        });

        Assert.assertEquals(list1, list2);
    }
}
