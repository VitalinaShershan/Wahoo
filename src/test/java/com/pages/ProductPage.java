package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends CommonMethods {

    @FindBy(xpath = "//*[@id='product-view-wrapper']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/img")
    public WebElement productPageMainPicture;

    @FindBy(xpath = "//button[@id = 'product-addtocart-button']")
    public WebElement productPageAddToCart;

    @FindBy(xpath = "//select[@id = 'attribute92']")
    public WebElement productPageSelectColor;

    @FindBy(xpath = "//*[@id='product_addtocart_form']/div[1]/div[5]/div/div/p/text()")
    public WebElement productPageOutOfStockMsg;

    @FindBy(xpath = "//*[@id='attribute310']")
    public WebElement productPageSelectPlugType;


    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
}
