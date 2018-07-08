package com.lidiabazhenova.task14;

import com.lidiabazhenova.Man;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Три потока должны безопасно работать с Map <Long, Man>. Где Man - объект, см. #7
 */
public class Task14Test {



    @Test
    public void task14Test() throws Exception {

        Map<Long, Man> manList = Collections.synchronizedMap(new TreeMap<>());
        System.out.println("Main thread starting.");
        Thread mt1 = new Thread(new MyThread("Child #1", manList));
        Thread mt2 = new Thread(new MyThread("Child #2", manList));
        Thread mt3 = new Thread(new MyThread("Child #3", manList));

        mt1.start();
        mt2.start();
        mt3.start();

        mt1.join();
        mt2.join();
        mt3.join();

        System.out.println("Main thread ending.");

//        Assert.assertEquals("Ivan", newManList.get(0).get("11110000"));
//        Assert.assertEquals("Alex", newManList.get(1).get("11110001"));
//        Assert.assertEquals("Valeria", newManList.get(2).get("11110002"));

    }
}
