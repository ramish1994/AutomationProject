package com.test;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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
		driver.get("https://securehealthcms.qa.greenlightlabs.tech/sitecore/shell/Applications/Content%20Editor.aspx?sc_bw=1");
	
	}
	
	@Test
	public void checkTitle() {
		System.out.println("Check title");
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void loginAdmin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("b");

		driver.findElement(By.xpath("//*[@id=\"LogInBtn\"]")).click();
		Thread.sleep(1000);
						
		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/div/div/div[1]/div[2]/div[1]/a[1]/span[1]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a//span[contains(text(),'Home')]")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Title - Please enter title of the item here:']/..//input")).sendKeys("Ramish");
		Thread.sleep(5000);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	

}
