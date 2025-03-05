package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObjects {

public WebDriver driver;
	
	public CartPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	By product = By.xpath("//p[text()='Tomato - 1 Kg' and @class='product-name']");
	By placeorder = By.xpath("//button[text()='Place Order']");
	By selectcountry = By.xpath("//div[@class='wrapperTwo']/div/select");
	By agree = By.xpath("//input[@class='chkAgree']");
	By proceed = By.xpath("//span[@class='errorAlert']/following-sibling::button");
	By success = By.xpath("//div[@class='wrapperTwo']/span");
	
	//actions
	public String getProductName() {
		return driver.findElement(product).getText().split("-")[0].trim();
	}
	
	public void placeOrder() {
		explicitWaitForElement(placeorder);
		driver.findElement(placeorder).click();
	}
	
	public void selectCountry(String countryname) {
		WebElement country = driver.findElement(selectcountry);
		Select select = new Select(country);
		select.selectByValue(countryname);
	}
	public void chkagreeproceed() {
		driver.findElement(agree).click();
		driver.findElement(proceed).click();
	}
	
	public String getSuccessMessage() {
		return driver.findElement(success).getText();
	}
	//wait for element
		public void explicitWaitForElement(By element) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
}
