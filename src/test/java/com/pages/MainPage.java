package com.pages;

import com.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends CommonMethods {

    //DD TOP MAIN BAR
    @FindBy(xpath = "//*[@id= 'top_nav']/ul/li[1]/a")
    public WebElement shopBtn;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }
}
