package utils.config.tools;

import static utils.config.properties.PropertyConfig.getChromeBinaryPropertyVersion;
import static utils.config.properties.PropertyConfig.getFirefoxBinaryPropertyVersion;
import static utils.config.resources.ResourcesConfig.getTools;

public final class PortableBrowsersConfig {

    private static String getPortableBrowsersPath() {
        return getTools() + "/portable-browsers/";
    }

    public static String getFirefoxBinaryPath() {
        return getPortableBrowsersPath() + "firefox/" + getFirefoxBinaryPropertyVersion() + "/firefox.exe";
    }

    public static String getChromeBinaryPath() {
        return getPortableBrowsersPath() + "chrome/" + getChromeBinaryPropertyVersion() + "/chrome.exe";
    }
}
