package com.test.etsy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/esty/EtsySearch.feature",   // feature location
        glue = "com/test/etsy/stepDefinitions", //step definition files location
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class EtsyRunner {
}
