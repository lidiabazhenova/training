package com.lidiabazhenova.task19;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * сделать коллекцию из результатов пересечения двух множеств
 */
public class Task19Test {

    @Test
    public void task19Test() {
        Set<Integer> integerSet1 = new HashSet<>();
        Set<Integer> integerSet2 = new HashSet<>();
        int startIndexSet2 = 10;

        for (int i = 0; i < 20; i++) {
            integerSet1.add(i);
            integerSet2.add(startIndexSet2 + i);
        }

        System.out.println(integerSet1);
        System.out.println(integerSet2);

        Set<Integer> intersection = new HashSet<>(integerSet1);
        intersection.retainAll(integerSet2);
        System.out.println(intersection);

        Assert.assertTrue(integerSet1.containsAll(intersection));
        Assert.assertTrue(integerSet2.containsAll(intersection));
    }
}

