package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Три потока должны безопасно работать с Map <Long, Man>. Где Man - объект, см. #7
 */
public class Task14Test {
    private static final Map<Long, Man> manMap = Collections.synchronizedMap(new TreeMap<>());

    @Test
    public void task14Test() throws Exception {


        System.out.println("Main thread starting.");
        Thread mt1 = new Thread(new MyThread("Child #1", manMap));
        Thread mt2 = new Thread(new MyThread("Child #2", manMap));
        Thread mt3 = new Thread(new MyThread("Child #3", manMap));

        mt1.start();
        mt2.start();
        mt3.start();

        mt1.join();
        mt2.join();
        mt3.join();

        System.out.println("Main thread ending.");
        System.out.println("size = " + manMap.size());
    }


}
