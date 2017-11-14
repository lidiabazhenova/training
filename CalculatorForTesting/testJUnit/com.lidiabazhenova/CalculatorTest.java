package com.lidiabazhenova;

import example.NeedTest;
import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;
    private Info info;

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @Before
    public void setUp() {
        calculator = new Calculator(3);
        info = new Info(calculator.getResult());
    }

    @Test
    @Category(NeedTest.class)
    public void add() throws Exception {
        assertEquals(2, calculator.add(1, 1), 0.00001);
        System.out.println("Test add() passed");
    }

    @Test
    @Category(NeedTest.class)
    public void sub() throws Exception {
        assertEquals(0, calculator.sub(1, 1), 0.00001);
        System.out.println("Test sub() passed");
    }

    @Ignore("Test mullIgnore ignored")
    @Test
    public void mulIgnore() throws Exception {
        assertEquals(1, calculator.mul(1, 1), 0.00001);
        System.out.println("Test mullIgnore() passed");
    }

    @Test
    public void mul() throws Exception {
        assertEquals(1, calculator.mul(1, 1), 0.00001);
        System.out.println("Test mul() passed");
    }

    @Test
    public void div() throws Exception {
        assertEquals(1, calculator.div(1, 1), 0.00001);
        System.out.println("Test div() passed");
    }

    @Test
    public void cleanResult() throws Exception {
        calculator.cleanResult();
        assertEquals(0, calculator.getResult(), 0.000001);
        System.out.println("Test cleanResult() passed");
    }

    @Test
    public void classCalculator() throws Exception {
        assertEquals(3, calculator.doOperation("+", 1, 2), 0.0001);
        assertEquals(3, calculator.getResult(), 0.000001);
        System.out.println("Test classCalculator() passed");
    }

    @Test
    public void classInfo() throws Exception {
        assertEquals(3, info.getResult(), 0.000001);
        System.out.println("Test classInfo() passed");
    }

    @Test(timeout = 500)
    public void classCalculatorClassInfo() throws Exception {
        assertEquals(3, calculator.getResult(), 0.000001);
        assertEquals(3, info.getResult(), 0.000001);
        assertTrue(calculator.getResult() == info.getResult());
        System.out.println("Test classCalculatorClassInfo() passed");

    }

    @Test
    public void calculatorSetGet() throws Exception {
        calculator.setResult("+", 7, 0);
        assertEquals(7, calculator.getResult(), 0.000001);
        System.out.println("Test calculatorSetGet() passed");
    }

    @Test
    public void constructorCalculator() throws Exception {
        assertEquals(3, calculator.getResult(), 0.000001);
        System.out.println("Test constructorCalculator() passed");
    }

    @Test(expected = UserException.class)
    public void divByNull() throws UserException {
        calculator.div(1, 0);
        System.out.println("Test divByNull() passed");
    }

    @Test(expected = UserException.class)
    public void mulMaxValue() throws UserException {
        calculator.mul(Double.MAX_VALUE, 1.00000001);
        System.out.println("Test mulMaxValue() passed");
    }

    @Test
    public void tstAllAsserts() {
        fail();
        fail("Test failed!");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests from CalculatorTest finished");
    }

}