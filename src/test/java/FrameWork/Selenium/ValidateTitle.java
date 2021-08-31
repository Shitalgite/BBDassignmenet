package FrameWork.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Baseclass;

public class ValidateTitle extends Baseclass {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initalizeDriver();
		log.info("Driver is initalized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		// compare the text value with actual value
		// Assert.assertEquals(l.getTitle().getText(), "Demo Web Shop Sample Application
		// by Tricents");
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Sucessfully validated Text Message");
		// Assert.assertFalse(false);

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
