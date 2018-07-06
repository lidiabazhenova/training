package com.lidiabazhenova.task20;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Создать множество с числами. Суммировать соседние числа попарно, пока не останется одно число
 */
public class Task20Test {

    @Test
    public void task20Test() {

        List<Integer> list = new LinkedList<>();
        List<Integer> bufferList = new LinkedList<>();

        for (int i = 0; i < 20; )
            list.add(++i);

        list.forEach((element) -> {
            System.out.print(element);
            System.out.print(" ");
        });
        System.out.println();

        while (list.size() > 1) {

            for (int i = 0; i < list.size() - 1; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);
                list.set(i, first + second);
                list.remove(i + 1);
            }

            list.forEach((element) -> {
                System.out.print(element);
                System.out.print(" ");
            });
            System.out.println();
        }
        Assert.assertTrue(list.size() == 1);
    }
}
