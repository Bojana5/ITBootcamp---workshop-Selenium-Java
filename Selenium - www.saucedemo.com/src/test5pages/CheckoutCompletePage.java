package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
	
	WebDriver driver;
	WebElement orderDispatched;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getOrderDispatched() {
		return driver.findElement(By.className("complete-text"));
	}

}
