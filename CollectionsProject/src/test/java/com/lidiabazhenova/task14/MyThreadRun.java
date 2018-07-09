package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class MyThreadRun implements Runnable {

    public static final int COUNT = 10;

    private final String name;
    private static Map<Long, Man> map;

    public MyThreadRun(String name, Map<Long, Man> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println(name + " starting.");
        fillInTheValuesInToMap(map);
        System.out.println(name + " terminating.");
    }

    public void fillInTheValuesInToMap(final Map<Long, Man> map) {

        for (int i = 0; i < COUNT; i++) {
            long id = Long.parseLong(RandomStringUtils.randomNumeric(14));
            map.put(id, new Man(id, "name", 12, "male"));
            System.out.println(this.name + " " + " put: " + id);
        }
    }
}
