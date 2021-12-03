package Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		//2. Dynamic wait --> 10 sec --> if element is found within 4 sec (rest of the 6 sec will be ignored)
		//b. explict wait --> WebDriverWait (c) --> FluentWait (c) --> Wait (I)
		
		//1. it is also called custom wait --> you can define your own wait for a specific element
		//It is not a global wait
		// Can be applied for web elements and non web elements (non web elements means popup, title, url, alert)
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By email = By.name("email");
		By password = By.name("password");
		By lgnbtn = By.xpath("//input[@value='Login']");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys("Prital");
		
		WaitForElementPresence(email, 10).sendKeys("Prital");
		
		driver.findElement(password).sendKeys("123");
		driver.findElement(lgnbtn).click();
	
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public static WebElement WaitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
