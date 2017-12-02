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
        testWebDriver.get(BASE_URL);
    }


    @Given("^I run delta test$")
    public void accessHomePage() {

        testWebDriver.waitForPageToLoad();
                testWebDriver.findElement(By.xpath("//input[@class='origin']")).click();
        testWebDriver.waitForPageToLoad();
        testWebDriver.findElement(By.id("predictive_airport_code")).sendKeys("ATL");
        testWebDriver.findElement(By.xpath("//a[contains(text(),'ATL')]")).click();

        Assert.assertEquals(testWebDriver.findElement(By.xpath("//input[@class='origin']")).getAttribute("value"), "ATL");

        testWebDriver.findElement(By.xpath("//input[@class='destination']")).click();
        testWebDriver.waitForPageToLoad();
        testWebDriver.findElement(By.id("predictive_airport_code")).sendKeys("Ohare");
        testWebDriver.findElement(By.xpath("//a[contains(text(),'Ohare')]")).click();

        Assert.assertEquals(testWebDriver.findElement(By.xpath("//input[@class='destination']")).getAttribute("value"), "ORD");


        testWebDriver.findElement(By.id("cal_icon_outbound_date")).click();
        testWebDriver.waitForPageToLoad();
        testWebDriver.findElement(By.xpath("//div[contains(text(),'11')]")).click();

        Assert.assertEquals(testWebDriver.findElement(By.id("outbound_date_input_0")).getAttribute("data-date-value"), "2017-12-11");

        testWebDriver.findElement(By.id("cal_icon_inbound_date")).click();
        testWebDriver.waitForPageToLoad();
        testWebDriver.findElement(By.xpath("//div[@id='inbound_date_input_datepicker']/div[@class='calendar']/div[@class='days']/div[@date='2017-12-30']")).click();


        testWebDriver.findElement(By.id("search")).click();
        testWebDriver.waitForPageToLoad();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    @After("@delta")
    public void afterDelta() throws IOException, InterruptedException {
        testWebDriver.quitDriver();
    }


}
