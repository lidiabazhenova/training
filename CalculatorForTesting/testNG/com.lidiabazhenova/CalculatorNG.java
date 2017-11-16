package com.lidiabazhenova;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class CalculatorNG {

    static final double DELTA = 0.001;

    private Calculator calculator=new Calculator();
    private Info info;

    @Test(enabled = false)
    public void tst() {
        Assert.fail();
        Assert.fail("Test failed!");
    }

    @Test
    public void tstAllAsserts() {
        Assert.assertEquals(2 * 2, 4, "Ok");
    }

    @BeforeClass
    public void allTestsStarted() {
        System.out.println("All tests started");
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator(3);
        info = new Info(calculator.getResult());
    }

    @Test(groups = { "operations.add" })

    public void add() throws Exception {
        assertEquals(calculator.add(1, 1), 2, DELTA);
        System.out.println("Test add() passed");
    }

    @Test(groups = { "operations.sub" })

    public void sub() throws Exception {
        assertEquals(calculator.sub(1, 1), 0, DELTA);
        System.out.println("Test sub() passed");
    }

    @Test(groups = { "operations.mul" })

    public void mul() throws Exception {
        assertEquals(calculator.mul(1, 2), 2, DELTA);
        System.out.println("Test mul() passed");
    }

    @Test(groups = { "operations.div" })

    public void div() throws Exception {

        assertEquals(calculator.div(8, 2), 4, DELTA);
        System.out.println("Test div() passed");
    }

    @Test

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
        assertEquals(info.getResult(), 3, DELTA);
        assertTrue(calculator.getResult() == info.getResult());
        System.out.println("Test classCalculatorClassInfo() passed");

    }

    @Test(priority = 1)
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

    @Test(expectedExceptions = UserException.class, groups = {"operations.negative"})
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
    public void allTestsFinished() {
        System.out.println("All tests from CalculatorTest finished");
    }

    @BeforeGroups
    public  void groupsBeginner() {
        System.out.println("Groups begin");
    }

    @AfterGroups
    public void groupsEnd() {
        System.out.println("Groups end");
    }

}