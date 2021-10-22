package utils.config.resources;

import utils.BaseTest;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static utils.config.properties.PropertyConfig.getProperties;
import static utils.config.resources.ResourcesConfig.*;

public class TestDataConfig extends BaseTest {

    private static Properties params;
    private static String propertyName;

    /**
     * Gets the properties from the test date, either one or a list of properties.
     * Useful when we want to loop to a property than has multiple values.
     * <p>
     * Returns a list with one or more entries.
     *
     * @param params
     * @param propertyName
     * @return
     */
    public static List<String> multipleOrSingleTestData(Properties params, String propertyName) {
        TestDataConfig.params = params;
        TestDataConfig.propertyName = propertyName;

        String PROPERTY_NAME = propertyName;
        String prmValue = params.getProperty(PROPERTY_NAME);
        String prmMulti = params.getProperty(PROPERTY_NAME + ".1");

        List<String> values = new ArrayList<>();

        if ((prmValue != null && !prmValue.isEmpty()) ||
                (prmMulti != null && !prmMulti.isEmpty())) {
            if (prmMulti != null && !prmMulti.isEmpty()) {
                Properties properties = getProperties(params, PROPERTY_NAME);
                if (properties.size() > 1) {
                    int i = 0;

                    while (properties.size() > i) {
                        int k = i + 1;
                        // Add each property in the list
                        values.add(params.getProperty(PROPERTY_NAME + "." + k));
                        i++;
                    }
                }
            } else {
                // Add only one property
                values.add(prmValue);
            }
        }
        return values;
    }

    public static Properties getTestData(String filepath, String dataSetPrefix) {
        Properties prop = loadTestData(filepath);
        if (dataSetPrefix != null){
            return getProperties(prop, dataSetPrefix);
        } else{
            return prop;
        }
    }

    public static String getTestSuitePropertyFilePath(String className) {
        return getPropertyFile("/test_data/testData/" + getTestSuiteId(className));
    }

    public static String getTestSuiteId(String className) {
        String testSuiteId = "";
        Properties appProp = getTestData(getUITTPropertyFilePath(), "tc");
        if (appProp != null && !appProp.isEmpty()) {
            testSuiteId = appProp.getProperty(className);
        }
        return testSuiteId;
    }

    public static Properties loadProperties(String testDataFile) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(testDataFile);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            prop.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getInputDir() {
        return getResourcesPath() + "/test_data/inputDir/";
    }

    public static String getOutputDir() {
        return getResourcesPath() + "/test_data/outputDir/";
    }

    private static Properties loadTestData(String testDataFile) {
        return loadProperties(testDataFile);
    }

}
