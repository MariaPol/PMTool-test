package utils.elements.common;

import utils.BaseTest;
import utils.common.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseTest {

    public Button() {

    }

    // Global handling of CLICKING an element (including WAIT for its existence)
    public void click(WebElement element) {
        if (element != null) {
            Wait.forElement(element);
            element.click();
        } else {
            System.out.println("ERROR Element ID is NOT clickable.");
        }
        Wait.forPageToLoad();
    }

    public void clickAction(WebElement element) {
        if (element != null) {
            Wait.forElement(element);
            Actions action = new Actions(getDriver());
            action
                    .moveToElement(element)
                    .click(element)
                    .perform();
        } else {
            System.out.println("ERROR Element ID is NOT clickable.");
        }

        try {
            Wait.forPageToLoad();
        } catch (UnhandledAlertException f) {
            try {
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickJS(WebElement element) {
        if (element != null) {
            Wait.sleep(1);
            Wait.forElement(element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);

        } else {
            System.out.println("ERROR Element ID is NOT clickable.");
        }
        Wait.forPageToLoad();
    }

    public void doubleClickAction(WebElement element) {
        if (element != null) {
            Wait.forElement(element);
            Actions action = new Actions(getDriver());
            action
                    .moveToElement(element)
                    .doubleClick()
                    .build()
                    .perform();
        } else {
            System.out.println("ERROR Element ID is NOT clickable.");
        }
    }

}
