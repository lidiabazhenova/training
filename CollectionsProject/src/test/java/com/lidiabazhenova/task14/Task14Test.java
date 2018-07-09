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
        Thread threadPut1 = new Thread(new MyThreadRun("Thread #1", manMap));
        Thread threadPut2 = new Thread(new MyThreadRun("Thread #2", manMap));
        Thread threadPut3 = new Thread(new MyThreadRun("Thread #3", manMap));

        threadPut1.start();
        threadPut2.start();
        threadPut3.start();

        threadPut1.join();
        threadPut2.join();
        threadPut3.join();

        Thread threadRemove1 = new Thread(new MyThreadRemove("Thread #1", manMap));
        Thread threadRemove2 = new Thread(new MyThreadRemove("Thread #2", manMap));
        Thread threadRemove3 = new Thread(new MyThreadRemove("Thread #3", manMap));

        threadRemove1.start();
        threadRemove2.start();
        threadRemove3.start();

        threadRemove1.join();
        threadRemove2.join();
        threadRemove3.join();

        System.out.println("Main thread ending.");
        Assert.assertEquals(0 * MyThreadRun.COUNT, manMap.size());
    }
}
