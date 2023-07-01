package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement selectProducts;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;


    @FindBy (xpath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']//label")
    List<WebElement> paymentType;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy (xpath = "//strong[contains(text(),'New order')]")
    WebElement actualText;

    public void chooseProduct(String product, String quantity){
        Select select = new Select(selectProducts);
        BrowserUtils.selectBy(selectProducts, product, "text");
        this.quantity.sendKeys(quantity);
    }

    public void customerAddress(String customerName, String city, String street, String state, String zip){
        this.customerName.sendKeys(customerName);
        this.city.sendKeys(city);
        this.street.sendKeys(street);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }
    public void paymentInfo(WebDriver driver, String visa, String cardNumber, String expireDate){
        for (WebElement payType: paymentType) {
            if (BrowserUtils.getText(payType).trim().toUpperCase().equals(visa.toUpperCase())) {
                BrowserUtils.clickWithJS(driver, payType);
            }
        }
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
        processButton.click();
    }

    public void validateMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(actualText));
    }

}
