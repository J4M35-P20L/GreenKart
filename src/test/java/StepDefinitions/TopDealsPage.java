package StepDefinitions;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.PageObjectManager;
import PageObjects.TopDealsPageObjects;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class TopDealsPage {
	public WebDriver driver;
	public String topdealsproductname;
	TestContextSetup testcontextsetup;
    PageObjectManager pageobjectmanager;
	public TopDealsPage(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
	}
	@And("^User Searches for the product (.+) in the top deals page$")
	public void user_searches_for_the_product_in_the_top_deals_page(String pname) {
		TopDealsPageObjects tdpo = testcontextsetup.PageObjectManager.getTopDealsPageObjects();
		if(tdpo.topdealslink().isEnabled())
			{
			tdpo.topdealslink().click();
			System.out.println("topdealslink is clicked");
			}
		else {
			System.out.println("topdealslink is not available");
		}
		//switch to top deals window
		//testcontextsetup.genericutils.switchToChildWindow();
		tdpo.switchWindow();
		//searching for product in top deals page
		tdpo.search(pname);
		testcontextsetup.topdealsproductname = tdpo.getproductName();
	    System.out.println("Top deals page product is: "+testcontextsetup.topdealsproductname);
	}
	@Then("product should be available in the top deals page")
	public void product_should_be_available_in_the_top_deals_page() {
	    if(testcontextsetup.homepageproduct.equalsIgnoreCase(testcontextsetup.topdealsproductname)) {
	    	System.out.println("Homepage product "+testcontextsetup.topdealsproductname+" is available in top deals page");
	    }
	    else {
	    	System.out.println("Homepage product "+testcontextsetup.topdealsproductname+" is not available in top deals page");
	    }
	}
}
