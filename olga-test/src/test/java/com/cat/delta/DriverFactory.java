package com.cat.delta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.ReadProjectProperty;

import java.io.IOException;

import static java.lang.System.getProperty;

public class DriverFactory {
    private String driverType;

    private boolean enableJavascript = true;

    public WebDriver loadDriver(String browser) throws InterruptedException, IOException {

        return loadDriver(enableJavascript, browser);
    }

    public WebDriver loadDriver(boolean enableJavascript, String browser) throws InterruptedException, IOException {
            driverType = getProperty("web.driver", "Firefox");
            return createFirefoxDriver(enableJavascript);
    }



    private WebDriver createFirefoxDriver(boolean enableJavascript) throws IOException {
        ReadProjectProperty readProjectProperty = ReadProjectProperty.getInstance();
        String BASE_URL = readProjectProperty.getSpecificProjectProperty("DELTA_URL");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("signed.applets.codebase_principal_support", true);
        profile.setPreference("javascript.enabled", enableJavascript);
        profile.setEnableNativeEvents(true);
        return new FirefoxDriver(profile);
    }


}
