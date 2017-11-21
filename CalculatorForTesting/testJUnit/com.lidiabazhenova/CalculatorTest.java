package com.lidiabazhenova;

import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {


    static final double DELTA = 0.0001;

    private Calculator calculator;
    private Info info;

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");

    }

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.info = new Info(calculator.getResult());
    }

    @Test
    @Category(NeedTest.class)
    public void add() throws Exception {
        assertEquals(5, calculator.add(1, 4), DELTA);
        System.out.println("Test add() passed");
    }

    @Test
    @Category(NeedTest.class)
    public void sub() throws Exception {
        assertEquals(4, calculator.sub(8, 4), DELTA);
        System.out.println("Test sub() passed");
    }

    @Ignore("Test mullIgnore ignored")
    @Test
    public void mulIgnore() throws Exception {
        assertEquals(1, calculator.mul(1, 1), DELTA);
        System.out.println("Test mulIgnore() passed");
    }

    @Test
    public void mul() throws Exception {
        assertEquals(1, calculator.mul(1, 1), DELTA);
        System.out.println("Test mul() passed");
    }

    @Test
    public void div() throws Exception {
        assertEquals(1, calculator.div(1, 1), DELTA);
        System.out.println("Test div() passed");
    }

    @Test
    public void cleanResult() throws Exception {
        calculator.cleanResult();
        assertEquals(0, calculator.getResult(), DELTA);
        System.out.println("Test cleanResult() passed");
    }


    @Test
    public void doOperation() {
        assertEquals(6, calculator.doOperation("+", 4, 2), DELTA);
    }

    @Test
    public void classCalculator() throws Exception {
        assertNotNull("calculator failed", calculator);
        System.out.println("Test classCalculator() passed");
    }

    @Test
    public void classInfo() throws Exception {
        assertThat(info.getResult(), is(0.0));
        //assertEquals(0, info.getResult(), 0.000001);
        System.out.println("Test classInfo() passed");
    }

    @Test(timeout = 500)
    public void classCalculatorClassInfo() throws Exception {

        assertEquals(0, calculator.getResult(), DELTA);
        assertEquals(0, info.getResult(), DELTA);
        assertTrue(calculator.getResult() == info.getResult());
        System.out.println("Test classCalculatorClassInfo() passed");

    }

    @Test
    public void calculatorSetGet() throws Exception {
        calculator.setResult("+", 7, 0);
        assertEquals(7, calculator.getResult(), DELTA);
        System.out.println("Test calculatorSetGet() passed");
    }

    @Test
    public void constructorCalculator() throws Exception {
        assertEquals(0, calculator.getResult(), DELTA);
        assertTrue("Test constructorCalculator() ignored", calculator.getResult() == 0);
        System.out.println("Test constructorCalculator() passed");
    }

    @Test(expected = UserException.class, timeout = 1000)
    public void divByNull() throws UserException {
        calculator.div(1, 0);
        System.out.println("Test divByNull() passed");
    }

    @Test(expected = UserException.class)
    public void mulMaxValue() throws UserException {
        calculator.mul(Double.MAX_VALUE, 1.00000001);
        System.out.println("Test mulMaxValue() passed");
    }

    @After
    public void deleteCalculator() {
        this.calculator = null;
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests from CalculatorTest finished");
    }
}


