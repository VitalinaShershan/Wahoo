package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MiniSideCartPage extends CommonMethods {

    @FindBy(xpath = "//span[text() = 'Your Cart']")
    public WebElement youCartSign;

    @FindBy(xpath = "//a[@id = 'btn-minicart-close']")
    public WebElement cartCloseBtn;

    @FindBy(xpath = "//a[@class = 'action delete']")
    public List<WebElement> removeElementFromCartList;

    @FindBy(xpath = "//ol[@id = 'mini-cart']//li")
    public List<WebElement> miniCartItemsOrderedList;

    @FindBy(xpath = "//button[@class = 'checkout']")
    public WebElement checkoutBlueCartBtn;

    @FindBy(xpath = "//span[text() = 'View and Edit Cart']")
    public WebElement viewAndEditCartBtn;

    @FindBy(xpath = "//button[@class = 'action-primary action-accept']")
    public WebElement confirmationAlert;

    @FindBy(xpath = "//span[text() = 'Item was removed successfully']")
    public WebElement successfullyRemovedConfSign;


    public MiniSideCartPage() {
        PageFactory.initElements(driver, this);
    }
}
