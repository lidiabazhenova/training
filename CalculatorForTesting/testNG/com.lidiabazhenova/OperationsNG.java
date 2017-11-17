package com.lidiabazhenova;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class OperationsNG {

    static final double DELTA = 0.001;

    Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        calculator= new Calculator();
    }

    @Test(groups = {"operations.add"})
    public void add() throws Exception {
        assertEquals(calculator.add(1, 4), 5, DELTA);
        System.out.println("Test add() passed");
    }

    @Test(groups = {"operations.sub"})
    public void sub() throws Exception {
        assertEquals(calculator.sub(1, 1), 0, DELTA);
        System.out.println("Test sub() passed");
    }

    @Test(groups = {"operations.mul"})
    public void mul() throws Exception {
        assertEquals(calculator.mul(1, 2), 2, DELTA);
        System.out.println("Test mul() passed");
    }

    @Test(groups = {"operations.div"})
    public void div() throws Exception {
        assertEquals(calculator.div(8, 2), 4, DELTA);
        System.out.println("Test div() passed");
    }

    @Test(expectedExceptions = UserException.class, groups = {"negative.div"})
    public void divByNull() throws UserException {
        calculator.div(1, 0);
        System.out.println("Test divByNull() passed");
    }
}
