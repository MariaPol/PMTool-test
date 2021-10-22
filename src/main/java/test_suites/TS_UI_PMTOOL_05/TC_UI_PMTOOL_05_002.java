package test_suites.TS_UI_PMTOOL_05;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_05_002 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_05_002_Sort_Tasks() {

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
                .inputData(getTestCaseData(1))
                .log("5. Verify that the project has been created")
                .verifySuccessCreation(getTestCaseData(1));
        page.log("6. Create new task")
                .addTask()
                .createTask()
                .inputData(getTestCaseData(1))
                .log("7. Verify that the task has been created")
                .verifySuccessCreation(getTestCaseData(1));
        page.log("8. Navigate to dashboard page.")
                .addProject().navigateToDashboard()
                .log("9. Create new project")
                .createProject()
                .inputData(getTestCaseData(2))
                .log("10. Verify that the project has been created")
                .verifySuccessCreation(getTestCaseData(2));
        page.log("11. Create new task")
                .addTask()
                .createTask()
                .inputData(getTestCaseData(2))
                .log("12. Verify that the task has been created")
                .verifySuccessCreation(getTestCaseData(2));
        page.log("13. Create new task")
                .addProject().navigateToDashboard();
        page.addTask()
                .createTask()
                .inputData(getTestCaseData(3))
                .log("14. Verify that the task has been created")
                .verifySuccessCreation(getTestCaseData(3));
        page.log("15. Navigate to TaskDB page.")
                .viewAllTasks()
                .navigateToTaskDB();
        page.log("16. Sort the tasks in ascending order and check")
                .sortTasks()
                .sortBySummary()
                .verifySortingTask("Ascending")
                .log("17. Sort the tasks in descending order and check")
                .sortBySummary()
                .verifySortingTask("Descending");
    }
}
