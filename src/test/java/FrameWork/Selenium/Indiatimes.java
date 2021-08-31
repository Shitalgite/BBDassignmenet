package FrameWork.Selenium;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Baseclass;

public class Indiatimes extends Baseclass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initalizeDriver();
		log.info("Driver is initalized");
		log.info("Navigated to Home Page");

	}

	// @Test
	public void header() {
		driver.navigate().to(prop.getProperty("url3"));

		List<WebElement> element = driver.findElements(By.xpath("//div[@id='sectiontrending']"));
		for (int i = 0; i < element.size(); i++) {
			String name = element.get(i).getText();

			System.out.println(name);
		}
	}

//
	@Test
	public void footer() throws InterruptedException {
		Actions a=new Actions(driver);
		driver.navigate().to(prop.getProperty("url3"));
        driver.findElements(By.tagName("a"));// links from footer
		WebElement maindriver = driver.findElement(By.xpath("//footer[@class='fluid-width']//div[7]"));
		System.out.println(maindriver.findElements(By.tagName("a")).size());
		System.out.println(maindriver.getText());
		//Printing News from Trending
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Trending"))).click();
		
		Thread.sleep(5000);
		List<WebElement> element1 = driver.findElements(By.xpath(prop.getProperty("ListofTrendingnews")));
		for (int i = 0; i < element1.size(); i++) {
			String elementText = element1.get(i).getText();
			System.out.println(elementText);
			
			
			driver.navigate().back();
			driver.navigate().refresh();
			
			Thread.sleep(5000);
			//Printing News froms IPL
		   driver.findElement(By.xpath(prop.getProperty("IPL21"))).click();
			List<WebElement> element2 = driver.findElements(By.xpath(prop.getProperty("IPLNews")));
			for (int j = 0; j < element2.size(); j++) {
				String elementText1 = element2.get(i).getText();
				System.out.println(elementText1);

			}
		}

		//

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}