package utils.config.tools;

import static utils.config.resources.ResourcesConfig.getTools;

public final class DriversConfig {

    public static String getTestDriversPath() {
        return getTools() + "/drivers/";
    }

    public static String getGeckoDriverPath() {
        return getTestDriversPath() + "geckodriver.exe";
    }

    public static String getChromeDriverPath() {
        return getTestDriversPath() + "chromedriver.exe";
    }

    public static String getChromeDriverPathForLinux() {
        return getTestDriversPath() + "chromedriver";
    }

}
