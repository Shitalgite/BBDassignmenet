import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadfromdesktop {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumTestingProgram\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.xpath("//span[@class='g-form-group-title--desktop']")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("D:\\1903.exe");
	}

}
