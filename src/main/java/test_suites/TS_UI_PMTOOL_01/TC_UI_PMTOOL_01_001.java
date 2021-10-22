package test_suites.TS_UI_PMTOOL_01;

import utils.BaseTest;
import org.testng.annotations.Test;

public class TC_UI_PMTOOL_01_001 extends BaseTest {
    @Test
    public void TC_UI_PMTOOL_01_001_Log_In() {

        page.log("1. Open Web Application. PMTool home page opens")
                .homePage()
                .verifyHomePageOpens();
        page.log("2. Navigate to Login page and fill the form")
                .login().navigateToLogin()
                .login(getTestCaseData())
                .log("2. Verify that the login has been completed")
                .verifySuccessLogin();
    }
}
