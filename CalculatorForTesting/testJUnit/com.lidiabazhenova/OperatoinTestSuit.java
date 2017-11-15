package com.lidiabazhenova;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(NeedTest.class)
@Suite.SuiteClasses(value = {CalculatorTest.class, RunnerTest.class})

public class OperatoinTestSuit {
}
