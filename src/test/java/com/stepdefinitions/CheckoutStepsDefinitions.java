package com.stepdefinitions;

import com.utils.CommonMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class CheckoutStepsDefinitions extends CommonMethods {

    @When("user click the blue place order button without filling in any info")
    public void user_click_the_blue_place_order_button_without_filling_in_any_info() {
        waitForVisibility(checkOutPage.checkoutHeaderSign);
        jsClick(checkOutPage.placeOrderBtn);
    }

    @Then("verify error messages is displayed")
    public void verify_error_messages_is_displayed() {
        try {
            Assert.assertTrue(checkOutPage.redErrorMessageUnderEmail.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Error msg is not displayed under email field!!!!");
        }
    }

    @Then("user enter all shipping info")
    public void user_enter_all_shipping_info() {
        waitForVisibility(checkOutPage.userEmailAddressField);
        sendText(checkOutPage.userEmailAddressField, "someone@whocares.com");

        waitForVisibility(checkOutPage.userPhoneNumberField);
        sendText(checkOutPage.userPhoneNumberField, "5555555555");

        waitForVisibility(checkOutPage.userFirstNameField);
        sendText(checkOutPage.userFirstNameField, "Test");

        waitForVisibility(checkOutPage.userLastNameField);
        sendText(checkOutPage.userLastNameField, "Tester");

        waitForVisibility(checkOutPage.userStreetAddressField);
        sendText(checkOutPage.userStreetAddressField, "Comandante Izarduy 67");

        waitForVisibility(checkOutPage.userCityNameField);
        sendText(checkOutPage.userCityNameField, "Barcelona");

        waitForVisibility(checkOutPage.userCountryDD);
        selectDDValue(checkOutPage.userCountryDD, "Spain");

        waitForVisibility(checkOutPage.userZipCodeField);
        sendText(checkOutPage.userZipCodeField, "08940");

        waitForVisibility(checkOutPage.userStateDD);
        selectDDValue(checkOutPage.userStateDD, "Barcelona");

        System.out.println("Done with shipping info");
    }

    @Then("choose express shipping method and fill credit card info and click on place order btn")
    public void choose_express_shipping_method_and_fill_credit_card_info_and_click_on_place_order_btn() {
        waitForClickability(checkOutPage.expressShippingRB);
        jsClick(checkOutPage.expressShippingRB);

//        waitForVisibility(checkOutPage.creditCardRB);
//        long creditCardNumber = 4111111111111111L;
//        getJSExecutor().executeScript("arguments[0].placeholder='" + creditCardNumber + "';", checkOutPage.creditCardNumberField);
//
//        Thread.sleep(1000);
//        sendText(checkOutPage.creditCardExpField, "0824");
//        Thread.sleep(3000);
//        sendText(checkOutPage.creditCardSecurityNumberField, "111");

        waitForClickability(checkOutPage.placeOrderBtn);
        jsClick(checkOutPage.placeOrderBtn);
        System.out.println("Place order button clicked");
    }

    @Then("verify red alert sign wrong credit card info is displayed")
    public void verify_red_alert_sign_wrong_credit_card_info_is_displayed() {
        Assert.assertTrue(checkOutPage.creditCardRedAlertMessage.isDisplayed(), "Red alert msg is not displayed after placing order");
        System.out.println("Red Alert msg on Credit cart area came out");
    }
}