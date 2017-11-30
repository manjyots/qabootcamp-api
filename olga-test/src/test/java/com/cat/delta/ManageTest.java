package com.cat.delta;

import com.cat.delta.driver.DriverFactory;
import com.cat.delta.driver.TestWebDriver;
import com.cat.delta.pages.HomePage;
import com.cat.delta.pages.LoginPage;
import com.cat.delta.pages.ShopAndBookPage;
import utils.ReadProjectProperty;

import java.io.IOException;


public class ManageTest {

    private static DriverFactory driverFactory = new DriverFactory();
    protected static final String DEFAULT_BROWSER = "firefox";

    protected static TestWebDriver testWebDriver;
    public static String BASE_URL;
    ReadProjectProperty readProjectProperty = null;

    protected HomePage homePage = null;
    protected ShopAndBookPage shopAndBookPage = null;
    protected LoginPage loginPage = null;

    public ManageTest() throws IOException, InterruptedException {

        readProjectProperty = ReadProjectProperty.getInstance();
        BASE_URL = readProjectProperty.getSpecificProjectProperty("DELTA_URL");
        testWebDriver = new TestWebDriver(driverFactory.loadDriver(readProjectProperty));
        homePage = new HomePage(testWebDriver);
        shopAndBookPage = new ShopAndBookPage(testWebDriver);
        loginPage = new LoginPage(testWebDriver);

    }


}
