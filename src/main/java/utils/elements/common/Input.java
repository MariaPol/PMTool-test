package utils.elements.common;

import utils.BaseTest;
import utils.common.Wait;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Input extends BaseTest {

    public Input() {
    }

    // Global handling of ENTRY FIELDS
    public void text(WebElement entryField, String entryData) {
        if (entryData != null && !entryData.isEmpty()) {
            Wait.forElement(entryField);
            entryField.clear();
            if (!entryData.equalsIgnoreCase("~")) {
                entryField.sendKeys(entryData);
            } else {
                System.out.println("Not possible to entry data.");
            }
        } else {
            System.out.println("The Input field is null or empty.");
        }
    }

    public static void clearInput(WebElement element) {
        Wait.forElement(element);
        element.clear();
    }

}
