package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(TestWebDriver driver) {
        super(driver);
    }

    @FindBy(css="#logo")
    private WebElement logo;

    public boolean verifyLogoPresence(){
        return logo.isEnabled();
    }

}
