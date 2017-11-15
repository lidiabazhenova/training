package com.lidiabazhenova;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CalculatorNG {
    static final double  DELTA=0.001;

    @Test(enabled = false)
    public void tst() {
        Assert.fail();
        Assert.fail("Test failed!");
    }


    @Test
    public void tstAllAsserts() {
        Assert.assertEquals(2*2, 4, "Ok");
    }

    private Calculator calculator;
    private Info info;

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator(3);
        info = new Info(calculator.getResult());
    }

    @Test(priority = 1)

    public void add() throws Exception {
        assertEquals(calculator.add(1, 1), 2, DELTA);
        System.out.println("Test add() passed");
    }

    @Test(priority = 2)

    public void sub() throws Exception {
        assertEquals(calculator.sub(1, 1), 0, DELTA);
        System.out.println("Test sub() passed");
    }

    @Test(priority = 3)
    public void mul() throws Exception {
        assertEquals(calculator.mul(1, 2), 2, DELTA);
        System.out.println("Test mul() passed");
    }

    @Test(priority = 4)
    public void div() throws Exception {
        assertEquals(calculator.div(8, 2), 4, DELTA);
        System.out.println("Test div() passed");
    }

    @Test(priority = 5)
    public void cleanResult() throws Exception {
        calculator.cleanResult();
        assertEquals(calculator.getResult(), 0, DELTA);
        System.out.println("Test cleanResult() passed");
    }

    @Test
    public void classInfo() throws Exception {
        assertEquals(info.getResult(), 3, DELTA);
        System.out.println("Test classInfo() passed");
    }

    @Test(timeOut = 1000)
    public void classCalculatorClassInfo() throws Exception {
        assertEquals(calculator.getResult(), 3, DELTA);
        assertEquals( info.getResult(), 3, DELTA);
        assertTrue(calculator.getResult() == info.getResult());
        System.out.println("Test classCalculatorClassInfo() passed");

    }

    @Test
    public void calculatorSetGet() throws Exception {
        calculator.setResult("+", 7, 0);
        assertEquals(calculator.getResult(), 7, DELTA);
        System.out.println("Test calculatorSetGet() passed");
    }

    @Test
    public void constructorCalculator() throws Exception {
        assertEquals(calculator.getResult(), 3, DELTA);
        System.out.println("Test constructorCalculator() passed");
    }

    @Test(expectedExceptions = UserException.class)
    public void divByNull() throws UserException {
        calculator.div(1, 0);
        System.out.println("Test divByNull() passed");
    }

    @Test(expectedExceptions = UserException.class)
    public void mulMaxValue() throws UserException {
        calculator.mul(Double.MAX_VALUE, 1.00000001);
        System.out.println("Test mulMaxValue() passed");
    }

    @AfterMethod
    public void resertResult() {
        calculator.cleanResult();
        System.out.println("calculator.getResult()=" + calculator.getResult());
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests from CalculatorTest finished");
    }

}