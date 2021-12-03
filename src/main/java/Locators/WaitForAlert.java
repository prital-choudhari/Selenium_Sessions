package Locators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//driver.findElement(By.name("proceed")).click();
	
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		if(wait.until(ExpectedConditions.titleContains("Login"))){
//			System.out.println(driver.getTitle());
//		}
		
	
		String title = waitTogetExactPageTitle(5, "Account Login");
		System.out.println(title);
	}
	

	public static String waitTogetPageTitle(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		if(wait.until(ExpectedConditions.titleContains(value))){
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitTogetExactPageTitle(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		if(wait.until(ExpectedConditions.titleIs(value))){
			return driver.getTitle();
		}
		return null;
	}
	
	
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}

	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	public static void sendKeysToAlert(int timeout, String value) {
		waitForAlert(timeout).sendKeys(value);
	}
}
