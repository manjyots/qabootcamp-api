package com.cat.delta.driver;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadProjectProperty;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class DriverFactory {
    private String driverType;

    private boolean enableJavascript = true;
    ReadProjectProperty readProjectProperty = null;

    public WebDriver loadDriver(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        this.readProjectProperty = readProjectProperty;
        if (readProjectProperty.getSpecificProjectProperty("mode").equals("web")) {
            return loadDriverForWeb(readProjectProperty);
        } else {
            return loadDriverForMobile(readProjectProperty);
        }
    }

    public WebDriver loadDriverForMobile(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        DesiredCapabilities dc = new DesiredCapabilities();
        WebDriver driver = null;
        if (readProjectProperty.getSpecificProjectProperty("driver").equalsIgnoreCase("android")) {

            dc.setCapability(MobileCapabilityType.DEVICE_NAME, readProjectProperty.getSpecificProjectProperty("deviceName").trim());
            dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, readProjectProperty.getSpecificProjectProperty("timeout").trim());
            dc.setCapability(MobileCapabilityType.APP, readProjectProperty.getSpecificProjectProperty("appPath").trim());
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, readProjectProperty.getSpecificProjectProperty("app_package").trim());
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, readProjectProperty.getSpecificProjectProperty("app_activity").trim());
            dc.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
            dc.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
//            dc.setCapability("chromedriverExecutable","/Users/nikhiljain/Downloads/chromedriver");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

            return driver;
        } else if (readProjectProperty.getSpecificProjectProperty("driver").equalsIgnoreCase("ios")) {
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, readProjectProperty.getSpecificProjectProperty("osVersion").trim());
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, readProjectProperty.getSpecificProjectProperty("deviceName").trim());
            dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, readProjectProperty.getSpecificProjectProperty("timeout").trim());
            dc.setCapability("locationServicesAuthorized", true);
            dc.setCapability("autoAcceptAlerts", true);
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, readProjectProperty.getSpecificProjectProperty("driver").trim());
            dc.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
            dc.setCapability(MobileCapabilityType.APP, readProjectProperty.getSpecificProjectProperty("appPath").trim());
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
//            ((AppiumDriver) driver).manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        }else{
            return null;
        }
    }

    public WebDriver loadDriverForWeb(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
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
