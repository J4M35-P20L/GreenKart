
Feature: Greenkart Homepage
   
  Scenario: Verify the product in top deals page
  Given User is in the GreenKart HomePage
  When User searches for the product "tom" in the homepage
  And User Searches for the product "tom" in the top deals page
  Then product should be available in the top deals page 
 

  