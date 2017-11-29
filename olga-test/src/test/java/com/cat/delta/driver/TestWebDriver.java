package com.cat.delta.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWebDriver {

    public static WebDriver driver;
    public static WebDriver adminDriver;
    public static WebDriver tempDriver;
    private static String BASE_URL;

    public static final int DEFAULT_WAIT_TIME = 60;

    public TestWebDriver(WebDriver driver) {
        TestWebDriver.driver = driver;
//        maximizeBrowser();
    }






    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public List<WebElement> findElementsNotPresent(By by) {
        setImplicitWait(0);
        return driver.findElements(by);
    }

    public void get(String url) {
        driver.get(url);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void getAdminUrl(String url) {
        adminDriver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public String getPageSource() {
        return driver.getPageSource();
    }

    public void setImplicitWait(int defaultTimeToWait) {
        driver.manage().timeouts().implicitlyWait(defaultTimeToWait, TimeUnit.SECONDS);
    }

    public boolean elementNotFound(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void quitDriver() {
        driver.quit();
    }



    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }




    public void waitForPageToLoad() {
        (new WebDriverWait(driver, DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            }
        });

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        final List<WebElement> loaderIcons = driver.findElements(By.cssSelector("div.progress-dialog.component.notthere"));
        driver.manage().timeouts().implicitlyWait(TestWebDriver.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);

        if (loaderIcons.size() != 0) {
            try {
                new WebDriverWait(driver, DEFAULT_WAIT_TIME * 2).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return (!driver.findElement(By.cssSelector("div.progress-dialog.component.notthere")).isDisplayed());
                    }
                });
            } catch (NoSuchElementException ignored) {
            }
        }

    }







    public String getText(WebElement element) {
        return element.getText();
    }



    public void sleep(long timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(final WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }



    public boolean isDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }



    public void closeWindow() {
        driver.close();
    }





}

