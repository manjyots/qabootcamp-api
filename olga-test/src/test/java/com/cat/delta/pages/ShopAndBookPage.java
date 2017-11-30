package com.cat.delta.pages;

import com.cat.delta.driver.TestWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopAndBookPage extends BasePage{

    public ShopAndBookPage(TestWebDriver driver) {
        super(driver);
    }

    @FindBy(css="#oneway_tab")
    private WebElement oneWayTrip;

    @FindBy(css=".origin")
    private WebElement originCity;

    @FindBy(css=".destination")
    private WebElement destinationCity;

    @iOSFindBy(xpath = "//XCUIElementTypeSearchField")
    @FindBy(css="#predictive_airport_code")
    private WebElement airportSearchBox;


    @iOSFindBy(xpath="//XCUIElementTypeCell[1]")
    @FindBy(css="#matched_predictive_airport_codes_list li:nth-child(1)")
    private WebElement airportSearchResultList;


    @iOSFindBy(id="ArrowRight")
    @FindBy(css=".next")
    private List<WebElement> nextArrowOnCalendar;


    @iOSFindBy(id="15")
    @FindBy(css=".days div:nth-child(17)")
    private WebElement oneWayTripDate;


    @iOSFindBy(id="ApplyActive")
    private WebElement selectDateIcon;

    @FindBy(css=".outbound_date_input")
    private WebElement oneWayDateSelection;

    @FindBy(css="#miles_toggle")
    private WebElement milesToggle;

    @FindBy(css="#search")
    private WebElement flightSearchButton;

    public void searchFlight(){
        flightSearchButton.click();
    }



    public void selectOriginCity(String originCityValue){
        originCity.click();
        switchContextToNativeView();

        airportSearchBox.sendKeys(originCityValue.trim());
        airportSearchResultList.click();
        switchContextToWebView();
    }

    public void selectDestinationCity(String destinationCityValue){
        destinationCity.click();
        switchContextToNativeView();
        airportSearchBox.sendKeys(destinationCityValue.trim());
        airportSearchResultList.click();
        switchContextToWebView();
    }

    public void selectOneWayDate(){
        oneWayDateSelection.click();
        switchContextToNativeView();
        if(nextArrowOnCalendar.size()==1){
            nextArrowOnCalendar.get(0).click();
        }
//		nextArrowOnCalendar.click();
        oneWayTripDate.click();
        if(TestWebDriver.getDriver() instanceof AppiumDriver){
            selectDateIcon.click();
        }
        switchContextToWebView();
    }

    public void selectMiles(){
        milesToggle.click();
    }
    public void selectOneWayTrip(){
        switchContextToWebView();

        if(oneWayTrip==null){
            System.out.println("*******FFffffffffffff*************************");
        }
        oneWayTrip.click();
    }
}
