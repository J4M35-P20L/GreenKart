
Feature: Greenkart Homepage
  
  @smoke
  Scenario Outline: Verify the product in top deals page
  When User searches for the product <vegetable> in the homepage
  And User Searches for the product <vegetable> in the top deals page
  Then product should be available in the top deals page
  
  Examples: 
	| vegetable |
	| beet |
	| tom |
  
  @regression
   Scenario Outline: Verify the checkout functionality
   Given User is in the GreenKart HomePage
   When User adds the 4 products "tom" to the cart
   And User places order from the cart
   Then the order should be placed successfully