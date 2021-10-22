package test_suites.TS_UI_PMTOOL_02;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_02_001 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_02_001_Sign_Up() {

        page.log("1. Open Web Application and navigate to Sign up page")
                .signUp().navigateToSignUp()
                .navigateToSignUp()
                .log("2. Fill the form and submit")
                .signUp(getTestCaseData())
                .log("3. Verify that the sign up has been completed")
                .verifySuccessSignUp();
        page.log("4. Login, navigate to settings page and check")
                .login().navigateToLogin()
                .login(getTestCaseData());
        page.userSettings().navigateToSettings()
                .verifyUserSettings(getTestCaseData());
    }
}
