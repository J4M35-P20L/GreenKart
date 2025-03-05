package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import PageObjects.PageObjectManager;
public class TestContextSetup {

	public WebDriver driver;
	public String homepageproduct;public String topdealsproductname;public String cartproduct;
	public PageObjectManager PageObjectManager;
	public TestBase testbase;
	public GenericUtils genericutils;
	public String pname;
	
	public TestContextSetup() throws IOException {
		testbase = new TestBase();
		PageObjectManager = new PageObjectManager(testbase.WebDriverManager());
		genericutils = new GenericUtils(testbase.WebDriverManager());
	}
	
}
