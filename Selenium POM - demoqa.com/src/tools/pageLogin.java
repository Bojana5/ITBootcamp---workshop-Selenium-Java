package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageLogin {
	
	WebDriver driver;
	WebElement userNameInputField;
	WebElement passwordInputField;
	WebElement loginBtn;
	WebElement logOutBtn;
	WebElement userNameValueLabel;
	WebElement loginWelcomeText;
	
	public pageLogin(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getUserNameInputField() {
		return driver.findElement(By.id("userName"));
	}
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}
	public WebElement getLoginBtn() {
		return driver.findElement(By.id("login"));
	}
	public WebElement getLogOutBtn() {
		return driver.findElement(By.id("submit"));
	}
	public WebElement getUserNameValueLabel() {
		return driver.findElement(By.xpath("//*[@id=\"userName-value\"]"));	
	}
	public WebElement getLoginWelcomeText() {
		return driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h5"));
	}
	public void insertUsername(String username) {
		this.getUserNameInputField().clear();
		this.getUserNameInputField().sendKeys(username);
	}
	
	public void insertPassword(String lozinka) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(lozinka);
	}
	
	public void loginBtnClick() {
		this.getLoginBtn().click();
	}
	
	public void logOutBtnClick() {
		this.getLogOutBtn().click();
	}
	
}
