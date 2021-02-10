package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageTools {

	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement bookStoreApp;
		
	public pageTools(WebDriver driver) {
		this.driver = driver;
	}
	public pageTools(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public WebElement getBookStoreApp() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
	}

	public void navigateToBookStoreApp() throws InterruptedException{
		js.executeScript("arguments[0].scrollIntoView(true);", this.getBookStoreApp());
		Thread.sleep(2000);
		this.getBookStoreApp().click();
	}	
}


