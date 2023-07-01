package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class OrderDetailsPage {
    public OrderDetailsPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderLabel;

    @FindBy (css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy (css = "#InviteNote")
    WebElement noteToInvitees;

    @FindBy (css = "#InviteList")
    WebElement InviteList;

    @FindBy (xpath = "//select[@id='ConfirmAddressID']")
    WebElement myLocation;

    @FindBy (css = "#addressPreview")
    WebElement myAddress;

    @FindBy (css = "#createGroupOrder")
    WebElement createOrderButton;

    @FindBy (xpath = "//h1[@class='topBannerHeader']")
    WebElement viewGroupOrder;

    @FindBy (xpath = "//div[2]//p[1]")
    WebElement paragraph;

    public void clickOrderGroup() throws InterruptedException {
        Thread.sleep(2000);
        groupOrderLabel.click();
        nextButton.click();
    }

    public void textNotesToInvitees(String message, String inviteEmail1, String inviteEmail2){
        noteToInvitees.sendKeys(message);
        InviteList.sendKeys(inviteEmail1, ", " , inviteEmail2);
    }

    public void chooseMyLocation(WebDriver driver, String myLocation, String expectedAddress) throws InterruptedException {
        Select select = new Select(this.myLocation);
        BrowserUtils.scrollWithJS(driver, this.myLocation);
        select.selectByVisibleText(myLocation);
        Assert.assertTrue((BrowserUtils.getText(myAddress).trim()).contains(expectedAddress));
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver, createOrderButton);
        Thread.sleep(2000);
        createOrderButton.click();
    }

    public void validateGroupViewText(String expectedHeader, String expectedParagraph) throws InterruptedException {
      Thread.sleep(2000);
       Assert.assertEquals(expectedHeader, BrowserUtils.getText(viewGroupOrder));
        Assert.assertTrue(BrowserUtils.getText(paragraph).trim().contains(expectedParagraph));
    }


}
