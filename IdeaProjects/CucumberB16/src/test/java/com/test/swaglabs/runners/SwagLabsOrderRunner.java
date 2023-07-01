package com.test.swaglabs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/swaglabs",
        glue = "com/test/swaglabs/stepdefinitions",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)

public class SwagLabsOrderRunner {
}
