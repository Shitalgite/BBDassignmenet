package FrameWork.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Baseclass;

public class Homepage extends Baseclass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Baseclass.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initalizeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		LandingPage l = new LandingPage(driver);

		l.getLogin().click();
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(Username);
		lg.getPassword().sendKeys(Password);

		log.info(text);
		lg.getLogin1().click();

	}

	@DataProvider
	public Object[][] getData() {
		// row1 how many different data types should run
		// column stands for how many values for each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestrictedsgite70@gmail.com";
		data[0][1] = "anitagite";
		data[0][2] = "Restricted User";
		// 1th rows
		data[1][0] = "Restrictedsgite70@gmail.com";
		data[1][1] = "12345";
		data[1][2] = "Non restricted User";
		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
