package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountPage;

public class LogInTests extends BaseTest{

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void logIn() throws InterruptedException {
		
		String username = citacIzExela.getData("LogIn", 5, 2); // customer
		String password = citacIzExela.getData("LogIn", 6, 2); // 123456789
		
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);

		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);

		citacIzExela.asertovanje("LogIn", 9, 2, myAccountPage.getLogOutLabel().getText());	
		
		Assert.assertEquals(true, myAccountPage.getLogOutLabel().isDisplayed());
		}
	
	@Test (priority = 5)
	public void logInWithoutCredentials() throws InterruptedException {
		String username = citacIzExela.getStringData("Empty Field", 1, 2);
		String password = citacIzExela.getStringData("Empty Field", 2, 2);
		String textForWrongCredentials = citacIzExela.getStringData("Empty Field", 3, 2);
		
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		
		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getNoCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, textForWrongCredentials);
		}
	
	@Test (priority = 10)
	public void logInWrongCredentials() throws InterruptedException {
		
		String username = citacIzExela.getStringData("Wrong credentials", 1, 2);
		String password = String.valueOf(citacIzExela.getIntData("Wrong credentials", 2, 2));
		String textForWrongCredentials = citacIzExela.getStringData("Wrong credentials", 3, 2);
		
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		
		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getWrongCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, textForWrongCredentials);
		}
	
	@Test (priority = 15)
	public void logOut() throws InterruptedException {
		String textBtnLogin = citacIzExela.getStringData("Wrong credentials", 1, 2);
		
		this.logIn();
		myAccountPage.getLogOutLabel().click();
		
		String textForAssert = myAccountPage.getLogInButton().getText();
		Assert.assertEquals(textForAssert, textBtnLogin);
		}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
