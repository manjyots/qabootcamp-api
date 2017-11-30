package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(TestWebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(id="continue_as_guest_btn"),
            @FindBy(id = "CONTINUE AS A GUEST >")})
    public List<WebElement> lnkContinueAsGuest;

    public void clickContinueAsGuest(){
        if(lnkContinueAsGuest.size()==1){
            lnkContinueAsGuest.get(0).click();
        }
    }


}
