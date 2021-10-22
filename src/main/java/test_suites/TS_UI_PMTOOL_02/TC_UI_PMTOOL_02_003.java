package test_suites.TS_UI_PMTOOL_02;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_02_003 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_02_003_Sign_Up_Mandatory_Fields() {

        page.log("1. Open Web Application and navigate to Sign up page")
                .signUp().navigateToSignUp()
                .navigateToSignUp()
                .log("2. Fill the form without the mandatory fields and submit")
                .signUpValidationMessages(getTestCaseData(1))
                .log("Verify that a validation message is displayed")
                .verifyValidationMandatoryFields()
                .log("3. Enter a wrong format email and submit")
                .clearFields()
                .signUpValidationMessages(getTestCaseData(2))
                .log("Verify that a validation message is displayed")
                .verifyValidationEmailFormat()
                .log("4. Enter an email of an existing user and submit")
                .clearFields()
                .signUpValidationMessages(getTestCaseData(3))
                .log("Verify that a validation message is displayed")
                .verifyValidationExistingEmail()
                .log("5. Enter only mandatory fields and submit")
                .clearFields()
                .signUp(getTestCaseData(4))
                .log("6. Verify that the sign up has been completed")
                .verifySuccessSignUp();
    }
}
