package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
	WebDriver driver;
	WebElement burgerBtn;
	WebElement LogoutLabel;
	WebElement productLabel;
	WebElement addToCartBtn;
	WebElement shoppingCartBtn;
	WebElement crossBtn;	
	
	public WebElement getCrossBtn() {
		return driver.findElement(By.className("bm-cross-button"));
	}

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBurgerBtn() {
		return driver.findElement(By.className("bm-burger-button"));
	}

	public WebElement getLogoutLabel() {
		return driver.findElement(By.id("logout_sidebar_link"));
	}
	
	public WebElement getProductLabel() {
		return driver.findElement(By.className("product_label"));
	}
	
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
	}

	public WebElement getShoppingCartBtn() {
		return driver.findElement(By.id("shopping_cart_container"));
	}
	
	public void addToCartBtnClick() {
		this.getAddToCartBtn().click();
	}
	
	public void shoppingCartBtnClick() {
		this.getShoppingCartBtn().click();
	}
	
	public WebElement textLogout() throws InterruptedException {
		this.getBurgerBtn().click();
		Thread.sleep(2000);
		WebElement textLogout = getLogoutLabel();
		Thread.sleep(2000);
		this.getCrossBtn().click();
		return textLogout;
		
	}

}
