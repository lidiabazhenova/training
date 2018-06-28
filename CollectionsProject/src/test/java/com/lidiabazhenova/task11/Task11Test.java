package com.lidiabazhenova.task11;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11Test {

    @Test
    public void task11Test() {
        final List<String> stringList = Arrays.asList("1.3", "2.3", "3333", "5");
        final List<Double> doubles = new ArrayList<>();
        doubles.addAll(stringList.stream().map(NumberUtils::toDouble).collect(Collectors.toList()));

       //TODO Assertion
        System.out.println(doubles);

    }
}
