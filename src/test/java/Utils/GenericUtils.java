package Utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void switchToChildWindow() {
		
			String curwindow = driver.getWindowHandle();
			Set<String> windowhandles = driver.getWindowHandles();
			
			for(String childwindow : windowhandles) {
				if(childwindow!=curwindow) {
					driver.switchTo().window(childwindow);
				}
			}
			
	}
}
