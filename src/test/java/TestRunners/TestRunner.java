package TestRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "src/test/java/Features",
glue = "StepDefinitions",
plugin = { "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
tags = "@regression")
public class TestRunner extends AbstractTestNGCucumberTests {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel=true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
