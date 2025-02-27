package StepDefinitions;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.TopDealsPageObjects;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class TopDealsPage {
	public WebDriver driver;
	String productname;
	TestContextSetup testcontextsetup;
	public TopDealsPage(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	@When("User Searches for the product {string} in the top deals page")
	public void user_searches_for_the_product_in_the_top_deals_page(String pname) {
		TopDealsPageObjects tdpo = new TopDealsPageObjects(testcontextsetup.driver);
		if(tdpo.topdealslink().isEnabled())
			{
			tdpo.topdealslink().click();
			System.out.println("topdealslink is clicked");
			}
		else {
			System.out.println("topdealslink is not available");
		}
		
		//searching for product in top deals page
		tdpo.search(pname);
		productname = tdpo.getproductName();
	    System.out.println("Top deals page product is: "+productname);
	}
	@Then("product should be available in the top deals page")
	public void product_should_be_available_in_the_top_deals_page() {
	    if(testcontextsetup.homepageproduct.equalsIgnoreCase(productname)) {
	    	System.out.println("Homepage product "+testcontextsetup.homepageproduct+" is available in top deals page");
	    }
	    else {
	    	System.out.println("Homepage product "+testcontextsetup.homepageproduct+" is not available in top deals page");
	    }
	}
}
