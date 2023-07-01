package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
        driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
        googleMainPage.searchItem(searchItem);
    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) {
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));
    }

    @Then("User validates the result is then {int}")
    public void user_validates_the_result_is_then(Integer expectedResult) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(googleMainPage.resultFromSearch(expectedResult));
    }

    @Then("User validates it loads less than {int} sec")
    public void user_validates_it_loads_less_than_sec(Integer sec) throws InterruptedException {
        Assert.assertTrue(googleMainPage.resultFromSearchInSec(sec));
    }

}
