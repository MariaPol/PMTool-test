package test_suites.TS_UI_PMTOOL_04;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_04_005 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_04_005_Add_Task_Validation_Messages() {

        page.log("1. Open Web Application. PMTool home page opens")
                .homePage()
                .verifyHomePageOpens();
        page.log("2. Navigate to Login page and fill the form")
                .login().navigateToLogin()
                .login(getTestCaseData())
                .log("3. Verify that the login has been completed")
                .verifySuccessLogin();
        page.log("4. Create new project")
                .addProject()
                .createProject()
                .inputData(getTestCaseData())
                .log("5. Verify that the project has been created")
                .verifySuccessCreation(getTestCaseData());
        page.log("6. Create new task. Fill the form without the mandatory fields and submit ")
                .addTask()
                .createTask()
                .inputData(getTestCaseData(1))
                .log("7. Verify that a validation message is displayed")
                .verifyValidationMandatoryFields()
                .log("8. Enter only mandatory fields and submit")
                .clearFields()
                .inputData(getTestCaseData(2))
                .log("9. Verify that a validation message is displayed")
                .verifySuccessCreation(getTestCaseData());
    }
}
