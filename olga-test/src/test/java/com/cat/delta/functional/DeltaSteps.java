package com.cat.delta.functional;

import com.cat.delta.ManageTest;
import com.cat.delta.common.FlightSearchDetails;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;


public class DeltaSteps extends ManageTest {



    public DeltaSteps() throws IOException, InterruptedException {
        super();
    }

    @Before("@delta")
    public void beforeDelta() throws IOException, InterruptedException {
        testWebDriver.get(BASE_URL);
    }

    @Given("^User is on Web homepage$")
    public void user_is_on_Web_homepage() throws Throwable {
        Assert.assertTrue(homePage.verifyLogoPresence());
    }

    @Then("^User search for a flight$")
    public void user_search_for_a_flight(List<FlightSearchDetails> flightSearchDetails) throws Throwable {

        FlightSearchDetails fs = flightSearchDetails.get(0);
        testWebDriver.waitForPageToLoad();
        shopAndBookPage.selectOneWayTrip();
        shopAndBookPage.selectOriginCity(fs.getOrigin());
        shopAndBookPage.selectDestinationCity(fs.getDestination());
        shopAndBookPage.selectOneWayDate();
        shopAndBookPage.searchFlight();
    }

    @After("@delta")
    public void afterDelta() throws IOException, InterruptedException {
        testWebDriver.quitDriver();
    }


}
