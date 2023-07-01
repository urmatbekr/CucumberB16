package com.test.weborder.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import com.test.weborder.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDefinition {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("User provides login {string} and password {string} and click sign in button")
    public void user_provides_login_and_password_and_click_sign_in_button(String login, String password) throws InterruptedException {
        loginPage.loginFunction(login,
                password);
    }

    @Then("Validate title of website {string}")
    public void validate_title_of_website(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @Then("User validate error message {string}")
    public void user_validate_error_message(String expectedErrorMess) throws InterruptedException {
        Thread.sleep(1000);
        loginPage.validateMessage(expectedErrorMess);
    }

}
