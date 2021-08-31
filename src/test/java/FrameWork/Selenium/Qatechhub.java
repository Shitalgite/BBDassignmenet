package FrameWork.Selenium;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Baseclass;

public class Qatechhub extends Baseclass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initalizeDriver();
		log.info("Driver is initalized");
		log.info("Navigated to Home Page");
	}

@Test
	public void method() {
		driver.navigate().to(prop.getProperty("url1"));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url2"));
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();

	}

   @Test
	public void myntraMethod() throws InterruptedException {

		driver.navigate().to(prop.getProperty("url4"));

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.cssSelector(prop.getProperty("women")))).build().perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath(prop.getProperty("dresses"))).click();

		a.moveToElement(driver.findElement(By.cssSelector(".sort-sortBy"))).build().perform();

		driver.findElement(By.xpath("//label[normalize-space()=\"What's New\"]")).click();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 3000);
		 * 
		 * if (wait.until(ExpectedConditions.alertIsPresent()) == null)
		 */
			//driver.switchTo().alert().accept();

		/*
		 * else { System.out.println("alert was present"); }
		 */
		
		String s1 = driver.findElement(By.xpath("//div[5]//ul[1]//li[2]//label[1]")).getText();

		System.out.println(s1.replaceAll("[0-9()]", ""));

		driver.findElement(By.xpath("//div[5]//ul[1]//li[2]//label[1]")).click();

		String s2 = driver.findElement(By.xpath("//span[normalize-space()='Blue']")).getText();

		System.out.println(s2);

		if (s1 == s2) {

			Assert.assertTrue(true);

		} else {
			Assert.assertFalse(false);

		}

		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='results-base']"));
         Thread.sleep(4000);
		//WebElement ele= driver.findElement(By.xpath(prop.getProperty("dress")));
		driver.findElement(By.xpath(prop.getProperty("dress"))).click();
		
		//System.out.println(ele);

		
		  //for (int i = 0; i < products.size(); i++) {
		  
		 //String name = products.get(i).getText();
		  
		// if (name.contains("Porsorte")) {
			 
		 }
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}