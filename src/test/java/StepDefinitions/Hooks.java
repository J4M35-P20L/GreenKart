package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	TestContextSetup testcontextsetup;
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	/*
	 * @After public void tearDown() throws IOException {
	 * testcontextsetup.testbase.WebDriverManager().quit(); }
	 */
	public void AddScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			WebDriver driver = testcontextsetup.testbase.WebDriverManager();
			//screenshot
			TakesScreenshot takescreenshot = (TakesScreenshot)driver ;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(filecontent, "image/png", "DefectImage");
				
		}
	}
}
