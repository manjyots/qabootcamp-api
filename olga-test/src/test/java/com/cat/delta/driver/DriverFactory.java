package com.cat.delta.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadProjectProperty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    private String driverType;

    private boolean enableJavascript = true;
    ReadProjectProperty readProjectProperty = null;


    public WebDriver loadDriver(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        WebDriver driver = null;
        if (readProjectProperty.getSpecificProjectProperty("driver").equals("firefox")) {
            driver = createFirefoxDriver(enableJavascript);
        } else {
            driver =createChromeDriver(enableJavascript);
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(readProjectProperty.getSpecificProjectProperty("timeout").trim()), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createFirefoxDriver(boolean enableJavascript) throws IOException {

        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");

        return  new FirefoxDriver();
    }

    private WebDriver createChromeDriver(boolean enableJavascript) throws IOException {

        return null;
    }


}
