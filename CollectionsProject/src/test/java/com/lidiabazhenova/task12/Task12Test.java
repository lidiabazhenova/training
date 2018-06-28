package com.lidiabazhenova.task12;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Отсортировать внешний и внутренний листы в List<Map<String, List<String>>>
 */
public class Task12Test {

    @Test
    public void task12Test() throws IOException {

        List<Map<String, List<String>>> list = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();

        map1.put("mykey1", Arrays.asList("one", "two", "three"));
        map1.put("mykey2", Arrays.asList("four", "five", "six"));
        list.add(map1);

        map2.put("mykey3", Arrays.asList("seven", "eight", "nine"));
        map2.put("mykey4", Arrays.asList("ten", "eleven", "twelve"));
        list.add(map2);

        Comparator<String> listComparator = (s1, s2) -> {
            if (s1 == null && s2 == null) return 0;
            if (s1 == null) return 1;
            if (s2 == null) return -1;
            return s1.compareTo(s2);
        };

        list.stream().map((listMap) -> {
            for (List<String> listString : listMap.values()) {
                Collections.sort(listString, listComparator);
            }
            return list;
        }).collect(Collectors.toList());

        System.out.println(list);
    }
}
