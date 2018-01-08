package com.lidiabazhenova;

import org.junit.Before;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class CalculatorNGProperties {
    public static final Double DELTA = 0.0001;

    private Calculator calculator;
    private static Properties prop;
    private double first;
    private double second;
    private double result;

    private static void readPropertiesFile() throws IOException {
        String path = CalculatorTestWithProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        FileInputStream fis = new FileInputStream(path + "\\com.lidiabazhenova\\calculator.properties");
        prop = new Properties();
        prop.load(fis);

    }

    @BeforeSuite
    public void setUp() throws IOException {
        this.calculator = new Calculator();
        readPropertiesFile();
    }

    @Test
    public void add() throws Exception {
        first= Double.parseDouble(prop.getProperty("First.Addition.Number"));
        second= Double.parseDouble(prop.getProperty("Second.Addition.Number"));
        assertEquals(calculator.add(first, second), 10.0, DELTA);
        System.out.println("Test add() passed");
    }

}
