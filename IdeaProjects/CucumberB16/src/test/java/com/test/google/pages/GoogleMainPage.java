package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy (xpath = "//a//h3")
    List <WebElement>  allLinks;

    @FindBy (xpath = "//div[@id='result-stats']")
    WebElement result;

    @FindBy (xpath = "//nobr")
    WebElement resultSec;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linkCount(int expectedNumber){
        return allLinks.size()<expectedNumber;
    }

    public boolean resultFromSearch(int expectedResult) throws InterruptedException {
        Thread.sleep(2000);
        String[] result = BrowserUtils.getText(this.result).split(" ");
        return Integer.parseInt(result[1].replace(",",""))<expectedResult;
    }

    public boolean resultFromSearchInSec (double expectedResultSec) throws InterruptedException {
        Thread.sleep(1000);
        String[] resultSec = BrowserUtils.getText(this.resultSec).split(" ");
        return Double.parseDouble(resultSec[0].replace("(", ""))<expectedResultSec;
    }
}
