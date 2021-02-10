package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement flyngNinjaProductLabel;
	WebElement delete;
	WebElement textEmptyCart;
	WebElement textProductName2;
	WebElement textProductName3;
	WebElement deleteMessage;
	WebElement textProductName;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFlyngNinjaProductLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	public WebElement getDelete() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[1]/a"));
	}

	public WebElement getTextEmptyCart() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p"));
	}

	public WebElement getTextProductName() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	public WebElement getTextProductName2() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[2]/td[3]/a"));
	}

	public WebElement getTextProductName3() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[3]/td[3]/a"));
	}
	

	public WebElement getDeleteMessage() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div[1]/div"));
	}

	public void deleteClick() {
		this.getDelete().click();
	}
	
	
}
