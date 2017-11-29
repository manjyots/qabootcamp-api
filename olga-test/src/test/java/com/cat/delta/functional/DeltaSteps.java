package com.cat.delta.functional;

import com.cat.delta.ManageTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import junit.framework.Assert;
import org.openqa.selenium.By;

import java.io.IOException;


public class DeltaSteps extends ManageTest {



    public DeltaSteps() throws IOException, InterruptedException {
        super();
    }

    @Before("@delta")
    public void beforeDelta() throws IOException, InterruptedException {
//        testWebDriver.get(BASE_URL);
    }


    @Given("^I run delta test$")
    public void accessHomePage() {

//        testWebDriver.waitForPageToLoad();
        homePage.clickOnCorrectIcon();
        shopAndBookHomePage.selectOneWayTrip();
        shopAndBookHomePage.selectDestinationCity("ATL");
        shopAndBookHomePage.selectOriginCity("LAX");
        shopAndBookHomePage.selectOneWayDate();
        shopAndBookHomePage.searchFlight();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//
//        testWebDriver.findElement(By.xpath("//input[@class='origin']")).click();
//        testWebDriver.waitForPageToLoad();
//        testWebDriver.findElement(By.id("predictive_airport_code")).sendKeys("DEL");
//        testWebDriver.findElement(By.xpath("//a[contains(text(),'DEL')]")).click();
//
//        Assert.assertEquals(testWebDriver.findElement(By.xpath("//input[@class='origin']")).getAttribute("value"), "DEL");
//
//        testWebDriver.findElement(By.xpath("//input[@class='destination']")).click();
//        testWebDriver.waitForPageToLoad();
//        testWebDriver.findElement(By.id("predictive_airport_code")).sendKeys("HYD");
//        testWebDriver.findElement(By.xpath("//a[contains(text(),'HYD')]")).click();
//
//        Assert.assertEquals(testWebDriver.findElement(By.xpath("//input[@class='destination']")).getAttribute("value"), "HYD");
//
//
//        testWebDriver.findElement(By.id("cal_icon_outbound_date")).click();
//        testWebDriver.waitForPageToLoad();
//        testWebDriver.findElement(By.xpath("//span[@class='righticon']")).click();
//        testWebDriver.waitForPageToLoad();
//        testWebDriver.findElement(By.xpath("//div[contains(text(),'11')]")).click();
//
//        Assert.assertEquals(testWebDriver.findElement(By.id("outbound_date_input_0")).getAttribute("data-date-value"), "2017-12-11");
//
//        testWebDriver.findElement(By.id("cal_icon_inbound_date")).click();
//        testWebDriver.waitForPageToLoad();
//        testWebDriver.findElement(By.xpath("//div[@id='inbound_date_input_datepicker']/div[@class='calendar']/div[@class='days']/div[@date='2017-12-30']")).click();
//
////        Assert.assertEquals(testWebDriver.findElement(By.id("inbound_date_input_0")).getAttribute("data-date-value"), "2017-12-12");
//
//
//        testWebDriver.findElement(By.id("search")).click();
//        testWebDriver.waitForPageToLoad();
//

    }

    @After("@delta")
    public void afterDelta() throws IOException, InterruptedException {
        testWebDriver.quitDriver();
    }


}
