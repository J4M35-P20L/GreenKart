package StepDefinitions;

import java.io.IOException;

import Utils.TestContextSetup;
import io.cucumber.java.After;

public class Hooks {
	TestContextSetup testcontextsetup;
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	/*
	 * @After public void tearDown() throws IOException {
	 * testcontextsetup.testbase.WebDriverManager().quit(); }
	 */
}
