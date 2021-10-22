package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.signUp.SignUp;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Button;
import utils.elements.common.Input;
import utils.elements.common.Link;
import java.util.Properties;
import java.util.Random;

public class UserSettings extends BaseTest {

    @FindBy(id = "settings")
    @CacheLookup
    WebElement settingsBtn;
    @FindBy(id = "fullName")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "address")
    WebElement address;
    @FindBy(id = "update_info")
    WebElement submitBtn;

    private final static String NAME = "Name";
    private final static String EMAIL = "Email";
    private final static String PASSWORD = "Password";
    private final static String COMPANY = "Company";
    private final static String ADDRESS = "Address";

    private Input input = new Input();
    private Button button = new Button();
    private Random rand = new Random();
    private SignUp signUp = new SignUp();
    private Link link = new Link();

    public UserSettings() {
        initPageFactory();
    }

    public UserSettings log(String logText) {
        super.log(logText);
        return this;
    }

    public UserSettings navigateToSettings() {
        link.clickAction(settingsBtn);
        return this;
    }

    public UserSettings verifyUserSettings(Properties params) {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@value='" + params.getProperty(NAME) + "']")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@value='" + signUp.getRandEmailId() + params.getProperty(EMAIL) + "']")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@value='" + params.getProperty(COMPANY) + "']")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@value='" + params.getProperty(ADDRESS) + "']")));
        return this;
    }

    public UserSettings verifyValidationMandatoryFields() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='fullName']//following-sibling::*[contains(text(),'This field is required')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'This field is required')]")));
        return this;
    }

    public UserSettings verifyValidationEmailFormat() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'Invalid email format')]")));
        return this;
    }

    public UserSettings verifyValidationExistingEmail() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'Email `user@test.com` already exits')]")));
        return this;
    }

    public UserSettings editUserSetting(Properties params) {
        input.text(name, params.getProperty(NAME));
        signUp.setRandEmailId(rand.nextInt(1000));
        input.text(email, signUp.getRandEmailId() + params.getProperty(EMAIL));
        input.text(password, params.getProperty(PASSWORD));
        input.text(company, params.getProperty(COMPANY));
        input.text(address, params.getProperty(ADDRESS));

        Actions action = new Actions(getDriver());
        action.moveToElement(submitBtn);
        button.clickJS(submitBtn);
        return this;
    }

    public UserSettings settingValidationMessages(Properties params) {
        input.text(name, params.getProperty(NAME));
        input.text(email, params.getProperty(EMAIL));

        button.clickJS(submitBtn);
        return this;
    }

    public UserSettings clearFields() {
        input.clearInput(name);
        input.clearInput(email);
        input.clearInput(password);
        input.clearInput(company);
        input.clearInput(address);
        button.clickJS(submitBtn);
        return this;
    }

}
