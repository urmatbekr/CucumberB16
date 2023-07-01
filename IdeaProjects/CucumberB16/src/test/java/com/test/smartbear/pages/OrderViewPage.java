package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderViewPage {
    public OrderViewPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[contains(text(),'all orders')]")
    WebElement orderButton;

    @FindBy (xpath = "//td//tr")
    List <WebElement> orderList;

    public void goToViewOrder() throws InterruptedException {
        orderButton.click();
        Thread.sleep(2000);
    }

    public void validateOrderInfo(String customerName, String product, String quantity, String data,
                                  String city, String street, String state, String zip, String visa,
                                  String cardNumber, String expireDate){
        List <String> expectedListOrder = Arrays.asList(product,  quantity,  customerName,
                 city,  street,  state,  zip,  visa,
                 cardNumber,  expireDate);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        String currentDate= dtf.format(now);
        //to get current data

        for (int i =1; i<orderList.size()-1; i++){
            if (orderList.get(i).getText().matches(expectedListOrder.get(i))){
                Assert.assertEquals(expectedListOrder,orderList);
            }
        }
    }
}
