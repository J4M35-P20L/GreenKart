package StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.GreenKartHomePageObjects;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GreenKartHomePage {

	public WebDriver driver;
	public String homepageproduct;
	TestContextSetup testcontextsetup;
	
	public GreenKartHomePage(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	
	@Given("User is in the GreenKart HomePage")
	public void user_is_in_the_green_kart_home_page() {
		testcontextsetup.driver = new ChromeDriver();
		testcontextsetup.driver.manage().window().maximize();
		testcontextsetup.driver.manage().deleteAllCookies();
		testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	    
	}
	@When("User searches for the product {string} in the homepage")
	public void user_searches_for_the_product_in_the_homepage(String pname) {
	   
		GreenKartHomePageObjects gkhp = new GreenKartHomePageObjects(testcontextsetup.driver);
		gkhp.searchProduct(pname);
		testcontextsetup.homepageproduct = gkhp.getProductName();
		System.out.println("Retrieved product name is: "+testcontextsetup.homepageproduct);
	}
	
}
