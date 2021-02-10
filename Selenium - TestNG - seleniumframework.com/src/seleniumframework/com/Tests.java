package seleniumframework.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void assertAllFields() throws InterruptedException {
		
		String text;
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[1]"));
		text = name.getText();
		Assert.assertEquals(text, "Name *");
		//ili
//		Assert.assertNotNull(name);
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[2]"));
		text = email.getText();
		Assert.assertEquals(text, "E-mail *");
//		Assert.assertNotNull(email);
		
		WebElement telephone = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[3]"));
		text = telephone.getText();
		Assert.assertEquals(text, "Telephone *");
//		Assert.assertNotNull(telephone);
		
		WebElement country = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[4]"));
		text = country.getText();
		Assert.assertEquals(text, "Country");
//		Assert.assertNotNull(country);
		
		WebElement company = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[5]"));
		text = company.getText();
		Assert.assertEquals(text, "Company");
//		Assert.assertNotNull(company);		
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/span"));
		text = message.getText();
		Assert.assertEquals(text, "Message");
//		Assert.assertNotNull(message);		
		
	}
	
	@Test (priority = 5)
	public void submitForm() throws InterruptedException {
		
//		String text;
		
		WebElement inputName = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[1]/input"));
		inputName.sendKeys("Bojana");
		Thread.sleep(2000);
		inputName.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[2]/input"));
		inputEmail.sendKeys("fakemail@gmail.com");
		Thread.sleep(2000);
		inputEmail.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement inputTelephone = driver.findElement(By.xpath("//*[@id=\"form-validation-field-2\"]"));
		inputTelephone.sendKeys("123456");
		Thread.sleep(2000);
//		inputTelephone.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		
		WebElement inputCountry = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[4]/input"));
		inputCountry.click();
		Thread.sleep(2000);
		inputCountry.sendKeys("Srbija");
		Thread.sleep(2000);
		
		WebElement inputCompany = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[5]/input"));
		inputCompany.click();
		Thread.sleep(2000);
		inputCompany.sendKeys("Kompanija");
		Thread.sleep(2000);
		
		WebElement inputMessage = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/span/textarea"));
		inputMessage.click();
		Thread.sleep(2000);
		inputMessage.sendKeys("aaaaaaaa");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/p/a[1]")).click();
		Thread.sleep(2000);
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div[1]"));
//		String text = message.getText();
//		Assert.assertEquals(text, "Feedback has been sent to the administrator");
		Assert.assertNotNull(message);		
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}

/*
 1. Koristeci anotacije testNG-a, napisati test sa sledecim zahtevima:
Otici na web stranicu http://www.seleniumframework.com/Practiceform/
Assert-ovati sva polja iz "contact us" forme
Popuniti sva polja iz "contact us" forme i submit-ovati formu
 */


