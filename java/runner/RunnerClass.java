package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.restassured.RestAssured;
@CucumberOptions(features = "./src/main/java/Features",glue = {"steps","Hooks"},plugin ={"json:report/jsonreport.json",
		 "junit:target/cucumber-reports/Cucumber.xml",
		 "html:target/WebReport"})
public class RunnerClass extends AbstractTestNGCucumberTests{

	
	
}
