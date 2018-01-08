package com.lidiabazhenova;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.testng.AssertJUnit.assertEquals;

public class ParametrizedTestArrayListNG {
    @DataProvider
    public Iterator<Object[]> set_of_parameters() {
        return Arrays.asList(new Object[][]
                {
                        {new ArrayList<Double>(Arrays.asList(4.0, 2.0, 2.0))},
                        {new ArrayList<Double>(Arrays.asList(-5.0, -3.0, -2.0))},
                        {new ArrayList<Double>(Arrays.asList(2.5, 1.5, 1.0))},
                        {new ArrayList<Double>(Arrays.asList(99.1, 98.0, 1.1))},}).iterator();
    }

    private Calculator calculator;

    @BeforeMethod
    public void set() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "set_of_parameters")
    public void addParams(ArrayList<Double> values) {
        Double expected_result = values.get(0);
        Double pass_value1 = values.get(1);
        Double pass_value2 = values.get(2);
        assertEquals(expected_result, calculator.add(pass_value1, pass_value2));
    }
}
