package com.test.swaglabs.stepdefinitions;

import com.test.swaglabs.pages.CartPage;
import com.test.swaglabs.pages.ItemPage;
import com.test.swaglabs.pages.LoginPage;
import com.test.swaglabs.pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.Map;

public class SwaglabsOrderingStep {
    WebDriver driver = DriverHelper.getDriver();

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    ItemPage itemPage = new ItemPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Given("User provides login and password and click login button")
    public void user_provides_login_and_password_and_click_login_button() throws InterruptedException {
        loginPage.loginFunction();
    }

    @When("User choose {string} and add into Cart")
    public void user_choose_and_add_into_cart(String item) throws InterruptedException {
        mainPage.chooseItem(item);
        Thread.sleep(2000);
        itemPage.addIntoCart(driver);

    }

    @When("User click Cart button and go to checkout")
    public void user_click_cart_button_and_go_to_checkout() throws InterruptedException {
        itemPage.viewCart();
        Thread.sleep(1000);
    }


    @When("User provides {string}, {string}, {string} and click continue button")
    public void user_provides_and_click_continue_button(String firstname, String lastname, String postCode) throws InterruptedException {
        cartPage.clickCheckoutButton();
        cartPage.fillingCart(firstname, lastname, postCode);
    }

    @Then("User validates the name of {string}, {string}, tax amount and total amount")
    public void user_validates_the_name_of_tax_amount_and_total_amount(String item, String price) throws InterruptedException {
        cartPage.validateCartInformation(item, price);
    }

    @Then("User clicks Finish Button, and validates message Thank you for your order message")
    public void user_clicks_finish_button_and_validates_message_thank_you_for_your_order_message() throws InterruptedException {
        cartPage.validateThankYouText("Thank you for your order!");
    }

    //----------------------------------------------------------------------------------------------------------------
// DataTable

    @When("User choose item and add into Cart")
    public void user_choose_item_and_add_into_cart(DataTable dataTable) throws InterruptedException {
        Map<String, String> itemInformation =dataTable.asMap();
        mainPage.chooseItem(itemInformation.get("item"));
        Thread.sleep(2000);
        itemPage.addIntoCart(driver);
    }

    @When("User provides firstname, lastname, postalCode and click continue button")
    public void user_provides_firstname_lastname_postal_code_and_click_continue_button(DataTable dataTable) throws InterruptedException {
        Map<String, String> providingCustomerInformation = dataTable.asMap();
        cartPage.clickCheckoutButton();
        cartPage.fillingCart(providingCustomerInformation.get("firstname"), providingCustomerInformation.get("lastname"), providingCustomerInformation.get("postalCode"));
    }


    @Then("User validates the name of item, price, tax amount and total amount")
    public void user_validates_the_name_of_item_price_tax_amount_and_total_amount(DataTable dataTable) throws InterruptedException {
        Map<String, String> customerInformation =dataTable.asMap();
        cartPage.validateCartInformation(customerInformation.get("item"), customerInformation.get("price"));

    }
}
