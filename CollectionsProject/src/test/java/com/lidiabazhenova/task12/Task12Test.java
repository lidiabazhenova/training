package com.lidiabazhenova.task12;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Отсортировать внешний и внутренний листы в List<Map<String, List<String>>>
 */
public class Task12Test {

    @Test
    public void task12Test() throws IOException {
        List<Map<String, List<String>>> list = new ArrayList<>();
        Map<String, List<String>> map1 = new TreeMap<>();
        Map<String, List<String>> map2 = new TreeMap<>();

        map1.put("zmykey1", Arrays.asList("one", "two", "three"));
        map1.put("mykey2", Arrays.asList("four", "five", "six"));
        list.add(map1);

        map2.put("mykey3", Arrays.asList("seven", "eight", "nine"));
        map2.put("mykey4", Arrays.asList("ten", "eleven", "twelve"));
        list.add(map2);

        list.forEach((listMap) -> {
            for (List<String> listString : listMap.values()) {
                Collections.sort(listString);
            }
        });

        Collections.sort(list, Comparator.comparing(Object::toString));


        Collections.sort(list,
                Comparator.comparing(Object::toString));


        System.out.println(list);
    }
}
