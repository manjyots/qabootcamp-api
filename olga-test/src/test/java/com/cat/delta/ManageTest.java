package com.cat.delta;

import utils.ReadProjectProperty;

import java.io.IOException;


public class ManageTest {

    private static DriverFactory driverFactory = new DriverFactory();
    protected static final String DEFAULT_BROWSER = "firefox";

    protected static TestWebDriver testWebDriver;
    protected static TestWebDriver tempTestWebDriver;
    protected static TestWebDriver testWebAdminDriver;
    public static String BASE_URL;




    public ManageTest() throws IOException, InterruptedException {
        ReadProjectProperty readProjectProperty = ReadProjectProperty.getInstance();
        BASE_URL = readProjectProperty.getSpecificProjectProperty("DELTA_URL");

    }

    protected void loadDriver(String browser) throws InterruptedException, IOException {
        testWebDriver = new TestWebDriver(driverFactory.loadDriver(browser));
    }




}
