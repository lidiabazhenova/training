package com.lidiabazhenova;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParametrizedTest {
    private double pass_value1;
    private double pass_value2;
    private double expected_result;
    private Calculator ip;


    public ParametrizedTest(double expected_result,double pass_value1, double pass_value2) {
        this.pass_value1 = pass_value1;
        this.pass_value2 = pass_value2;
        this.expected_result = expected_result;
    }

    @Parameterized.Parameters
    public static Collection set_of_parameters() {
        return Arrays.asList(new Object[][]{{9, 3, 3}, {4, 2, 2}, {4, 4, 1}});
    }

    @Before
    public void setUpForParams() {
        ip = new Calculator();
    }

    @Test
    public void mulParams() throws Exception {
        assertEquals(expected_result, ip.mul(pass_value1, pass_value2), 0.0000001);
    }
}
