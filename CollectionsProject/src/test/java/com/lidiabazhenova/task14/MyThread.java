package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import java.util.Map;

public class MyThread implements Runnable {
    private String name;
    Map<Long, Man> map;

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
            for (int count = 0; count < 10; count++) {

                Thread.sleep(400);
                map.put(Ivan.getId(), Ivan);
                map.put(Alex.getId(), Alex);
                map.put(Valeria.getId(), Valeria);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " terminating.");
    }
}

