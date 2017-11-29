package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {

    public TestWebDriver testWebDriver;

    public BasePage(TestWebDriver driver) {
        this.testWebDriver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
    }


}
