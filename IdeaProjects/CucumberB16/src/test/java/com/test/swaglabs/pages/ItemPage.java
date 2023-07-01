package com.test.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ItemPage {
    public ItemPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    WebElement addCartButton;

    @FindBy (css = "#shopping_cart_container")
    WebElement cartButton;

    public void addIntoCart(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, addCartButton);
    }

    public void viewCart() throws InterruptedException {
        cartButton.click();
        Thread.sleep(2000);
    }
}
