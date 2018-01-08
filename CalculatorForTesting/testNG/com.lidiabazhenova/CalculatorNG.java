package com.lidiabazhenova;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;


public class CalculatorNG {

    static final double DELTA = 0.001;

    private Calculator calculator = new Calculator();
    private Info info;

    @BeforeClass
    public void allTestsStarted() {
        System.out.println("All tests started");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("One-Be-foreSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("One-Before-Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("One-Before-Test");
    }

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator(3);
        info = new Info(calculator.getResult());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("One-Before-Method");
    }

    @Test
    public void tst() {
        Assert.fail();
        Assert.fail("Test failed!");
    }

    @Test
    public void tstAllAsserts() {
        Assert.assertEquals(2 * 2, 4, "Ok");
    }


    @Test(groups = {"operations.add"})

    public void add() throws Exception {
        assertEquals(calculator.add(1, 1), 2, DELTA);
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

    @Test(expectedExceptions = UserException.class, groups = {"operations.negative"})
    public void divByNull() throws UserException {
        calculator.div(1, 0);
    }

    @Test(expectedExceptions = UserException.class)
    public void mulMaxValue() throws UserException {
        calculator.mul(Double.MAX_VALUE, 1.00000001);
    }

    @AfterMethod
    public void deleteCalculator() {
        this.calculator = null;
    }

    @AfterClass
    public void allTestsFinished() {
        System.out.println("All tests from CalculatorTest finished");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("One-After-Method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("One-Af-terTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("One-After-Class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("One-After-Suite");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("One-Before-Groups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("One-After-Groups");
    }

    public static class InfoTest {

        List<String> storedList;
        Info info = new Info("+", 2.0, 2.0, 4.0);

        @Test
        @Parameters({"paramInt", "paramStr"})
        public void testCreateHtml(int in, String st) throws Exception{
            //storedList=info.write();
           // Assert.assertNull(storedList);
            System.out.println(in + " = " + st);
        }

    }
}