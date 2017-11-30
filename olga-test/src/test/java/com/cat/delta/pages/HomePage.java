package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(TestWebDriver driver) {
        super(driver);
    }

    @FindBy(css="#logo")
    private WebElement logo;

    @iOSFindBy(accessibility = "DONE")
    public WebElement correctIconOnSplashScreen;

    public void clickOnCorrectIcon(){
        correctIconOnSplashScreen.click();
    }

    public boolean verifyLogoPresence(){
        return logo.isEnabled();
    }

}
