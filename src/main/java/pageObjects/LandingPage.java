package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By Login = By.xpath("//a[normalize-space()='Log in']");
	By Title = By.xpath("//img[@alt='Tricentis Demo Web Shop']");
	By NavBar = By.xpath("//div[@class='header-links-wrapper']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(Login);
	}

	public WebElement getTitle() {

		return driver.findElement(Title);
	}

	public WebElement getNavigationBar() {

		return driver.findElement(NavBar);
	}
}
