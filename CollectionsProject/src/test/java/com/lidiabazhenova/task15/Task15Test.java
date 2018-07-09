package com.lidiabazhenova.task15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Убрать дубликаты из List<List<String>>
 */
public class Task15Test {

    @Test
    public void test15Test(){
        List<List<String>> list = new ArrayList<>();

        list.add(Arrays.asList("10", "11", "12"));
        list.add(Arrays.asList("10", "11", "12"));
        list.add(Arrays.asList("10", "11", "12"));
        list.add(Arrays.asList("10", "11", "10"));
        list.add(Arrays.asList("1", "2", "3"));
        list.add(Arrays.asList("1", "2", "3"));

        Set<List<String>> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);

        System.out.println(list);
    }
}
