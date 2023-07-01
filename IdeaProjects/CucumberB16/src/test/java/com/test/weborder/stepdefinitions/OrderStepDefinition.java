package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.OrderDetailsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class OrderStepDefinition {
    WebDriver driver = DriverHelper.getDriver();

    OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

    @Then("User click group order label and click Next")
    public void user_click_group_order_label_and_click_next() throws InterruptedException {
        orderDetailsPage.clickOrderGroup();
    }

    @Then("User texts in note invitees {string} and provides InviteList {string} and {string}")
    public void user_texts_in_note_invitees_and_provides_invite_list_and(String message, String inviteEmail1, String inviteEmail2) {
        orderDetailsPage.textNotesToInvitees(message, inviteEmail1, inviteEmail2);
    }

    @Then("User chooses the delivery option {string} and validate address {string} and click button group order")
    public void user_chooses_the_delivery_option_and_validate_address_and_click_button_group_order(String chooseMyLocation, String expectedAddress) throws InterruptedException {
        orderDetailsPage.chooseMyLocation(driver, chooseMyLocation, expectedAddress);
    }

    @Then("User validates the header {string} and the description which starts {string}")
    public void user_validates_the_header_and_the_description_which_starts(String expectedHeader, String expectedParagraph) throws InterruptedException {
        orderDetailsPage.validateGroupViewText(expectedHeader, expectedParagraph);
    }
}
