package com.lidiabazhenova.task9;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Сравние, что коллекция List<Map<String, List<String>>> содержит значения из List<List<String>>
 */
public class Task9Test {

    @Test
    public void task9Test() throws IOException {
        List<Map<String, List<String>>> list1 = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        map1.put("mykey1", Arrays.asList("1", "2", "3"));
        map1.put("mykey2", Arrays.asList("4", "5", "6"));
        list1.add(map1);

        map2.put("mykey1", Arrays.asList("7", "8", "9"));
        map2.put("mykey2", Arrays.asList("10", "11", "12"));
        list1.add(map2);

        List<List<String>> list2 = new ArrayList<>();

        list2.add(Arrays.asList("10", "11", "12"));
        list2.add(Arrays.asList("1", "2", "3"));

        list1.forEach((map) -> {

            for (List<String> listString : map.values()) {
                if (list2.contains(listString)) {
                    System.out.print("Contains values: ");
                    System.out.println(listString);
                }
            }
        });
    }
}
