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

    public static final int COUNT_VALUES_TO_ADD = 50;
    public static final int COUNT_VALUES_TO_REMOVE = 50;

    @Test
    public void task14Test() throws Exception {
        final Map<Long, Man> manMap = Collections.synchronizedMap(new TreeMap<>());

        System.out.println("Main thread starting.");
        Thread threadPut1 = new Thread(new MyThreadRun("Thread #1", manMap));
        Thread threadPut2 = new Thread(new MyThreadRun("Thread #2", manMap));
        Thread threadRemove3 = new Thread(new MyThreadRemove("Thread #3", manMap));

        threadPut1.start();
        threadPut2.start();

        threadPut1.join();
        threadPut2.join();

        threadRemove3.start();
        threadRemove3.join();

        System.out.println("Main thread ending.");
        Assert.assertEquals(COUNT_VALUES_TO_ADD * 2 - COUNT_VALUES_TO_REMOVE, manMap.size());
    }
}
