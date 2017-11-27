package com.cat.delta.pageobject;

import com.cat.delta.TestWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Set;

public class Page {



    public TestWebDriver driver;


    public Page(TestWebDriver driver) {
        this.driver = driver;

        if(driver.getDriver() instanceof AppiumDriver){
            AppiumFieldDecorator afd = new AppiumFieldDecorator(driver.getDriver());
            PageFactory.initElements(afd, this);
        }else{
            System.out.println("********************************");
            PageFactory.initElements(TestWebDriver.getDriver(), this);
        }
    }

    public void switchContextToNativeView() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (TestWebDriver.getDriver() instanceof AppiumDriver) {
            System.out.println("NATIVE_APP");
            ((AppiumDriver) TestWebDriver.getDriver()).context("NATIVE_APP");
        }
    }


    public void switchContextToWebView() {

        if(TestWebDriver.getDriver() instanceof AppiumDriver){
            int i=1;
            while(i<=5) {
                Set<String> contextNames = ((AppiumDriver)TestWebDriver.getDriver()).getContextHandles();
                if (contextNames.size() > 1) {
                    ((AppiumDriver) TestWebDriver.getDriver()).context((String) (contextNames.toArray())[contextNames.size()-1]);
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
}
