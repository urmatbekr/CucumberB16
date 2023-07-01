package com.test.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/smartbear",   // feature location
        glue = "com/test/smartbear/stepdefinitions", //step definition files location
        dryRun = false,
        tags = "@outlineregression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class WebCreateRunner {
}

/*
  1-First Create your hook class and your @Before and @After annotation(io.cucumber)
  2-Read username,password,url from configuration.properties
  3-Start writing your test case in feature file
  4-Start creating your Page object model(pages,step definitions,runners)
  tips:You should have :LoginPage,MainPage,OrderPage,ViewOrderPage(validation part)
  tips:You should have :OrderCreationStepDef
  5-Create your runner class and get the all snips from Runner class(DryRun=True)
  6-Put the snips in step def class
  7-Start implementing your page classes(WebElements and Methods)
  8-Convert the logic of Scenario to Scenario Outline
  -->Check it for MyMoney,FamilyAlbum,ScreenSaver
  -->Check it for Visa,MasterCard,AmericanExpress
  TIPS:Validation part:You can do Arrays.asList logic we did before
  but start from 1 and end lenght-1.
 */
