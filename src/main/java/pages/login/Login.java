package pages.login;

import org.openqa.selenium.By;
import pages.signUp.SignUp;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Button;
import utils.elements.common.Input;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.elements.common.Link;
import java.util.Properties;

public class Login extends BaseTest {

    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "logout")
    WebElement logoutBtn;
    @FindBy(name = "action")
    WebElement submitBtn;

    private final static String EMAIL = "Email";
    private final static String PASSWORD = "Password";

    private Input input = new Input();
    private Link link = new Link();
    private Button button = new Button();
    private SignUp signUp = new SignUp();

    public Login() {
        initPageFactory();
    }

    public Login log(String logText) {
        super.log(logText);
        return this;
    }

    public Login navigateToLogin() {
        link.clickAction(loginBtn);
        return this;
    }

    public Login login(Properties params) {
        inputData(params);
        submit();
        return this;
    }

    private void inputData(Properties params) {
        if (signUp.getRandEmailId() == null) {
            input.text(email, params.getProperty(EMAIL));
        } else {
            input.text(email, signUp.getRandEmailId() + params.getProperty(EMAIL));

        }
        input.text(password, params.getProperty(PASSWORD));
    }

    private void submit() {
        button.clickAction(submitBtn);
        Wait.forPageToLoad();
    }

    public Login verifySuccessLogin() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='logout']")));
        return this;
    }

    public Login verifyFailedLogin() {
        Wait.forPageToLoad();
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='email']//following-sibling::*[contains(text(),'Invalid login info')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@id='password']//following-sibling::*[contains(text(),'Invalid login info')]")));
        return this;
    }

    public Login logout() {
        link.clickAction(logoutBtn);
        return this;
    }
}
