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
import utils.elements.common.Modal;
import java.util.Properties;

public class AddProject extends BaseTest {

    @FindBy(id = "dashboard")
    @CacheLookup
    WebElement dashboardBtn;
    @FindBy(xpath = "//*[contains(text(),'Create')]")
    WebElement createBtn;
    @FindBy(xpath = "(//*[@id=\"btn_update_project\"])[last()]")
    @CacheLookup
    WebElement editBtn;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "description")
    WebElement description;
    @FindBy(name = "action")
    WebElement submitBtn;

    private final static String NAME = "Name";
    private final static String DESCRIPTION = "Description";

    Link link = new Link();
    Input input = new Input();
    Button button = new Button();
    Modal modal = new Modal();

    public AddProject() {
        initPageFactory();
    }

    public AddProject log(String logText) {
        super.log(logText);
        return this;
    }

    public AddProject navigateToDashboard() {
        link.clickAction(dashboardBtn);
        return this;
    }
    public AddProject createProject() {
        link.click(createBtn);
        Wait.forPageToLoad();
        return this;
    }

    public AddProject editProject() {
        link.click(editBtn);
        Wait.forPageToLoad();
        return this;
    }

    public AddProject inputData(Properties params) {
        input.text(name, params.getProperty(NAME));
        input.text(description, params.getProperty(DESCRIPTION));
        submit();
        return this;
    }

    public AddProject submit() {
        button.clickAction(submitBtn);
        Wait.forPageToLoad();
        return this;
    }

    public AddProject verifySuccessCreation(Properties params) {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(NAME) + "')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(DESCRIPTION) + "')]")));
        return this;
    }

    public AddProject verifyFailedCreation() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='name']//following-sibling::*[contains(text(),'This field is required')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='description']//following-sibling::*[contains(text(),'This field is required')]")));
        return this;
    }

    public AddProject deleteProject() {
        getDriver().findElement(By.xpath("(//*[@id=\"delete_project\"])[last()]")).click();
        modal.confirmAlert();
        Wait.forPageToLoad();
        return this;
    }

    public AddProject verifySuccessDeletion(Properties params) {
        Wait.forPageToLoad();
        Assert.assertFalse(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(NAME) + "')]")));
        Assert.assertFalse(Verifications.isElementPresent(By.xpath("//*[contains(text(),'" + params.getProperty(DESCRIPTION) + "')]")));
        return this;
    }
}
