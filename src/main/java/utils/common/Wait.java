package utils.common;

import utils.BaseTest;
import utils.config.properties.PropertyConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Wait extends BaseTest {

    static WebDriverWait wait;

    public static void forPageToLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(500);
            wait = new WebDriverWait(getDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Load Request to complete.");
        }
    }

    public static int getPageLoadTimeOut() {
        return Integer.parseInt(PropertyConfig.getPropertyValue("app", "timeOutInSec"));
    }

    public static int getPageLoadSleep() {
        return Integer.parseInt(PropertyConfig.getPropertyValue("app", "sleepInMillis"));
    }

    public static double getExtraWait(String waitPropValue) {
        return Double.parseDouble(PropertyConfig.getPropertyValue("wait", waitPropValue));
    }

    // Sleep thread X seconds. !!!Use of [sleep/thread] must be avoided!!!
    public static void sleep(double secs) {
        secs *= 1000;
        try {
            Thread.sleep(Math.round(secs));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    // WAIT for an Element
    public static void forElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), getPageLoadTimeOut(), getPageLoadSleep());
        if (element != null) {
            wait
                    .ignoring(StaleElementReferenceException.class)
                    .pollingEvery(2, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(element));
        } else {
            System.out.println("ERROR Element is NOT present.");
        }
    }
}
