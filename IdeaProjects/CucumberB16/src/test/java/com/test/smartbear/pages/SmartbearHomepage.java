package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartbearHomepage {
    public SmartbearHomepage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[contains(text(),'Order')]")
    WebElement orderButton;

    public void clickOrderButton() throws InterruptedException {
        orderButton.click();
        Thread.sleep(2000);
    }

}
