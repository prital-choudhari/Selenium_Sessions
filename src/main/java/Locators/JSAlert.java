package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlert {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		String s = driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("login1")).sendKeys("Test");
	}

}
