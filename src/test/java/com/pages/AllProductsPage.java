package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsPage extends CommonMethods {
//qqq
    @FindBy(xpath = "//h2[text() = 'All Products']")
    public WebElement allProductsSign;

    @FindBy(xpath = "//a[@class = 'skip-link skip-cart action showcart']")
    public WebElement showCartTopRightBtn;

    @FindBy(xpath = "//a[@class = 'product-image']")
    public List<WebElement> allProductsList;


    public AllProductsPage() {
        PageFactory.initElements(driver, this);
    }
}
