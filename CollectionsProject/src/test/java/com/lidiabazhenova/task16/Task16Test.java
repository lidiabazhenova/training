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
    public void task16Test(){
        List<String> list = new LinkedList<>(Arrays.asList("Мама", " мыла", " раму."));
        String csv = String.join(" ", list);
        System.out.println(csv);

        String str1 = "Мама мыла раму.";
        System.out.println(str1.matches("^[Ммаылру .]+"));

        String[] strpart = str1.split(" ");
        for (String part : strpart) {
            System.out.println(part + " ");
        }

        StringBuilder string = new StringBuilder();

    }
}
