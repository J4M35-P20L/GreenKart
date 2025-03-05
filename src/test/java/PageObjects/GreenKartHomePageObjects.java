package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartHomePageObjects {
	public WebDriver driver;
	
	public GreenKartHomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[text() = 'Tomato - 1 Kg']");
	By increment = By.xpath("//a[@class='increment']");
	By addtocart = By.xpath("//button[text()='ADD TO CART']");
	By carticon = By.xpath("//div[@class='cart-info']/following-sibling::a/img");
	By proceedtochkout = By.xpath("//div[@class='action-block']/button");
	
	//actions
	public void searchProduct(String pname) {
		driver.findElement(search).sendKeys(pname);
	}
	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	public void incrementitem(int noofitems) throws InterruptedException {
		Thread.sleep(1500);
		for(int i = 1;i<noofitems;i++) {
		driver.findElement(increment).click();
		}
	}
	
	public void clickAddToCart() {
		explicitWaitForElement(addtocart);
		driver.findElement(addtocart).click();
	}
	
	public void clickOnCartIcon() {
		driver.findElement(carticon).click();
	}
	
	public void clickOnProceedToCheckout() {
		explicitWaitForElement(proceedtochkout);
		driver.findElement(proceedtochkout).click();
	}
	//wait for element
	public void explicitWaitForElement(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
