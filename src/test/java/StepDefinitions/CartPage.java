package StepDefinitions;

import io.cucumber.java.en.*;

public class CartPage {

	@And("User places order from the cart")
	public void User_places_order_from_the_cart() {
		System.out.println("User places order from the cart");
	}
	
	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
		System.out.println("the order should be placed successfully");
	}
}
