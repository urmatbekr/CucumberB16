package com.test.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {
    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='inventory_item_name']")
    List<WebElement> items;

    public void chooseItem(String itemName) throws InterruptedException {
        for (WebElement product: items) {
            if (product.getText().toUpperCase().equals(itemName.toUpperCase())){
                product.click();
                Thread.sleep(300);
                break;
            }
        }
    }


}
