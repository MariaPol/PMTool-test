package test_suites.TS_UI_PMTOOL_04;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_04_001 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_04_001_Add_Task() {

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
        page.log("6. Create new task")
                .addTask()
                .createTask()
                .inputData(getTestCaseData())
                .log("7. Verify that the task has been created")
                .verifySuccessCreation(getTestCaseData());
    }
}
