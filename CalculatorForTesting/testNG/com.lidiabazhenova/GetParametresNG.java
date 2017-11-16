package com.lidiabazhenova;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetParametresNG {
    @Parameters({"paramInt", "paramStr"})
    @Test
    public void tstSomeTest(int in, String st) {
        System.out.println(in + " = " + st);
    }
}
