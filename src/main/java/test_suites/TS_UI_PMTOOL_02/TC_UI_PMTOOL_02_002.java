package test_suites.TS_UI_PMTOOL_02;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_02_002 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_02_002_Edit_Settings() {

        page.log("1. Open Web Application and navigate to Sign up page")
                .signUp()
                .navigateToSignUp()
                .log("2. Fill the form and submit")
                .signUp(getTestCaseData(1))
                .log("3. Verify that the sign up has been completed")
                .verifySuccessSignUp();
        page.log("4. Login with the created user")
                .login().navigateToLogin()
                .login(getTestCaseData(1));
        page.log("5. Navigate to settings page and check")
                .userSettings().navigateToSettings()
                .verifyUserSettings(getTestCaseData(1))
                .log("6. Edit user settings and check")
                .editUserSetting(getTestCaseData(2));
        page.userSettings().navigateToSettings()
                .verifyUserSettings(getTestCaseData(2));
        page.log("7. Logout and login with the new credentials")
                .login().logout()
                .navigateToLogin()
                .login(getTestCaseData(2));
    }
}
