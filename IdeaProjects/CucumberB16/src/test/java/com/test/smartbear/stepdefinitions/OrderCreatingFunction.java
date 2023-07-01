package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.LoginPage;
import com.test.smartbear.pages.OrderPage;
import com.test.smartbear.pages.OrderViewPage;
import com.test.smartbear.pages.SmartbearHomepage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class OrderCreatingFunction {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SmartbearHomepage smartbearHomepage = new SmartbearHomepage(driver);
    OrderPage orderPage = new OrderPage(driver);

    OrderViewPage orderViewPage = new OrderViewPage(driver);

    @When("User enters username and password and click login Button")
    public void user_enters_username_and_password_and_click_login_button() throws InterruptedException {
        loginPage.loginFunction();
    }
    @When("User navigates to Order section from Bar")
    public void user_navigates_to_order_section_from_bar() throws InterruptedException {
        smartbearHomepage.clickOrderButton();
    }

    @And("User chooses the {string} and fills the {string}")
    public void userChoosesTheProductAndFillsTheQuantity(String product, String quantity) {
        orderPage.chooseProduct(product, quantity);
    }

    @When("User fills {string}, {string}, {string}, {string} and {string}")
    public void user_fills_and(String customerName, String street, String city, String state, String zip) {
        orderPage.customerAddress(customerName, street, city, state, zip);
    }
    @When("User chooses the {string} and fills {string}, {string} and click Process Button")
    public void user_chooses_the_and_fills_and_click_process_button(String visa, String cardNumber, String expireDate) {
        orderPage.paymentInfo(driver, visa, cardNumber, expireDate);
    }
    @Then("User validates the given {string}")
    public void user_validates_the_given(String expectedText) throws InterruptedException {
        orderPage.validateMessage(expectedText);
        orderViewPage.goToViewOrder();
    }

    @Then("User validates the order info from View All Orders")
    public void user_validates_the_order_info_from_view_all_orders() {
        orderViewPage.validateOrderInfo( "Joh",  "MyMoney",  "3",  "06/25/2023",
                "NY", "Main",  "NY",  "10010",  "Visa",  "4200123120321",  "12/25");
    }
//----------------------------------------------------------------------------------------------------------------
// DataTable
    @Given("User provides username, password for SmartBear login")
    public void user_provides_username_password_for_smart_bear_login() throws InterruptedException {
        loginPage.loginFunction();
        smartbearHomepage.clickOrderButton();
    }
    @When("Clicks OrderButton and provides the product and quantity for product information")
    public void clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) {
        Map<String, String> productInformation =dataTable.asMap();
        //System.out.println(productInformation);
        orderPage.chooseProduct(productInformation.get("product"), productInformation.get("quantity"));
    }
    @When("User provides customerName, street, city, state, zipcode for address information")
    public void user_provides_customer_name_street_city_state_zipcode_for_address_information(DataTable dataTable) {
        Map<String, String> addressInformation = dataTable.asMap();
        orderPage.customerAddress(addressInformation.get("customerName"), addressInformation.get("street"), addressInformation.get("city"),
                addressInformation.get("state"), addressInformation.get("zipCode"));

    }
    @When("User provides cardType, CardNumber, expireDate for payment information")
    public void user_provides_card_type_card_number_expire_date_for_payment_information(DataTable dataTable) throws InterruptedException {
        Map<String, String> cardInformation = dataTable.asMap();
        orderPage.paymentInfo(driver, cardInformation.get("cardType"), cardInformation.get("cardNumber"), cardInformation.get("expireDate"));
        orderViewPage.goToViewOrder();
    }
    @When("User clicks process button and validate message")
    public void user_clicks_process_button_and_validate_message(DataTable dataTable) throws InterruptedException {
    List<String> message = dataTable.asList();
    Thread.sleep(2000);
    orderPage.validateMessage(message.get(0));
    }
}
