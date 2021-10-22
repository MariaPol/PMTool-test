package pages.common;

import org.testng.Assert;
import utils.BaseTest;
import utils.common.Wait;

public class HomePage extends BaseTest {

    public HomePage() {
        initPageFactory();
    }

    public HomePage log(String logText) {
        super.log(logText);
        return this;
    }

    public HomePage verifyHomePageOpens() {
        Wait.forPageToLoad();
        Assert.assertEquals(getDriver().getTitle(), "PPM tool");
        return this;
    }
}
