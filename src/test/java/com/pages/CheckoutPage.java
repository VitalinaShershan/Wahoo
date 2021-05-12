package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends CommonMethods {
    //HEADER SIGN
    @FindBy(xpath = "//*[@id='checkout']/div[1]")
    public WebElement checkoutHeaderSign;

    @FindBy(xpath = "//button[@class = 'action primary checkout amasty']")
    public WebElement placeOrderBtn;

    //SHIPPING ADDRESS FIELDS:
    @FindBy(xpath = "/html/body/div[6]/div[1]/main/div[2]/div/div[3]/div[4]/div[1]/div/li/div/div/form[1]/fieldset/div/div[1]/input")
    public WebElement userEmailAddressField;

    @FindBy(xpath = "(//input[@class = 'input-text'])[0]")
    public WebElement redErrorMessageUnderEmail;

    @FindBy(xpath = "(//input[@class = 'input-text'])[2]")
    public WebElement userFirstNameField;

    @FindBy(xpath = "(//input[@class = 'input-text'])[3]")
    public WebElement userLastNameField;

    @FindBy(xpath = "(//input[@class = 'input-text'])[5]")
    public WebElement userStreetAddressField;

    @FindBy(xpath = "(//input[@class = 'input-text'])[7]")
    public WebElement userCityNameField;

    @FindBy(xpath = "(//select[@class = 'select'])[1]")
    public WebElement userCountryDD;

    @FindBy(xpath = "(//select[@class = 'select'])[2]")
    public WebElement userStateDD;

    @FindBy(xpath = "(//input[@class = 'input-text'])[9]")
    public WebElement userZipCodeField;

    @FindBy(xpath = "(//input[@type = 'tel'])[1]")
    public WebElement userPhoneNumberField;

    //SHIPPING METHOD FIELDS:
    @FindBy(xpath = "//td[starts-with(text(),'Express Shipping')]")
    public WebElement expressShippingRB;

    //PAYMENT METHOD FIELDS:
    @FindBy(xpath = "//span[contains(text(),'Credit Card')]")
    public WebElement creditCardRB;

    //CREDIT CARD INFO:
    @FindBy(xpath = "//input[@class = 'InputElement is-empty Input Input--empty']")
    public List<WebElement> creditCardFieldsList;

    @FindBy(xpath = "//*[@id=\"root\"]/form/span[2]/div/div[2]/span/input")
    public WebElement creditCardNumberField;

    @FindBy(xpath = "//input[@placeholder = 'MM / YY']")
    public WebElement creditCardExpField;

    @FindBy(xpath = "//input[@placeholder = 'CVC']")
    public WebElement creditCardSecurityNumberField;

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div/div[1]/div[3]/div[7]/div/div")
    public WebElement creditCardRedAlertMessage;

    @FindBy(xpath = "//*[@id='paypal_express']")
    public WebElement payPallRB;


    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }
}
