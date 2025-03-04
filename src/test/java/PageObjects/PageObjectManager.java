package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public GreenKartHomePageObjects GreenKartHomeObject;
	public TopDealsPageObjects TopDealsPageObject;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public GreenKartHomePageObjects getGreenKartHomePageObject() {
		GreenKartHomeObject = new GreenKartHomePageObjects(driver);
		return GreenKartHomeObject;
	}
	public TopDealsPageObjects getTopDealsPageObjects() {
		TopDealsPageObject = new TopDealsPageObjects(driver);
		return TopDealsPageObject;
	}
}
