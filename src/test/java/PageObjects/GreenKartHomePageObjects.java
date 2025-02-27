package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenKartHomePageObjects {
	public WebDriver driver;
	
	public GreenKartHomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[text() = 'Tomato - 1 Kg']");
	
	//actions
	public void searchProduct(String pname) {
		driver.findElement(search).sendKeys(pname);
	}

	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
}
