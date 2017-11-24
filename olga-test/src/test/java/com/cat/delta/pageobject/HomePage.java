package com.cat.delta.pageobject;

import com.cat.delta.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage extends Page {
    @FindBy(how = How.ID, using = "logout")
    public static WebElement logoutButton = null;


    public HomePage(TestWebDriver testWebDriver) {
        super(testWebDriver);
        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
    }




}
