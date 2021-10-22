# PMTool-test

UI Test project using selenium

### Java Version

The project uses Java 8. 

### Browsers Version

The project uses:
Firefox v93.0 
Chrome v95.0.4638.548

### Building and Running it locally

By using an IDE (eclipse/intelij) import the pom.xml as project:

You can build an executable jar-file by executing the following command:

mvn clean install

You can run the executable jar-file by executing the following command:

java -jar PMTool-test-1.0.0.jar -test-suite "test_suite_name"
	
(e.g. java -jar PMTool-test-1.0.0.jar -test-suite "TS_UI_PMTOOL_01")
