package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class TopDealsPageObjects {

	public WebDriver driver;
	
	public TopDealsPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	By topdealslink = By.linkText("Top Deals");
	By flightbookinglink = By.linkText("Flight Booking");
	By search = By.xpath("//input[@id='search-field']");
	By productName = By.xpath("//div[@class='row']/following-sibling::table/tbody//td[1]");
	
	//actions
	public WebElement topdealslink() {
		
		return driver.findElement(topdealslink);
	}
	
	public WebElement flightbookinglink() {
		return driver.findElement(flightbookinglink);
	}
	
	public void search(String pname) {
		switchWindow();
		explicitWaitForElement(search);
		driver.findElement(search).sendKeys(pname);;
	}
	public String getproductName() {
		return driver.findElement(productName).getText();
	}
	public void explicitWaitForElement(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void switchWindow() {
		String curwindow = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		
		for(String childwindow : windowhandles) {
			if(childwindow!=curwindow) {
				driver.switchTo().window(childwindow);
			}
		}
		
	}
}
