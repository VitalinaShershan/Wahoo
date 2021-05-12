package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonMethods {

    @FindBy(xpath = "//h1[text() = 'Your Cart']")
    public WebElement youCartSign;

    @FindBy(xpath = "//*[@id='shopping-cart-table']/tbody[1]/tr[1]/td[2]/span/span/span")
    public WebElement firstItemUnitPriceField;

    @FindBy(xpath = "(//input[@class ='input-text qty'])[1]")
    public WebElement firstItemQuantityEnter;

    @FindBy(xpath = "//*[@id='shopping-cart-table']/tbody[1]/tr[1]/td[4]/span/span/span")
    public WebElement firstItemTotalPriceField;

    @FindBy(xpath = "//button[@class='action update']")
    public WebElement updateCartBtn;

    @FindBy(xpath = "//button[@class = 'action primary checkout']")
    public WebElement proceedToCheckoutBtn;


    public CartPage() {
        PageFactory.initElements(driver, this);
    }
}
