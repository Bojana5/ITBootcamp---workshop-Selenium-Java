package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	WebDriver driver;
	WebElement flyngNinjaAddToCardButton;
	WebElement product2;
	WebElement product3;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFlyngNinjaAddToCardButton() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[2]"));
	}

	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[2]/div/a[2]"));
	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[3]/div/a[2]"));
	}
	
	public void product1Click() {
		getFlyngNinjaAddToCardButton().click();
	}
	
	public void product2Click() {
		getProduct2().click();
	}
	
	public void product3Click() {
		getProduct3().click();
	}
	
}
