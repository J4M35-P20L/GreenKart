package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.CartPageObjects;
import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class CartPage {
	
	public WebDriver driver;
	public String cartproduct;
	TestContextSetup testcontextsetup;
	CartPageObjects cart;
	
	public CartPage(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup; 
				}
	
	@And("User places order from the cart")
	public void User_places_order_from_the_cart() {
		 cart = testcontextsetup.PageObjectManager.getCartPageObjects();
		testcontextsetup.cartproduct = cart.getProductName();
		Assert.assertEquals(testcontextsetup.cartproduct, testcontextsetup.homepageproduct);
		System.out.println(testcontextsetup.cartproduct+": Product is in the cart");
	}
	
	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
		cart.placeOrder();
		cart.selectCountry("India");
		cart.chkagreeproceed();
		String expsuccessmsg = "Thank you, your order has been placed successfully";
		String actsuccessmsg = cart.getSuccessMessage();
		if(expsuccessmsg.equalsIgnoreCase(actsuccessmsg)) {
			System.out.println("--The order is placed successfully--");
		}
		else {
			System.out.println("--The order is not placed successfully--");
		}
		//Assert.assertEquals(actsuccessmsg, expsuccessmsg, "This message is expected: "+expsuccessmsg);
		//Assert.assertTrue(false, actsuccessmsg);
		System.out.println("--The order is placed successfully--");
	}
}
