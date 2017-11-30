package com.cat.delta.functional;

import com.cat.delta.ManageTest;
import com.cat.delta.common.FlightSearchDetails;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

import java.io.IOException;
import java.util.List;


public class DeltaSteps extends ManageTest {



    public DeltaSteps() throws IOException, InterruptedException {
        super();
    }

    @Before("@web")
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
        shopAndBookPage.selectOneWayTrip();
        shopAndBookPage.selectOriginCity(fs.getOrigin());
        shopAndBookPage.selectDestinationCity(fs.getDestination());
        shopAndBookPage.selectOneWayDate();
        shopAndBookPage.searchFlight();
    }

    @Given("^User accept splash screen$")
    public void user_accept_splash_screen() throws Throwable {
        homePage.clickOnCorrectIcon();
    }

    @Then("^User continue as a guest$")
    public void user_continue_as_a_guest() throws Throwable {
        loginPage.clickContinueAsGuest();
    }

    @Then("^User start booking$")
    public void user_start_booking() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


    @After("@web")
    public void afterDelta() throws IOException, InterruptedException {
        testWebDriver.quitDriver();
    }


}
