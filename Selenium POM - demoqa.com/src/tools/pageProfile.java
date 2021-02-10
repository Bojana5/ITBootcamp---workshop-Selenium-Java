package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageProfile {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement profileBtn;
	WebElement bookTitle;
	WebElement deleteAllBooksBtn;
	WebElement deleteAllBooksConfirm;
	WebElement collectionEmpty;
	WebElement emptyField; 

	public pageProfile(WebDriver driver) {
		this.driver = driver;
	}
	public pageProfile(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}


	public WebElement getProfileBtn() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));		
	}	
	public WebElement getBookTitle() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a"));
	}	
	public WebElement getDeleteAllBooksBtn() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div[3]/button"));	
	}
	public WebElement getDeleteAllBooksConfirm() {
		return driver.findElement(By.id("closeSmallModal-ok"));
		//*[@id="closeSmallModal-ok"]
	}	
	public WebElement getCollectionEmpty() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div"));	
	}
	public WebElement getEmptyField() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]"));
	}
	
	public void profileBtnClick() {
		js.executeScript("arguments[0].click()", this.getProfileBtn());
	}
	public void deleteAllBooksBtnClick() {
		this.getDeleteAllBooksBtn().click();
	}
	public void deleteAllBooksConfirmClick() {
		this.getDeleteAllBooksConfirm().click();
	}


}
