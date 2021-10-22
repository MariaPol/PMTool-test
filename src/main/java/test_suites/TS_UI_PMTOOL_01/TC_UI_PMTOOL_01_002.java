package test_suites.TS_UI_PMTOOL_01;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TC_UI_PMTOOL_01_002 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_01_001_Log_In_Validation_Messages() {

        page.log("1. Open Web Application. PMTool home page opens")
                .homePage()
                .verifyHomePageOpens();
        page.log("2. Navigate to Login page and try to login as an inactive user")
                .login().navigateToLogin()
                .login(getTestCaseData(1))
                .log("3. Verify that a validation message is displayed")
                .verifyFailedLogin();
    }
}
