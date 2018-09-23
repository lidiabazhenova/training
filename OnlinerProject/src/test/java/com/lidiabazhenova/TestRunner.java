package com.lidiabazhenova;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false,
        glue = {"com.lidiabazhenova.test case1"},
        features = {"src/test/resources/features/TvCategory.feature"},
        plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" }
)
public class TestRunner {
}
