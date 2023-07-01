package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#Email")
    WebElement login;

    @FindBy (css = "#Password")
    WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy (xpath = "//div[contains(text(),'Failed')]")
    WebElement ErrorMessage;

    public void loginFunction(String login, String password) throws InterruptedException {
        this.login.clear();
        this.password.clear();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        signInButton.click();
        Thread.sleep(2000);
    }

    public void validateMessage(String expectedErrorMess) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expectedErrorMess, ErrorMessage.getText());
    }

}
