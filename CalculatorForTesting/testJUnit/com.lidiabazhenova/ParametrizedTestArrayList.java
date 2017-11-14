package com.lidiabazhenova;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParametrizedTestArrayList {
    private ArrayList<Double> values;
    Calculator calculator;

    @Parameterized.Parameters
    public static Collection<Object[]> set_of_parameters() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<Double>(Arrays.asList(4.0, 2.0, 2.0))},
                {new ArrayList<Double>(Arrays.asList(-5.0, -3.0, -2.0))},
                {new ArrayList<Double>(Arrays.asList(2.5, 1.5, 1.0))},
                {new ArrayList<Double>(Arrays.asList(99.1, 98.0, 1.1))},});
    }

    public ParametrizedTestArrayList(ArrayList<Double> values) {
        this.values = values;
    }

    @Before
    public void set() {
        calculator = new Calculator();
    }

    @Test
    public void addParams() {
        Double expected_result = values.get(0);
        Double pass_value1 = values.get(1);
        Double pass_value2 = values.get(2);
        assertEquals(expected_result, calculator.add(pass_value1, pass_value2), 0.0000001);
    }
}
