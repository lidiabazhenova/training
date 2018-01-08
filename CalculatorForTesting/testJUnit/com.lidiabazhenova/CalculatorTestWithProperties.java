package com.lidiabazhenova;

import org.junit.*;
import org.junit.experimental.categories.Category;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTestWithProperties {

    static final double DELTA = 0.0001;

    private Calculator calculator;
    private static Properties p;
    private double first;
    private double second;
    private double result;

    private static void readPropertiesFile() throws IOException {
        String path = CalculatorTestWithProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        FileInputStream fis = new FileInputStream(path + "\\com.lidiabazhenova\\calculatorprop.properties");
        p = new Properties();
        p.load(fis);

    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");

    }

    @Before
    public void setUp() throws IOException {
        this.calculator = new Calculator();
        readPropertiesFile();
    }

    @Test
    public void add() throws Exception {

        first = Double.parseDouble(p.getProperty("First.Addition.Number"));
        second = Double.parseDouble(p.getProperty("Second.Addition.Number"));
        result = Double.parseDouble(p.getProperty("Result.Addition.Number"));
        assertEquals(result, calculator.add(first, second), DELTA);
        System.out.println("Test add() passed");
    }

    @Test
    public void sub() throws Exception {
        first = Double.parseDouble(p.getProperty("First.Subtraction.Number"));
        second = Double.parseDouble(p.getProperty("Second.Subtraction.Number"));
        result = Double.parseDouble(p.getProperty("Result.Subtraction.Number"));
        assertEquals(result, calculator.sub(first, second), DELTA);
        System.out.println("Test sub() passed");
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


