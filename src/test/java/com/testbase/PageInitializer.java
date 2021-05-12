package com.testbase;

import com.pages.*;

public class PageInitializer extends BaseClass {
    public static AllProductsPage allProductsPage;
    public static CheckoutPage checkOutPage;
    public static MainPage mainPage;
    public static MiniSideCartPage miniSideCartPage;
    public static CartPage cartPage;
    public static ProductPage productPage;

    public static void initializePageObjects() {
        allProductsPage = new AllProductsPage();
        checkOutPage = new CheckoutPage();
        mainPage = new MainPage();
        miniSideCartPage = new MiniSideCartPage();
        cartPage = new CartPage();
        productPage = new ProductPage();
    }
}