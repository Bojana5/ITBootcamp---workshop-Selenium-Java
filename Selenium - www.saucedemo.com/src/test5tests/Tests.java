package test5tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest{

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/index.html");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void logInTest() throws InterruptedException {
		
		mainPage.insertUsername("standard_user");
		Thread.sleep(2000);
		mainPage.insertPassword("secret_sauce");
		Thread.sleep(2000);
		mainPage.loginBtnClick();
		Thread.sleep(2000);
		
		String textForAssert = inventoryPage.getProductLabel().getText();
		Assert.assertEquals(textForAssert, "Products");
		Thread.sleep(2000);
		
		String textForAssert1 = inventoryPage.textLogout().getText();
		Assert.assertEquals(textForAssert1, "Logout");
		Thread.sleep(2000);

		}
	
	@Test (priority = 5)
	public void orderingTests() throws InterruptedException {
		logInTest();
		Thread.sleep(2000);
		inventoryPage.addToCartBtnClick();
		Thread.sleep(2000);
		inventoryPage.shoppingCartBtnClick();
		Thread.sleep(2000);
		cartPage.checkoutBtnClick();
		Thread.sleep(2000);
		
		checkoutPage.insertFirstName("Petar");
		Thread.sleep(2000);
		checkoutPage.insertLastName("Petrovic");
		Thread.sleep(2000);
		checkoutPage.insertZipCode("21000");
		Thread.sleep(2000);
		checkoutPage.continueBtnClick();
		Thread.sleep(2000);
		checkoutOverviewPage.finishBtnClick();
		
		String textForAssert = checkoutCompletePage.getOrderDispatched().getText();
		Assert.assertEquals(textForAssert, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		Thread.sleep(2000);

		}
		
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
