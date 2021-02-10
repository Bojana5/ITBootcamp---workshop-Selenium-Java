package tests;

import java.util.ArrayList;

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

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ShopPage;

public class ProductTests extends BaseTest{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void addProductToCart() throws InterruptedException {
		
		mainPage.navigateToShopTab();
		Thread.sleep(2000);
		shopPage.product1Click();
		Thread.sleep(2000);
		mainPage.navigateToCartTab();
		Thread.sleep(2000);
		
		citacIzExela.asertovanje("AddProducts", 2, 1, cartPage.getTextProductName().getText());	
		}
	
	@Test (priority = 2)
	public void add3Products() throws InterruptedException {
		String text1 = citacIzExela.getStringData("AddProducts", 2, 1);
		String text2 = citacIzExela.getStringData("AddProducts", 3, 1);
		String text3 = citacIzExela.getStringData("AddProducts", 4, 1);
		
		mainPage.navigateToShopTab();
		Thread.sleep(2000);
		shopPage.product1Click();
		Thread.sleep(2000);
		shopPage.product2Click();
		Thread.sleep(2000);
		shopPage.product3Click();
		Thread.sleep(2000);
		mainPage.navigateToCartTab();
		Thread.sleep(2000);
		
		String textForAssert1 = cartPage.getFlyngNinjaProductLabel().getText();
		Assert.assertEquals(textForAssert1, text1);
		String textForAssert2 = cartPage.getTextProductName2().getText();
		Assert.assertEquals(textForAssert2, text2);
		String textForAssert3 = cartPage.getTextProductName2().getText();
		Assert.assertEquals(textForAssert3, text3);
		
	}
	
	@Test (priority = 2)
	public void addAndDeleteProducts() throws InterruptedException {
		String text1 = citacIzExela.getStringData("AddProducts", 2, 3);
		String text2 = citacIzExela.getStringData("AddProducts", 3, 1);
		
		addProductToCart();
		mainPage.navigateToShopTab();
		Thread.sleep(2000);
		shopPage.product2Click();
		Thread.sleep(2000);
		
		mainPage.navigateToCartTab();
		Thread.sleep(2000);
			
		cartPage.deleteClick();
		Thread.sleep(5000);
		
		String textForAssert = cartPage.getDeleteMessage().getText();
		Assert.assertEquals(textForAssert, text1);
		String textForAssert2 = cartPage.getTextProductName().getText();
		Assert.assertEquals(textForAssert2, text2);
	}
	
	@Test (priority = 5)
	public void deleteProduct() throws InterruptedException {
		String text = citacIzExela.getStringData("DeleteProduct", 1, 2);
		Thread.sleep(2000);
		this.addProductToCart();
		cartPage.deleteClick();
		Thread.sleep(5000);
		String textForAssert = cartPage.getTextEmptyCart().getText();
		Assert.assertEquals(textForAssert, text);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
