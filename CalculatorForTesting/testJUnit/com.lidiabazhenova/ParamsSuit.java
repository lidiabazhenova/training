package com.lidiabazhenova;

import com.lidiabazhenova.ParametrizedTest;
import com.lidiabazhenova.ParametrizedTestArrayList;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {ParametrizedTest.class, ParametrizedTestArrayList.class})

public class ParamsSuit {
}
