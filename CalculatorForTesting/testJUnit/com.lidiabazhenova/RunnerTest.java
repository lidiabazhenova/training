package com.lidiabazhenova;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class RunnerTest {


    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests from RunnerTest started");
    }

    @Test
    @Category(NeedTest.class)
    public void notNullTest() throws Exception {
        Calculator calcRun = new Calculator();
        assertNotNull(calcRun);
        System.out.println("Test notNullTest() passed");
    }




       @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests from RunnerTest finished");
    }

}