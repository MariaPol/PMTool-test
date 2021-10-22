package pages.taskdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Properties;

public class SearchTask extends BaseTest {

    @FindBy(id = "search")
    WebElement search;

    private final static String SEARCH_TERM = "Search_term";

    public SearchTask() {
        initPageFactory();
    }

    public SearchTask log(String logText) {
        super.log(logText);
        return this;
    }

    public SearchTask searchForTask(Properties params) {

        Wait.getExtraWait("pageLoadExtraWait");
        search.clear();
        search.click();
        search.sendKeys(params.getProperty(SEARCH_TERM));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("items"))));

        List<WebElement> searchResults = getDriver().findElements(By.id("items"));

        for (WebElement searchResult : searchResults) {
            Assert.assertTrue(searchResult.getText().contains(params.getProperty(SEARCH_TERM)));
        }
        return this;
    }
}
