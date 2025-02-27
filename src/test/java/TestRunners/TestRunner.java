package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "",
glue = "",
plugin = {"pretty","html:target/cucumber-reports.html"},
monochrome = true

		)


public class TestRunner extends AbstractTestNGCucumberTests {

}
