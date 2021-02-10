package tools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageBooks {

	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement loginBtn;
	WebElement bookStoreBtn;
	WebElement addBook;
	WebElement addToCollection;
	WebElement radioBtn;
	
	public pageBooks(WebDriver driver) {
		this.driver = driver;
	}
	public pageBooks(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.id("login"));
	}
	public WebElement getBookStoreBtn() { 
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/div[1]/button"));
	}
	public WebElement getAddBook() {
		return driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a"));
	}
	public WebElement getAddToCollection() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/div[2]/button"));
	}
	public WebElement getRadioBtn() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/label"));
	}
	

	public void loginBtnClick() {
		this.getLoginBtn().click();
	}
	public void bookStoreBtnClick() {
		js.executeScript("arguments[0].click()", this.getBookStoreBtn());

	}
	public void addBookClick() {
		this.getAddBook().click();
	}
	public void addToCollectionClick() {
		js.executeScript("arguments[0].click()", this.getAddToCollection());
	}
	public void radioBtnClick() {
		this.getRadioBtn().click();
	}
	public void alertMessages() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public String alertMessagesGetText() {
		return driver.switchTo().alert().getText();	
	}

}
