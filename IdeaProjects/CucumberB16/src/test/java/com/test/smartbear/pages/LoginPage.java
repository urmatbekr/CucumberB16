package com.test.smartbear.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#ctl00_MainContent_username")
    WebElement username;

    @FindBy (css = "#ctl00_MainContent_password")
    WebElement password;

    public void loginFunction() throws InterruptedException {
        username.sendKeys(ConfigReader.redProperty("QA_websmartbear_username"));
        password.sendKeys(ConfigReader.redProperty("QA_websmartbear_password"), Keys.ENTER);
        Thread.sleep(1000);
    }
}
