package com.urbanFindr.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/urbanFindr/features/",
        glue = {"com/urbanFindr/stepDefinitions"},
        plugin = {"pretty", "html:target/report/cucumber", "json:target/report/json/login.json",
                "unused:target/unused.log"},
        monochrome = true,
        strict = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}