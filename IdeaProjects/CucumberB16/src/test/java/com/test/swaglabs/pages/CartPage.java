package com.test.swaglabs.pages;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.DecimalFormat;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    @FindBy(css = "#first-name")
    WebElement firstname;

    @FindBy(css = "#last-name")
    WebElement lastname;

    @FindBy(css = "#postal-code")
    WebElement postalCode;

    @FindBy(css = "#continue")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement itemTitle;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement itemPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    WebElement totalAmount;

    @FindBy (css = "#finish")
    WebElement finishButton;

    @FindBy (xpath = "//h2[@class]")
    WebElement thankyouText;

    public void clickCheckoutButton() throws InterruptedException {
        checkoutButton.click();
        Thread.sleep(2000);
    }

    public void fillingCart(String firstname, String lastname, String postCode) throws InterruptedException {
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        postalCode.sendKeys(postCode);
        Thread.sleep(1000);
        continueButton.click();
    }
    public void validateCartInformation(String item, String price) throws InterruptedException {
        Assert.assertEquals(item, BrowserUtils.getText(itemTitle));
        Thread.sleep(1000);

        String[] priceAmount = BrowserUtils.getText(this.itemPrice).split(" ");
        Assert.assertEquals(Double.parseDouble(priceAmount[2].replace("$", "")), Double.parseDouble(price), 0.0);

        String[] taxAmount = BrowserUtils.getText(this.tax).split(" ");
        Double expectedTax = ((Double.parseDouble(priceAmount[2].replace("$", "")) * 0.08));
        Double expectedTaxAmount = Math.round(expectedTax * 100.00) / 100.00;
        Assert.assertEquals(Double.parseDouble(taxAmount[1].replace("$", "")), expectedTaxAmount, 0.0);

        String[] totalAmount = BrowserUtils.getText(this.totalAmount).split(" ");
        Double expectedTotal = ((expectedTaxAmount + (Double.parseDouble(priceAmount[2].replace("$", "")) )));
        Double expectedTotalAmount = Math.round(expectedTotal * 100.00) / 100.00;
        Assert.assertEquals(Double.parseDouble(totalAmount[1].replace("$", "")), expectedTotalAmount, 0.0);

        Thread.sleep(500);
    }

    ;public void validateThankYouText(String expectedText) throws InterruptedException {
        finishButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(expectedText, BrowserUtils.getText(thankyouText));
    }

}
