package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	WebElement checkoutBtn;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCheckoutBtn() {
		return driver.findElement(By.className("checkout_button"));
	}
	
	public void checkoutBtnClick() {
		this.getCheckoutBtn().click();
	}
	

}
