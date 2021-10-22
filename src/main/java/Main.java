import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import static utils.config.resources.ResourcesConfig.getUITTPropertyFilePath;
import static utils.config.resources.TestDataConfig.getTestData;
import static utils.config.resources.TestDataConfig.getTestSuiteId;

public class Main {

    public static void main(String[] args) {
        if (args[0].equalsIgnoreCase("-test-case")) {
            runTestCase(args);
        } else if (args[0].equalsIgnoreCase("-test-suite")) {
            runTestSuite(args);
        } else
            System.out.println("Error in Attributes!");
    }

    public static void runTestSuite(String[] args) {
        if (args[1].equals("ALL")) {
            Properties tsProp = getTestData(getPropertyFilePath(), "ts");
            if (tsProp.size() > 1) {
                int i = 0;
                while (tsProp.size() > i) {
                    i++;
                    String args1 = tsProp.getProperty(i + "");
                    runOneTestSuite(args1);
                }
            }
        } else {
            runOneTestSuite(args[1]);
        }
    }

    private static void runOneTestSuite(String args1) {
        Properties appProp = getTestData(getUITTPropertyFilePath(), "app");
        String browser = appProp.getProperty("browser");
        System.out.println("Test Suite: " + args1);
        System.out.println("Browser: " + browser);
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        suites.add("test_suites/" + args1 + ".xml");
        String timeStamp = timestamp();
        new File("reports/" + args1 + "_" + timeStamp + "_" + browser).mkdirs();
        testng.setOutputDirectory("reports/" + args1 + "_" + timeStamp + "_" + browser);
        testng.setTestSuites(suites);
        testng.addListener(tla);
        testng.run();

    }

    public static void runTestCase(String[] args) {
        Properties appProp = getTestData(getUITTPropertyFilePath(), "app");
        String browser = appProp.getProperty("browser");
        try {
            System.out.println("Test Case: " + args[1]);
            System.out.println("Browser: " + browser);
            String tcName = args[1];
            tcName = tcName.replaceAll("-", "_");

            String oldTcName = "";
            oldTcName = tcName.replaceAll("TC_", "TS_");

            String tsName = "";
            String[] partTcName = oldTcName.split("_");

            @SuppressWarnings("rawtypes")
            Class c = Class.forName("test_suites." + getTestSuiteId(tcName) + "." + tcName);
            TestListenerAdapter tlaTest = new TestListenerAdapter();
            TestNG testngTest = new TestNG();
            String timeStamp = timestamp();
            new File("reports/" + args[1] + "_" + timeStamp + "_" + browser).mkdirs();
            testngTest.setOutputDirectory("reports/" + args[1] + "_" + timeStamp + "_" + browser);

            @SuppressWarnings("rawtypes")
            List<Class> listenerClasses = new ArrayList<Class>();

            testngTest.setTestClasses(new Class[]{c});
            testngTest.addListener(tlaTest);
            testngTest.run();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String timestamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return timeStamp;
    }

    public static String getPropertyFilePath() {
        String filePathString = Paths.get(".").toAbsolutePath().normalize().toString()
                + "/TestDataConfig.properties";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = Paths.get(".").toAbsolutePath().normalize().toString()
                    + "/src/main/resources/TestDataConfig.properties";
        return filePathString;
    }
}
