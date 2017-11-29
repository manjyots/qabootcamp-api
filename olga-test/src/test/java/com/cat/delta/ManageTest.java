package com.cat.delta;

import com.cat.delta.pageobject.HomePage;
import com.cat.delta.pageobject.ShopAndBookHomePage;
import utils.ReadProjectProperty;

import java.io.IOException;


public class ManageTest {

    private static DriverFactory driverFactory = new DriverFactory();
    protected static final String DEFAULT_BROWSER = "firefox";

    protected static TestWebDriver testWebDriver;
    public static String BASE_URL;
    ReadProjectProperty readProjectProperty = null;

public ShopAndBookHomePage shopAndBookHomePage =null;
public HomePage homePage = null;
    public ManageTest() throws IOException, InterruptedException {
         readProjectProperty = ReadProjectProperty.getInstance();
        BASE_URL = readProjectProperty.getSpecificProjectProperty("DELTA_URL");
        testWebDriver = new TestWebDriver(driverFactory.loadDriver(readProjectProperty));

        shopAndBookHomePage = new ShopAndBookHomePage(testWebDriver);
        homePage  = new HomePage(testWebDriver);

    }

    protected void loadDriver() throws InterruptedException, IOException {
        testWebDriver = new TestWebDriver(driverFactory.loadDriver(readProjectProperty));
    }




}
