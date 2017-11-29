package com.cat.delta;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadProjectProperty;

import java.io.IOException;


public class DriverFactory {
    private String driverType;

    private boolean enableJavascript = true;
    ReadProjectProperty readProjectProperty = null;


    public WebDriver loadDriver(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        if (readProjectProperty.getSpecificProjectProperty("driver").equals("firefox")) {
            return createFirefoxDriver(enableJavascript);
        } else {
            return createChromeDriver(enableJavascript);
        }
    }

    private WebDriver createFirefoxDriver(boolean enableJavascript) throws IOException {

        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");

        return  new FirefoxDriver();
    }

    private WebDriver createChromeDriver(boolean enableJavascript) throws IOException {

        return null;
    }


}
