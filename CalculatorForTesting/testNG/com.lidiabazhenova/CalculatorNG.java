package com.lidiabazhenova;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorNG {

    @Test(enabled = false)
    public void tst() {
        Assert.fail();
        Assert.fail("Test failed!");
    }


    @Test
    public void tstAllAsserts() {
        Assert.assertEquals(2*2, 4, "Ok");
    }

}