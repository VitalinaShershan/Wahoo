package com.stepdefinitions;

import com.utils.CommonMethods;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class AdjustProductsInCartPage extends CommonMethods {

    @When("user click btn on view and edit cart at the side-bar")
    public void user_click_btn_on_view_and_edit_cart_at_the_side_bar() {
        waitForClickability(allProductsPage.showCartTopRightBtn);
        jsClick(allProductsPage.showCartTopRightBtn);

        waitForClickability(miniSideCartPage.viewAndEditCartBtn);
        jsClick(miniSideCartPage.viewAndEditCartBtn);

        waitForVisibility(cartPage.youCartSign);
        Assert.assertTrue(cartPage.youCartSign.isDisplayed(), "View and Edit Cart page is not displayed");

        System.out.println("View and Edit Cart is opened");
    }

    @When("cart page should be displayed user change the item quantity and click on update btn")
    public void cart_page_should_be_displayed_user_change_the_item_quantity_and_click_on_update_btn() {
        double totalPriceBeforeChange = Double.parseDouble(cartPage.firstItemTotalPriceField.getText().replace("$", "").replace("€", ""));
        double unitPrice = Double.parseDouble(cartPage.firstItemUnitPriceField.getText().replace("$", "").replace("€", ""));
        int quantity = Integer.parseInt(cartPage.firstItemQuantityEnter.getAttribute("value"));
        cartPage.firstItemQuantityEnter.clear();
        cartPage.firstItemQuantityEnter.sendKeys(String.valueOf(quantity + 1));
        click(cartPage.updateCartBtn);
        waitForClickability(cartPage.updateCartBtn);
        double totalPriceAfterChange = Double.parseDouble(cartPage.firstItemTotalPriceField.getText().replace("€", ""));
        Assert.assertEquals(totalPriceBeforeChange + unitPrice, totalPriceAfterChange, "Subtotal item price is not updated!!!!");
        System.out.println("Item quantity was increased by one and subtotal price was successfully updated");
    }

    @When("click the blue proceed to checkout button")
    public void click_the_blue_proceed_to_checkout_button() {
        click(cartPage.proceedToCheckoutBtn);
    }

    @Then("verify that checkout page is displayed")
    public void verify_that_checkout_page_is_displayed() {
        waitForVisibility(checkOutPage.checkoutHeaderSign);
        Assert.assertTrue(checkOutPage.checkoutHeaderSign.isDisplayed(), "Check out Page is not displayed!!!!");
    }
}
