package com.test.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#user-name")
    WebElement username;

    @FindBy (css = "#password")
    WebElement password;

    @FindBy (css = "#login-button")
    WebElement loginButton;

    public void loginFunction() throws InterruptedException {
        username.sendKeys(ConfigReader.redProperty("QA_swaglabs_username"));
        password.sendKeys(ConfigReader.redProperty("QA_swaglabs_password"));
        loginButton.click();
        Thread.sleep(500);
    }

}
