package com.restAssured.frameworks.runnersuite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/serviceFeatures/"},
//        tags = {"@All"},
        plugin = {"pretty", "json:target/cucumber_reports/cucumber.json"},
        glue = {"com.restAssured.frameworks.stepDefinition"},
        monochrome = true,
        dryRun = false)

public class RunnerTest {
}
