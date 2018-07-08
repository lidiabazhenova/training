package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Map;

public class MyThread implements Runnable {
    private String name;
    private static Map<Long, Man> map;

    private Man Ivan = new Man(11110000, "Ivan", 22, "male");
    private Man Alex = new Man(11110001, "Alex", 34, "male");
    private Man Valeria = new Man(11110002, "Valeria", 29, "female");

    public MyThread(String name, Map<Long, Man> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public void run() {

        System.out.println(name + " starting.");
        try {
            {
                fillInTheValuesInToMap();
                Thread.sleep(400);

            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " terminating.");
    }

    public static void fillInTheValuesInToMap() {

        for (int i = 0; i < 400000; i++) {
            long id = Long.parseLong(RandomStringUtils.randomNumeric(12));
            map.put(id, new Man(id, "name", 12, "male"));
        }
    }
}

