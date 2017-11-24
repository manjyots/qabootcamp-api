package com.cat.delta.pageobject;

import com.cat.delta.TestWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Page {

    @FindBy(how = How.ID, using = "non_data_ready_dealer_message")
    private static WebElement dataReadyMessage = null;


    public TestWebDriver testWebDriver;


    public Page(TestWebDriver driver) {
        this.testWebDriver = driver;
    }

}
