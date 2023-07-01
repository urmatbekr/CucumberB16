package com.test.swaglabs.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SwaglabsOrderHook {

    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setup() {
        driver.get(ConfigReader.redProperty("QA_swaglabs_url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotForCucumber(driver, scenario);
        driver.quit();
    }
}


