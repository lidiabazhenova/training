package com.lidiabazhenova;

import org.junit.Test;

import static org.junit.Assert.fail;

public class FailTest {
    @Test
    public void tstAllAsserts() {
        fail();
        fail("Test failed!");
    }
}
