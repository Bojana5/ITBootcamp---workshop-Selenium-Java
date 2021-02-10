package test5tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import test5pages.CartPage;
import test5pages.CheckoutCompletePage;
import test5pages.CheckoutOverviewPage;
import test5pages.CheckoutPage;
import test5pages.InventoryPage;
import test5pages.MainPage;

public class BaseTest {
	
	WebDriver driver;
	JavascriptExecutor js;
	MainPage mainPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutCompletePage checkoutCompletePage;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.mainPage = new MainPage(driver);
		this.inventoryPage = new InventoryPage(driver);
		this.cartPage = new CartPage(driver);
		this.checkoutPage = new CheckoutPage(driver);
		this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
		this.checkoutCompletePage = new CheckoutCompletePage(driver);

		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
	}

}
