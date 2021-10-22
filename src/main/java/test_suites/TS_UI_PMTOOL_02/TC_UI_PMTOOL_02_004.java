package test_suites.TS_UI_PMTOOL_02;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_02_004 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_02_004_Edit_Settings_Validation_Messages() {

        page.log("1. Open Web Application. PMTool home page opens")
                .homePage()
                .verifyHomePageOpens();
        page.log("2. Navigate to Login page and fill the form")
                .login().navigateToLogin()
                .login(getTestCaseData(1))
                .log("3. Verify that the login has been completed")
                .verifySuccessLogin();
        page.log("4. Navigate to settings page and clear all the field before submit")
                .userSettings().navigateToSettings()
                .clearFields()
                .verifyValidationMandatoryFields()
                .log("5. Enter a wrong format email and submit")
                .clearFields()
                .settingValidationMessages(getTestCaseData(2))
                .log("6. Verify that a validation message is displayed")
                .verifyValidationEmailFormat()
                .log("7. Enter an email of an existing user and submit")
                .clearFields()
                .settingValidationMessages(getTestCaseData(3))
                .log("8. Verify that a validation message is displayed")
                .verifyValidationExistingEmail();
    }
}
