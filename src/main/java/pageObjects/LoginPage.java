package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	 By Email = By.xpath("//input[@id='Email']");
	 By Password = By.id("Password");
	 By Login1 = By.xpath("//input[@value='Log in']"); 

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(Email);
	}

	public WebElement getPassword() {

		return driver.findElement(Password);
	}

	public WebElement getLogin1() {

		return driver.findElement(Login1);
	}

}
