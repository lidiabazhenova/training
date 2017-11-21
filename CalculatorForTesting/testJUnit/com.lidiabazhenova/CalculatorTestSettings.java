package com.lidiabazhenova;

import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTestSettings {


    static final double DELTA = 0.0001;

    private Calculator calculator;
    private Info info;
    private static double firstForAddition;
    private static double secondForAddition;
    private static double resultAddition;
    private static double first;
    private static double second;
    private static double result;




    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
        firstForAddition = Double.parseDouble(System.getProperty("first"));
        secondForAddition = Double.parseDouble(System.getProperty("second"));
        resultAddition = Double.parseDouble(System.getProperty("result"));

    }

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.info = new Info(calculator.getResult());
    }

    @Test
    @Category(NeedTest.class)
    public void add() throws Exception {
        assertEquals(resultAddition, calculator.add(firstForAddition, secondForAddition), DELTA);
        System.out.println("Test add() passed");
    }

    @Test
    @Category(NeedTest.class)
    public void sub() throws Exception {
        first=Double.parseDouble(System.getenv("first"));
        second=Double.parseDouble(System.getenv("second"));
        result=Double.parseDouble(System.getenv("result"));

        assertEquals(result, calculator.sub(first, second), 0.00001);
        System.out.println("Test sub() passed");
    }

    @Ignore("Test mullIgnore ignored")
    @Test
    public void mulIgnore() throws Exception {
        assertEquals(1, calculator.mul(1, 1), 0.00001);
        System.out.println("Test mulIgnore() passed");
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
    public void doOperation() {
        assertEquals(6, calculator.doOperation("+", 4, 2), 0.0001);
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

        assertEquals(0, calculator.getResult(), 0.000001);
        assertEquals(0, info.getResult(), 0.000001);
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
        assertEquals(0, calculator.getResult(), 0.000001);
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

    public void readCommandLineParameters(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Arg " + i + " = " + args[i]);
        }
    }
}

