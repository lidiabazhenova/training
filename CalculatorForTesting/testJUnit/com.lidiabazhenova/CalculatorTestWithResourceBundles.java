package com.lidiabazhenova;

import org.junit.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class CalculatorTestWithResourceBundles {


    static final double DELTA = 0.0001;

    private Calculator calculator;

    private double firstAdd;
    private double secondAdd;
    private double resultAdd;
    private double firstSub;
    private double secondSub;
    private double resultSub;
    private ResourceBundle rb;
    String message = null;

    private void readPropertiesFile() throws IOException {
        Locale ourLocale = new Locale("en", "GB", "WIN");
        ResourceBundle rb = ResourceBundle.getBundle("_MyPropertiesFile", ourLocale);

        try {
            firstAdd = Double.parseDouble(rb.getString("First.Addition.Number"));
            secondAdd = Double.parseDouble(rb.getString("Second.Addition.Number"));
            resultAdd = Double.parseDouble(rb.getString("Result.Addition.Number"));
            firstSub = Double.parseDouble(rb.getString("First.Subtraction.Number"));
            secondSub = Double.parseDouble(rb.getString("Second.Subtraction.Number"));
            resultSub = Double.parseDouble(rb.getString("Result.Subtraction.Number"));
        } catch (MissingResourceException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readPropertiesFileRu() throws IOException {
        Locale ourLocale = new Locale("ru", "RUS", "WIN");
        ResourceBundle rb = ResourceBundle.getBundle("_MyPropertiesFile", ourLocale);

        try {
            message =  new String(rb.getString("Message").getBytes("ISO-8859-1"), "UTF-8");
        } catch (MissingResourceException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @Before
    public void setUp() throws IOException {
        this.calculator = new Calculator();


    }

    @Test
    public void add() throws Exception {
        readPropertiesFile();
        assertEquals(resultAdd, calculator.add(firstAdd, secondAdd), DELTA);
        System.out.println("Test add() passed");
    }

    @Test
    public void sub() throws Exception {
        readPropertiesFile();
        readPropertiesFileRu();
        System.out.println(firstSub);
        assertEquals(resultSub, calculator.sub(firstSub, secondSub), DELTA);
        System.out.println(message);
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


