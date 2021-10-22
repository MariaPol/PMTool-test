package pages.taskdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Link;

import java.util.Properties;

public class ViewAllTasks extends BaseTest {

    @FindBy(id = "task_db")
    @CacheLookup
    WebElement taskdbBtn;

    private final static String SUMMARY = "Summary";

    private Link link = new Link();

    public ViewAllTasks() {
        initPageFactory();
    }

    public ViewAllTasks log(String logText) {
        super.log(logText);
        return this;
    }

    public ViewAllTasks navigateToTaskDB() {
        link.clickAction(taskdbBtn);
        return this;
    }

    public ViewAllTasks verifyAllTasksPresent(Properties params1, Properties params2, Properties params3) {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='items']//child::*[contains(text(),'" + params1.getProperty(SUMMARY) + "')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='items']//child::*[contains(text(),'" + params2.getProperty(SUMMARY) + "')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='items']//child::*[contains(text(),'" + params3.getProperty(SUMMARY) + "')]")));
        return this;
    }
}
