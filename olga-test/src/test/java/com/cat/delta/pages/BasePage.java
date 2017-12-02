package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public TestWebDriver driver;

    public BasePage(TestWebDriver driver) {
        this.driver = driver;
        if(driver.getDriver() instanceof AppiumDriver){
            AppiumFieldDecorator appiumFieldDecorator = new AppiumFieldDecorator(driver.getDriver(),30, TimeUnit.SECONDS);
            PageFactory.initElements(appiumFieldDecorator, this);
        }else{
            PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
        }
    }

    public void switchContextToWebView() {

        if(driver.getDriver() instanceof AppiumDriver){
            int i=1;
            while(i<=5) {
                Set<String> contextNames = ((AppiumDriver)driver.getDriver()).getContextHandles();
                if (contextNames.size() > 1) {
                    ((AppiumDriver) driver.getDriver()).context((String) (contextNames.toArray())[contextNames.size()-1]);
                    break;
                } else {
                    try {
                        Thread.sleep(3000);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void switchContextToNativeView() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.getDriver() instanceof AppiumDriver) {
            System.out.println("NATIVE_APP");
            ((AppiumDriver) driver.getDriver()).context("NATIVE_APP");
        }
    }

}
