package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Button;
import utils.elements.common.Input;
import utils.elements.common.Link;
import utils.elements.common.Select;
import java.util.Properties;
import static utils.config.resources.TestDataConfig.getInputDir;

public class AddTask extends BaseTest {

    @FindBy(xpath = "(//*[@id=\"btn_add_task\"])[last()]")
    WebElement createBtn;
    @FindBy(xpath = "(//*[@id=\"btn_update_task\"])[last()]")
    @CacheLookup
    WebElement editBtn;
    @FindBy(id = "summary")
    WebElement summary;
    @FindBy(id = "description")
    WebElement description;
    @FindBy(xpath = "//*[contains(@class, 'select-wrapper')]")
    WebElement status;
    @FindBy(id = "search_input")
    WebElement labels;
    @FindBy(id = "attachments")
    WebElement attachments;
    @FindBy(name = "action")
    WebElement submitBtn;

    private final static String SUMMARY = "Summary";
    private final static String DESCRIPTION = "Description_task";
    private final static String STATUS = "Status";
    private final static String LABELS = "Labels";

    Link link = new Link();
    Input input = new Input();
    Button button = new Button();
    Select select = new Select();

    public AddTask() {
        initPageFactory();
    }

    public AddTask log(String logText) {
        super.log(logText);
        return this;
    }

    public AddTask createTask() {
        link.click(createBtn);
        Wait.forPageToLoad();
        return this;
    }

    public AddTask editTask() {
        link.click(editBtn);
        Wait.forPageToLoad();
        return this;
    }

    public AddTask inputData(Properties params) {
        input.text(summary, params.getProperty(SUMMARY));
        input.text(description, params.getProperty(DESCRIPTION));
        select.simpleSelect(status, params.getProperty(STATUS));
        select.simpleSelect(labels, params.getProperty(LABELS));
        attachFile();
        submit();
        return this;
    }

    public AddTask clearFields() {
        input.clearInput(summary);
        input.clearInput(description);
        return this;
    }

    private void attachFile() {
        String filepath = getInputDir() + "/Assignment.pdf";
        attachments.sendKeys(filepath.replace("/", "\\"));
    }

    private void submit() {
        button.clickJS(submitBtn);
        Wait.forPageToLoad();
    }

    public AddTask verifySuccessCreation(Properties params) {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(SUMMARY) + "')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(DESCRIPTION) + "')]")));
        return this;
    }

    public AddTask verifyValidationMandatoryFields() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='summary']//following-sibling::*[contains(text(),'This field is required')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='description']//following-sibling::*[contains(text(),'This field is required')]")));
        return this;
    }

    public AddTask deleteTask() {
        getDriver().findElement(By.xpath("(//*[@id=\"btn_delete_task\"])[last()]")).click();
        getDriver().switchTo().alert().accept();
        Wait.forPageToLoad();
        return this;
    }

    public AddTask verifySuccessDeletion(Properties params) {
        Wait.forPageToLoad();
        Assert.assertFalse(Verifications.isElementPresent(By.xpath("//*[@id=\"items\"]//child::*[contains(text()," + params.getProperty(SUMMARY) + "')]")));
        Assert.assertFalse(Verifications.isElementPresent(By.xpath("//*[@id=\"items\"]//child::*[contains(text()," + params.getProperty(DESCRIPTION) + "')]")));
        return this;
    }

}
