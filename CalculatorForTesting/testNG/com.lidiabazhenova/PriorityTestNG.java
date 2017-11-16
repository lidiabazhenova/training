package com.lidiabazhenova;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriorityTestNG extends Assert {
    private boolean firstTestExecuted;
    Calculator calculator;

    @BeforeClass
    public void setUp() throws Exception {
        firstTestExecuted = false;
        calculator = new Calculator();
    }

    @Test(priority = 0)
    public void calculatorSetGet() throws Exception {
        firstTestExecuted = true;
        calculator.setResult("+", 7, 0);
        assertEquals(calculator.getResult(), 7, 0.0001);

    }

    @Test(priority = 1)
    public void deleteCalculator() {
        this.calculator = null;
        assertNull(calculator, "Calculator exists!!");
        assertTrue(firstTestExecuted);
    }
//если приоритет 0  поменять на 2 будет ошибка
}
