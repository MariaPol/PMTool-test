package pages.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Button;
import utils.elements.common.Input;
import utils.elements.common.Link;
import java.util.Random;
import java.util.Properties;

public class SignUp extends BaseTest {

    @FindBy(id = "signup")
    WebElement signUpBtn;
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
    @FindBy(name = "action")
    WebElement submitBtn;

    private final static String NAME = "Name";
    private final static String EMAIL = "Email";
    private final static String PASSWORD = "Password";
    private final static String COMPANY = "Company";
    private final static String ADDRESS = "Address";


    private static Integer randomId;
    private Random rand = new Random();
    private Link link = new Link();
    private Input input = new Input();
    private Button button = new Button();

    public SignUp() {
        initPageFactory();
    }

    public SignUp log(String logText) {
        super.log(logText);
        return this;
    }

    public SignUp navigateToSignUp() {
        link.clickAction(signUpBtn);
        return this;
    }

    public SignUp signUp(Properties params) {
        inputData(params);
        submit();
        return this;
    }

    private void inputData(Properties params) {
        input.text(name, params.getProperty(NAME));
        randomId = rand.nextInt(1000);
        setRandEmailId(randomId);
        input.text(email, getRandEmailId() + params.getProperty(EMAIL));
        input.text(password, params.getProperty(PASSWORD));
        input.text(company, params.getProperty(COMPANY));
        input.text(address, params.getProperty(ADDRESS));
    }

    public SignUp signUpValidationMessages(Properties params) {
        inputDataValidation(params);
        button.clickJS(submitBtn);
        return this;
    }

    private void inputDataValidation(Properties params) {
        input.text(name, params.getProperty(NAME));
        input.text(email, params.getProperty(EMAIL));
        input.text(password, params.getProperty(PASSWORD));
        input.text(company, params.getProperty(COMPANY));
        input.text(address, params.getProperty(ADDRESS));
    }

    public SignUp clearFields() {
        input.clearInput(name);
        input.clearInput(email);
        input.clearInput(password);
        input.clearInput(company);
        input.clearInput(address);
        return this;
    }

    private void submit() {
        Actions action = new Actions(getDriver());
        action.moveToElement(submitBtn);
        button.clickAction(submitBtn);
        Wait.forPageToLoad();
    }

    public SignUp verifySuccessSignUp() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[contains(text(),'Successfull registration, login to start using PPMTool')]")));
        return this;
    }

    public SignUp verifyValidationMandatoryFields() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='fullName']//following-sibling::*[contains(text(),'This field is required')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'This field is required')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='password']//following-sibling::*[contains(text(),'This field is required')]")));
        return this;
    }

    public SignUp verifyValidationEmailFormat() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'Invalid email format')]")));
        return this;
    }

    public SignUp verifyValidationExistingEmail() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'Email `user@test.com` already exits')]")));
        return this;
    }

    public Integer getRandEmailId() {
        return randomId;
    }

    public void setRandEmailId(int randomEmailId) {
        randomId = randomEmailId;
    }

}
