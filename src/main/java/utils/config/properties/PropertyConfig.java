package utils.config.properties;

import java.util.Enumeration;
import java.util.Properties;
import static utils.config.resources.ResourcesConfig.getUITTPropertyFilePath;
import static utils.config.resources.TestDataConfig.getTestData;

public class PropertyConfig {

    public static String getOS() {
        return System.getProperty("os.name");
    }

    public static String getPropertyValue(String prefix, String propertyVariable) {
        String property = null;
        Properties appProp = getTestData(getUITTPropertyFilePath(), prefix);
        if (appProp != null && !appProp.isEmpty()) {
            property = appProp.getProperty(propertyVariable);
        }
        return property;
    }

    public static String getURL() {
        return getPropertyValue("app", "url");
    }

    public static String getBrowser() {
        return getPropertyValue("app", "browser");
    }

    public static String getDebugMode() {
        return getPropertyValue("app", "debug");
    }

    public static String getFirefoxBinaryPropertyVersion() {
        return getPropertyValue("binary", "firefox");
    }

    public static String getChromeBinaryPropertyVersion() {
        return getPropertyValue("binary", "chrome");
    }

    public static Properties getProperties(Properties params, String prefix) {
        Properties result = new Properties();

        @SuppressWarnings("rawtypes")
        Enumeration names = params.propertyNames();

        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();

            if (name.indexOf(prefix) == 0) {
                result.put(name.substring(prefix.length() + 1), params.get(name));
            }
        }

        return result;
    }
}
