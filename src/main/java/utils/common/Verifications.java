/**
 * Class for verifying WebElements and general page elements.
 * All check and compare functions must be added here.
 * <p>
 * Functions must be NO CONTENT DEPENDED
 */
package utils.common;
import utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Verifications extends BaseTest {

    public static boolean isElementPresent(By by) {
        try {
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            getDriver().findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void table(String label, String value) {
        Assert.assertTrue(
                isElementPresent(By.xpath("//*[contains(.,'"
                        + label + "')]/following::*[contains(.,'" + value + "')]")));
    }

    /**
     * Verify table heading title exists with specific order
     *
     * @param title
     * @param orderNumber
     */
    public static void verifyTHOrder(String tableId, String title, Integer orderNumber) {
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id='" + tableId + "']//th[" + orderNumber + "][contains(.,'" + title + "')]")).isDisplayed());
    }
}
