package utils.browsers;

import utils.config.properties.PropertyConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.util.Arrays;
import java.util.HashMap;
import static utils.config.resources.TestDataConfig.getOutputDir;
import static utils.config.tools.DriversConfig.getChromeDriverPath;
import static utils.config.tools.DriversConfig.getChromeDriverPathForLinux;
import static utils.config.tools.PortableBrowsersConfig.getChromeBinaryPath;

public class Chrome {

    public static WebDriver start() {
        return new ChromeDriver(getCapabilities());
    }

    private static ChromeOptions getCapabilities() {
        String outputDir = getOutputDir();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", outputDir);

        System.setProperty("webdriver.chrome.driver", getExecutablePathForChrome());

        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        if (PropertyConfig.getChromeBinaryPropertyVersion() != null
                && !PropertyConfig.getChromeBinaryPropertyVersion().isEmpty()) {
            options.setBinary(getChromeBinaryPath());
        }
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability("chrome.switches", Arrays.asList("--incognito"));
        return options;
    }

    private static String getExecutablePathForChrome() {
        return PropertyConfig.getOS().equalsIgnoreCase("Linux") ? getChromeDriverPathForLinux() : getChromeDriverPath();
    }
}
