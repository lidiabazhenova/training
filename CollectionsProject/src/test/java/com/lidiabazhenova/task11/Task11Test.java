package com.lidiabazhenova.task11;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Преобразовать все значения из List<String> в List<Double>. Добавить проверку на то, что это число
 */
public class Task11Test {

    @Test
    public void task11Test() {
        final List<String> stringList = Arrays.asList("1.3", "2.3dd", "3333", "5");
        final List<Double> doubles = new ArrayList<>();

        stringList.forEach(string -> {
            if (NumberUtils.isNumber(string))
                doubles.add(NumberUtils.toDouble(string));
        });

        Assert.assertEquals(3, doubles.size());
    }
}