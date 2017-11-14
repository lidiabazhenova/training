package com.lidiabazhenova;

import example.NeedTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

public class RunnerTest {
    Calculator calcRun = new Calculator();

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests from RunnerTest started");
    }

    @Test
    @Category(NeedTest.class)
    public void mainTest() throws Exception {
        assertNotNull(calcRun);
        System.out.println("Test mainTest() passed");
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.run(RunnerTest.class);
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests from RunnerTest finished");
    }

}