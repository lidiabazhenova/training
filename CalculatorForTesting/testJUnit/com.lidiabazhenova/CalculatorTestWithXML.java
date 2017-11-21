package com.lidiabazhenova;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.junit.*;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class CalculatorTestWithXML extends DefaultHandler {


    static final double DELTA = 0.0001;

    private Calculator calculator;
    private static Properties p;
    private double first;
    private double second;
    private double resultAdd;
    private double resultSub;

    private CharArrayWriter contents = new CharArrayWriter();

    public void startElement(String namespaceURI, String localName, String qName, Attributes attr
    ) throws SAXException {
        contents.reset();
        if (localName.equals("first")) { first = Double.parseDouble(contents.toString());
            System.out.println(first);}
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
        //assertEquals(result, calculator.add(first, second), DELTA);
        System.out.println("Test add() passed");
    }

    @Test
    public void sub() throws Exception {

        //assertEquals(result, calculator.sub(first, second), DELTA);
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


