package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Три потока должны безопасно работать с Map <Long, Man>. Где Man - объект, см. #7
 */
public class Task14Test {


    @Test
    public void task14Test() throws Exception {
        final Map<Long, Man> manMap = Collections.synchronizedMap(new TreeMap<>());
        System.out.println("Main thread starting.");
        Thread mt1 = new Thread(new MyThread("Thread #1", manMap));
        Thread mt2 = new Thread(new MyThread("Thread #2", manMap));
        Thread mt3 = new Thread(new MyThread("Thread #3", manMap));

        mt1.start();
        mt2.start();
        mt3.start();

        mt1.join();
        mt2.join();
        mt3.join();

        System.out.println("Main thread ending.");
        Assert.assertEquals(3 * MyThread.COUNT, manMap.size());
    }

}
