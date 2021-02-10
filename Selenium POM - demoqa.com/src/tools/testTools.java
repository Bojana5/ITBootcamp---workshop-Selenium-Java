package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testTools {
	
	WebDriver driver;
	JavascriptExecutor js;
	pageTools pageTools;
	pageBooks pageBooks;
	pageLogin pageLogin;
	pageProfile pageProfile;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.pageTools = new pageTools(driver, js);
		this.pageBooks = new pageBooks(driver, js);
		this.pageLogin = new pageLogin(driver);
		this.pageProfile = new pageProfile(driver, js);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void login() throws InterruptedException {
		pageTools.navigateToBookStoreApp();
		Thread.sleep(2000);
		pageBooks.loginBtnClick();
		Thread.sleep(2000);
		pageLogin.insertUsername("bojana");
		Thread.sleep(2000);
		pageLogin.insertPassword("Test@123");
		Thread.sleep(2000);
		pageLogin.loginBtnClick();
		Thread.sleep(2000);

		String textForAssert = pageLogin.getLogOutBtn().getText();
		Assert.assertEquals(textForAssert, "Log out");
		Thread.sleep(2000);
		String textForAssert2 = pageLogin.getUserNameValueLabel().getText();
		Assert.assertEquals(textForAssert2, "bojana");
		Thread.sleep(2000);
	}
	
	@Test (priority = 2)
	public void addBook() throws InterruptedException {
		this.login();
		pageBooks.addBookClick();
		Thread.sleep(2000);
		pageBooks.addToCollectionClick();
		Thread.sleep(5000);
		pageBooks.alertMessages();
		Thread.sleep(5000);
		pageProfile.profileBtnClick();
		Thread.sleep(2000);
		
		String textForAssert = pageProfile.getBookTitle().getText();
		Assert.assertEquals(textForAssert, "Git Pocket Guide");		
		Thread.sleep(5000);
		
		pageProfile.deleteAllBooksBtnClick();
		Thread.sleep(2000);
		pageProfile.deleteAllBooksConfirmClick();
		Thread.sleep(2000);
		pageBooks.alertMessages();
		Thread.sleep(2000);

		String noBook = pageProfile.getEmptyField().getText();
		Assert.assertEquals(noBook, " ");
		Thread.sleep(2000);
	}
	
	@Test (priority = 5)
	public void logOut() throws InterruptedException {
		this.login();
		pageLogin.logOutBtnClick();
		Thread.sleep(2000);
		
		String textForAssert = pageLogin.getLoginBtn().getText();
		Assert.assertEquals(textForAssert, "Login");
		String textForAssert2 = pageLogin.getLoginWelcomeText().getText();
		Assert.assertEquals(textForAssert2, "Login in Book Store");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}





