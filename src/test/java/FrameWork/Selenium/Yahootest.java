package FrameWork.Selenium;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Baseclass;

public class Yahootest extends Baseclass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());

	@Test
	public void initialize() throws IOException, InterruptedException {
		driver = initalizeDriver();
		driver.get(prop.getProperty("url4"));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector(prop.getProperty("women")))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("dresses"))).click();
		a.moveToElement(driver.findElement(By.cssSelector(".sort-sortBy"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()=\"What's New\"]")).click();
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
		List<WebElement> products = driver.findElements(
				By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]"));
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			if (name.contains("Porsorte")) {
				driver.findElement(By.xpath("//h3[contains(text(),'Porsorte')]")).click();
			}
		}
		Thread.sleep(3000);
		// *[@id="desktopSearchResults"]/div[2]/section/ul/li[1]/a/div[2]/h3

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
