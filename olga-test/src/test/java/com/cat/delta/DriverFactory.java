package com.cat.delta;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ReadProjectProperty;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class DriverFactory {
    private String driverType;

    private boolean enableJavascript = true;
    ReadProjectProperty readProjectProperty = null;

    public WebDriver loadDriver(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        this.readProjectProperty = readProjectProperty;
            return loadDriverForWeb(readProjectProperty);
    }


    public WebDriver loadDriverForWeb(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
            return createFirefoxDriver();
    }




    private WebDriver createFirefoxDriver() throws IOException {

//        System.setProperty("webdriver.gecko.driver",new File("src/test/resources/geckodriver").getAbsolutePath());
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", false);
//        WebDriver driver = new FirefoxDriver(capabilities);
//        return driver;

        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");
        return  new FirefoxDriver();
    }



}
