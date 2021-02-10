package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	WebDriver driver;
	WebElement inputFirstName;
	WebElement inputLastName;
	WebElement zipCode;
	WebElement continueBtn;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInputFirstName() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getInputLastName() {
		return driver.findElement(By.id("last-name"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.id("postal-code"));
	}

	public WebElement getContinueBtn() {
		return driver.findElement(By.className("cart_button"));
	}
	
	public void insertFirstName(String name) {
		this.getInputFirstName().clear();
		this.getInputFirstName().sendKeys(name);
	}
	
	public void insertLastName(String lastName) {
		this.getInputLastName().clear();
		this.getInputLastName().sendKeys(lastName);
	}
	
	public void insertZipCode(String zip) {
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zip);
	}
	
	public void continueBtnClick() {
		this.getContinueBtn().click();
	}
}
