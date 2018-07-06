package com.lidiabazhenova.task16;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Преобразовать лист в строку
 */
public class Task16Test {

    @Test
    public void task16Test() {
        List<String> list = new LinkedList<>(Arrays.asList("one", "two", "three"));
        String csv = String.join(",", list);
        System.out.println(csv);
    }
}
