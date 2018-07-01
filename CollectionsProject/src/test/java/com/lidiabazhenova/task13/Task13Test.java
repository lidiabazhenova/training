package com.lidiabazhenova.task13;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Убрать заданное значение из листа в Map<String, List<String>>
 */
public class Task13Test {
    private static final String key = "one";

    @Test
    public void task13Test() throws IOException {

        List<Map<String, List<String>>> list = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> list2 = new ArrayList<>(Arrays.asList("four", "five", "six"));
        List<String> list3 = new ArrayList<>(Arrays.asList("seven", "eight", "nine"));
        List<String> list4 = new ArrayList<>(Arrays.asList("one", "eight", "nine"));

        map1.put("mykey1", list1);
        map1.put("mykey2", list2);
        list.add(map1);

        map2.put("mykey3", list3);
        map2.put("mykey4", list4);
        list.add(map2);

        list.forEach((map) -> {

            for (List<String> listString : map.values()) {
                for (Iterator<String> iterator = listString.iterator(); iterator.hasNext(); ) {
                    String value = iterator.next();
                    if (value.equals("one")) {
                        iterator.remove();
                    }
                }
            }
        });

        //TODO Assertion
        list.forEach((map) -> {
            System.out.println(map.values());

        });
    }
}
