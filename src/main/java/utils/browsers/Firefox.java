package utils.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import static utils.config.resources.TestDataConfig.getOutputDir;
import static utils.config.tools.DriversConfig.getGeckoDriverPath;
import static utils.config.tools.PortableBrowsersConfig.getFirefoxBinaryPath;

public class Firefox {

    public static WebDriver start() {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(setPreferences(profile));
        System.setProperty("webdriver.gecko.driver", getFirefoxBinaryPath() );
        WebDriver driver = new FirefoxDriver(options);
        return driver;
    }
    public static WebDriver startWithGecko() {
        String filePathString = getGeckoDriverPath();
        System.setProperty("webdriver.gecko.driver", filePathString);
        FirefoxProfile profile = new FirefoxProfile();
        profile = setPreferences(profile);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
        return driver;
    }

    private static FirefoxProfile setPreferences(FirefoxProfile profile) {
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);

        String outputDir = getOutputDir();
        if (outputDir != "") {
            profile.setPreference("browser.download.dir", outputDir);
        } else {
            profile.setPreference("browser.download.dir", "c:/tmp_features");
        }
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip," +
                "text/csv," +
                "text/plain," +
                "image/jpeg," +
                "application/octet-stream," +
                "application/xml,text/xml," +
                "application/pdf," +
                "application/x-pdf," +
                "application/vnd.ms-excel," +
                "application/msword," +
                "application/vnd.ms-powerpoint," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet," +
                "application/vnd.openxmlformats-officedocument.presentationml.presentation," +
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
        );
        profile.setPreference("pdfjs.disabled", true);

        profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
        return profile;
    }
}
