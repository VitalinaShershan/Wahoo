package com.stepdefinitions;

import com.utils.CommonMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddProductsToCart extends CommonMethods {

    @When("user navigate to website and click on shop btn then all products should be displayed")
    public void user_navigate_to_website_and_click_on_shop_btn_then_all_products_should_be_displayed() {
        jsClick(mainPage.shopBtn);

        waitForVisibility(allProductsPage.allProductsSign);
        boolean isDisplayed = allProductsPage.allProductsSign.isDisplayed();
        Assert.assertTrue(isDisplayed, "All products table is not displayed!!!!!");
    }

    @When("user adding two random products to the cart and remove the last one")
    public void user_adding_two_random_products_to_the_cart_and_remove_the_last_one() {
        for (int i = 0; i < 2; i++) {
            boolean flag = true;
            while (flag) {
                int randomIndex = CommonMethods.selectRandom();
                try {
                    click(allProductsPage.allProductsList.get(randomIndex));
                } catch (Exception e) {
                    jsClick(mainPage.shopBtn);
                    jsClick(allProductsPage.allProductsList.get(randomIndex));
                }

                try {
                    boolean isAddToCartMsgDisplayed = productPage.productPageAddToCart.isDisplayed();
                    if (isAddToCartMsgDisplayed) {
                        try {
                            boolean isSelectColorDisplayed = productPage.productPageSelectColor.isEnabled();
                            if (isSelectColorDisplayed) {
                                CommonMethods.selectDDValue(productPage.productPageSelectColor, 1);
                                click(productPage.productPageAddToCart);
                                flag = false;
                                System.out.println("Added product with Color to cart");
                            }
                        } catch (Exception e2) {
                            click(productPage.productPageAddToCart);
                            flag = false;
                            System.out.println("Added product with No color to cart");
                        }
                    }
                } catch (Exception e) {
                    driver.navigate().back();
                    System.out.println("Item is not available going to choose an other one");
                }
            }

            waitForClickability(miniSideCartPage.checkoutBlueCartBtn);
            boolean isCartSignDisplayed = miniSideCartPage.checkoutBlueCartBtn.isDisplayed();
            Assert.assertTrue(isCartSignDisplayed, "The side-bar is not visible with added products!!!!");
            driver.navigate().back();
            System.out.println("Navigating back to choose an other product");
        }

        //remove second item from the cart by index
        jsClick(allProductsPage.showCartTopRightBtn);
        WebElement itemToRemove = miniSideCartPage.removeElementFromCartList.get(1);
        jsClick(itemToRemove);
        System.out.println("Remove item button clicked from pop-up");
    }

    @Then("confirm with the following pop-up that the item was removed")
    public void confirm_with_the_following_pop_up_that_the_item_was_removed() {
        waitForClickability(miniSideCartPage.confirmationAlert);
        Assert.assertTrue(miniSideCartPage.confirmationAlert.isDisplayed(), "Pop-up confirmation msg is not displayed!!!!");
        click(miniSideCartPage.confirmationAlert);
        waitForVisibility(miniSideCartPage.successfullyRemovedConfSign);
        Assert.assertTrue(miniSideCartPage.successfullyRemovedConfSign.isDisplayed(), "Pop-up remove product msg was confirmed but conf Sign is not displayed!!!!");
        click(miniSideCartPage.cartCloseBtn);
        System.out.println("Item successfully removed from cart");
    }
}