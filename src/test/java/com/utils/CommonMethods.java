package com.utils;

import com.testbase.PageInitializer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonMethods extends PageInitializer {

    /**
     * this method will clear a textbox and send text to it
     *
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this method will return an object of Explicit wait with time set to 20 sec
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * this method will wait until given element becomes clickable
     *
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait until given element becomes visible
     *
     * @param element
     */
    public static void waitForVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * this method will wait until and then click
     *
     * @return
     */
    public static String click(WebElement element) {
        waitForClickability(element);
        element.click();
        return null;
    }

    /**
     * this method will return an Object of JavascriptExecutor
     *
     * @return JavascriptExecutor
     */
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * this method will click using JavascriptExecutor
     *
     * @param element
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * This method will if list of Web Elements contains str
     *
     * @param list
     * @param str
     * @return
     */
    public static boolean checkIfListOfWebElementsContain(List<WebElement> list, String str) {
        boolean ifContain = true;
        for (WebElement element :
                list) {
            ifContain = element.getText().toLowerCase().contains(str);
            if (ifContain) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method generates random number form 1 to 10
     *
     * @return
     */
    public static int selectRandom() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int random = 0;

        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * range) + min;
        }
        return random;
    }

    /**
     * this method will select a value from a given dropDown by the given index
     *
     * @param dd
     * @param index
     */
    public static void selectDDValue(WebElement dd, int index) {
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            int ddSize = options.size();

            if (ddSize > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will select a value from a given dropDown by the given visible text
     *
     * @param dd
     * @param visibleText
     */
    public static void selectDDValue(WebElement dd, String visibleText) {
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                if (option.getText().trim().equals(visibleText)) {
                    select.selectByVisibleText(visibleText);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will click on a radio button or a checkbox by the given list of elements and the value
     *
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
        for (WebElement radioOrCheckBox : radioOrCheckBoxes) {
            String actualValue = radioOrCheckBox.getAttribute("value").trim();
            if (radioOrCheckBox.isEnabled() && actualValue.equals(value)) {
                click(radioOrCheckBox);
                break;
            }
        }
    }
}