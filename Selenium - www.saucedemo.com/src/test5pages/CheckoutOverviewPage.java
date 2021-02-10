package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
	
	WebDriver driver;
	WebElement finishBtn;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFinishBtn() {
		return driver.findElement(By.className("cart_button"));
	}
	
	public void finishBtnClick() {
		this.getFinishBtn().click();
	}
	
}
