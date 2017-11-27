package com.cat.delta.pageobject;

import com.cat.delta.TestWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage extends Page {
    @FindBy(how = How.ID, using = "logout")
    public static WebElement logoutButton = null;

    @iOSFindBy(id = "DONE")
    public WebElement correctIconOnSplashScreen;

    public void clickOnCorrectIcon(){
        correctIconOnSplashScreen.click();
    }

    public HomePage(TestWebDriver testWebDriver) {
        super(testWebDriver);
    }




}
