package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement inputUsername;
	WebElement inputPassword;
	WebElement loginBtn;

	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInputUsername() {
		return driver.findElement(By.id("user-name"));
		
	}
	
	public WebElement getInputPassword() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.id("login-button"));
	}
	
	public void insertUsername(String username) {
		this.getInputUsername().clear();
		this.getInputUsername().sendKeys(username);
	}
	
	public void insertPassword(String password) {
		this.getInputPassword().clear();
		this.getInputPassword().sendKeys(password);
	}
	
	public void loginBtnClick() {
		this.getLoginBtn().click();
	}

	
}



