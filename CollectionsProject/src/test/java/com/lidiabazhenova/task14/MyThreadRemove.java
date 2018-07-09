package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyThreadRemove implements Runnable {

    private final String name;
    private static Map<Long, Man> map;

    public MyThreadRemove(String name, Map<Long, Man> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println(name + " starting.");
        removeTheValuesFromMap(map);
        System.out.println(name + " terminating.");
    }

    public void removeTheValuesFromMap(final Map<Long, Man> map) {
        final List<Long> keySet = new ArrayList<>();
        int count = 0;

        for (Map.Entry<Long, Man> entry : map.entrySet()) {
            if (count >= Task14Test.COUNT_VALUES_TO_REMOVE) break;
            keySet.add(entry.getKey());
            count++;
        }

        keySet.forEach((key) -> {
            map.remove(key);
            System.out.println(this.name + " " + " remove: " + key);});

        }

}

