package StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.GreenKartHomePageObjects;
import PageObjects.PageObjectManager;
import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GreenKartHomePage {

	public WebDriver driver;
	public String homepageproduct;
	TestContextSetup testcontextsetup;
	public TestBase testbase;
	
	
	public GreenKartHomePage(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	
	@Given("User is in the GreenKart HomePage")
	public void user_is_in_the_green_kart_home_page() {
		System.out.println("Browser is getting opened");
	}
	@When("^User searches for the product (.+) in the homepage$")
	public void user_searches_for_the_product_in_the_homepage(String pname) {
	   
		//GreenKartHomePageObjects gkhp = new GreenKartHomePageObjects(testcontextsetup.driver);
		GreenKartHomePageObjects gkhp = testcontextsetup.PageObjectManager.getGreenKartHomePageObject();	
		gkhp.searchProduct(pname);
		testcontextsetup.homepageproduct = gkhp.getProductName();
		System.out.println("Retrieved product name is: "+testcontextsetup.homepageproduct);
	}
	
	@When("User adds the {int} products {string} to the cart")
	public void user_adds_the_product_to_the_cart(int noofproducts, String pname) throws InterruptedException {
		GreenKartHomePageObjects gkhp = testcontextsetup.PageObjectManager.getGreenKartHomePageObject();
	    gkhp.searchProduct(pname);
	    testcontextsetup.homepageproduct = gkhp.getProductName();
	    System.out.println("------------------------------------------");
	    System.out.println("Homepage product name is: "+testcontextsetup.homepageproduct);
	    System.out.println("------------------------------------------");
	    gkhp.incrementitem(noofproducts);
	    gkhp.clickAddToCart();
	    System.out.println(noofproducts+" items are added to the cart");
	}
	
}
