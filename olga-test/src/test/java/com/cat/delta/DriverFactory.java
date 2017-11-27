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
        if (readProjectProperty.getSpecificProjectProperty("mode").equals("web")) {
            return loadDriverForWeb(readProjectProperty);
        } else {
            return loadDriverForMobile(readProjectProperty);
        }
    }


    public WebDriver loadDriverForWeb(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        if (readProjectProperty.getSpecificProjectProperty("driver").equals("firefox")) {
            return createFirefoxDriver(enableJavascript);
        } else {
            return createChromeDriver(enableJavascript);
        }
    }


    public WebDriver loadDriverForMobile(ReadProjectProperty readProjectProperty) throws InterruptedException, IOException {
        DesiredCapabilities dc = new DesiredCapabilities();
        WebDriver driver = null;
        if (readProjectProperty.getSpecificProjectProperty("driver").equals("android")) {
            return null;
        } else if (readProjectProperty.getSpecificProjectProperty("driver").equals("ios")) {
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, readProjectProperty.getSpecificProjectProperty("osVersion"));
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, readProjectProperty.getSpecificProjectProperty("deviceName"));
            dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, readProjectProperty.getSpecificProjectProperty("timeout"));
            dc.setCapability("locationServicesAuthorized", true);
            dc.setCapability("autoAcceptAlerts", true);
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, readProjectProperty.getSpecificProjectProperty("driver"));
            dc.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
            dc.setCapability(MobileCapabilityType.APP, readProjectProperty.getSpecificProjectProperty("appPath"));
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
            ((AppiumDriver) driver).manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        }else{
            return null;
        }
    }


    private WebDriver createFirefoxDriver(boolean enableJavascript) throws IOException {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("signed.applets.codebase_principal_support", true);
        profile.setPreference("javascript.enabled", enableJavascript);
        profile.setEnableNativeEvents(true);
        return new FirefoxDriver(profile);
    }

    private WebDriver createChromeDriver(boolean enableJavascript) throws IOException {

        return null;
    }


}
