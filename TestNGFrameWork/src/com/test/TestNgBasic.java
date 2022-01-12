package com.test;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestNgBasic {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmajeed\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://justdelivery.it/index.php/admin_007/admin/index/index/key/fdde49313e7a27b837725e04c92ab5622292f578fc2359cb969aca40b9f49c35/");
	
	}
	

	@Test(priority = 1, groups = "Login")
	public void loginAdmin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin.justdelivery");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("oC9cU#EJ1UcSZ$pA");

		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[3]/div[1]/button")).click();
		Thread.sleep(1000);				

	}
	@Test(priority = 2, groups ="Login")
	public void openMenu() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-magento-customer-customer\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"menu-magento-customer-customer\"]/div/ul/li[1]/a")).click();
	}
	@AfterClass
	public void closeBrowser() {
		
	}

	

}
