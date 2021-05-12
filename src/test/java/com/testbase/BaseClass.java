package com.testbase;

import com.utils.ConfigsReader;
import com.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    public static void setUp() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                String headless = ConfigsReader.getPropertyValue("headless");
                if (headless.equals("true")) {
                    chromeOptions.setHeadless(true);
                    driver = new ChromeDriver(chromeOptions);
                } else {
                    driver = new ChromeDriver(chromeOptions);
                }
                break;
            default:
                throw new RuntimeException("Invalid Browser");
        }
        driver.manage().window().maximize();
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        PageInitializer.initializePageObjects();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}