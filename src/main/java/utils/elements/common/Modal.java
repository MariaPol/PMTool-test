package utils.elements.common;

import utils.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;

public class Modal extends BaseTest {

    private Alert alert;

    public Modal ()  {

    }

    public void confirmAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }
}
