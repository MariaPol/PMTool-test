# PMTool-test

UI Test project using selenium

### Java Version

The project uses Java 8. 

### Browsers Version

The project uses:
Firefox v93.0 
Chrome v95.0.4638.548

### Building 

By using an IDE (eclipse/intelij) import the pom.xml as project:

You can build an executable jar-file by executing the following command:

mvn clean install

### Running it locally

1. In uitt.properties file set:
For execution using Google Chrome browser
	app.browser = chrome
For execution using Firefox Mozilla browser
	app.browser = firefox

2. Run a suite using a command line:
	java -jar PMTool-test-1.0.0.jar -test-suite "test_suite_name"
	(e.g. java -jar PMTooltest-1.0.0.jar -test-suite "TS_UI_PMTOOL_01")
3. Run a test case using a command line:
	java -jar PMTool-test-1.0.0.jar -test-case "test_case_name"
	(e.g. java -jar PMTool-test-1.0.0.jar -test-suite "TS_UI_PMTOOL_01_001")
	
The available suites are:
TS_UI_PMTOOL_01
TS_UI_PMTOOL_02
TS_UI_PMTOOL_03
TS_UI_PMTOOL_04
TS_UI_PMTOOL_05

The available test cases are:
TC_UI_PMTOOL_01_001
TC_UI_PMTOOL_01_002
TC_UI_PMTOOL_02_001
TC_UI_PMTOOL_02_002
TC_UI_PMTOOL_02_003
TC_UI_PMTOOL_02_004
TC_UI_PMTOOL_03_001
TC_UI_PMTOOL_03_002
TC_UI_PMTOOL_03_003 
TC_UI_PMTOOL_03_004
TC_UI_PMTOOL_04_001
TC_UI_PMTOOL_04_002
TC_UI_PMTOOL_04_003
TC_UI_PMTOOL_04_004
TC_UI_PMTOOL_04_005
TC_UI_PMTOOL_05_001
TC_UI_PMTOOL_05_002
TC_UI_PMTOOL_05_003
