package utils;

import utils.browsers.Chrome;
import utils.browsers.Firefox;
import utils.common.Wait;
import utils.config.properties.PropertyConfig;
import utils.config.resources.ResourcesConfig;
import utils.config.resources.TestDataConfig;
import utils.ext.Cmd;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import static utils.config.properties.PropertyConfig.getBrowser;
import static utils.config.resources.TestDataConfig.getTestData;

public abstract class BaseTest {

    public static WebDriver driver;

    public static Page page;

    @BeforeTest
    public void startBrowser() {

        driver = getWebDriver(getBrowser());

        driver.manage().window().maximize();
        page = new Page();

        driver.get(PropertyConfig.getURL());

        Wait.forPageToLoad();
    }

    public Page getPage() {
        return page;
    }

    @AfterTest
    public void quitBrowser() {
        if (!PropertyConfig.getDebugMode().equalsIgnoreCase("1")) {
            driver.quit();
            killDrivers();
        }
    }

    @AfterMethod(alwaysRun = true)

    public void catchExceptions(ITestResult result) {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        String className = this.getClassName();

        String methodName = result.getMethod().getMethodName();


        if (!result.isSuccess()) {

            if (ITestResult.FAILURE == Reporter.getCurrentTestResult().getStatus()) {

                Reporter.log("<p>&nbsp;</p>");

                Reporter.log("<p><font size=\"2\" face=\"Arial\">&nbsp;Result: </font><font size=\"2\" face=\"Arial\" color=\"red\"><b>FAIL</b></font></p>");


            } else if (ITestResult.SKIP == Reporter.getCurrentTestResult().getStatus()) {

                Reporter.log("<p>&nbsp;</p>");

                Reporter.log("<p><font size=\"2\" face=\"Arial\">&nbsp;Result: </font><font size=\"2\" face=\"Arial\" color=\"orange\"><b>SKIP</b></font></p>");


            }

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {

                System.setProperty("org.uncommons.reportng.escape-output", "false");


                String failureScreenshotsPath = ResourcesConfig.getTargetPath() + "/reports/failure_screenshots/";

                failureScreenshotsPath.replace('\\', '/');

                String failureImageFileName = className + "_" + formater.format(calendar.getTime()) + ".png";

                FileUtils.copyFile(scrFile, new File((failureScreenshotsPath + failureImageFileName)));

                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


                String relativeScreenshotPath = "../../failure_screenshots/";

                Reporter.log("<p align=\"left\"><font size=\"2\" face=\"Arial\" color=\"blue\"><b>&nbsp;<a href=\"" + relativeScreenshotPath + failureImageFileName + "\">Error screenshot at " + new Date() + "</b></font></p>");

                Reporter.log("<p>&nbsp;<img width=\"300\" src=\"" + relativeScreenshotPath + failureImageFileName + "\" alt=\"screenshot at " + new Date() + "\"/></p></a><br />");


                Reporter.log("<p>&nbsp;</p>");

                Reporter.log("<p align=\"left\"><font size=\"2\" face=\"Arial\" color=\"blue\">Full Stacktrace:</font></p>");


            } catch (IOException e1) {

                e1.printStackTrace();

            }

        }

    }

    public Properties getTestCaseData() {
        return getTestData(TestDataConfig.getTestSuitePropertyFilePath(getClassName()), getClassName());
    }

    public Properties getTestCaseData(int step) {
        return getTestData(TestDataConfig.getTestSuitePropertyFilePath(getClassName()), getClassName() + "." + step);
    }

    private void killDrivers() {
        if (getBrowser().equalsIgnoreCase("chrome")) {
            Cmd.executeCommand("Taskkill /IM chromedriver.exe /F");
        }
        if (getBrowser().equalsIgnoreCase("IE")) {
            Cmd.executeCommand("Taskkill /IM IEDriverServer32.exe /F");
        }
        if (getBrowser().equalsIgnoreCase("IE64")) {
            Cmd.executeCommand("Taskkill /IM IEDriverServer64.exe /F");
        }
    }

    private WebDriver getWebDriver(String browserName) {
        WebDriver specificDriver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            specificDriver = Firefox.startWithGecko();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            specificDriver = Chrome.start();
        }
        return specificDriver;
    }

    protected static WebDriver getDriver() {
        return driver;
    }

    protected void initPageFactory() {
        PageFactory.initElements(getDriver(), this);
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }

    protected BaseTest log(String logText) {
        Reporter.log(logText, 0, true);
        return this;
    }

    //implement on each component separately in case of need
    protected boolean exists(String componentId) {
        return false;
    }
}

