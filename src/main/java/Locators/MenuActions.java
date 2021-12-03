package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuActions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		
//		WebElement main = driver.findElement(By.className("menulink"));
		
//		Actions selMenu = new Actions(driver);
//		selMenu.moveToElement(main).perform();
//		
//		Thread.sleep(2000);
//		WebElement submenu = driver.findElement(By.linkText("COURSES"));
//		selMenu.moveToElement(submenu).perform();
//		submenu.click();
		
		By parentMenu = By.className("link");
		By childMenu1 = By.linkText("SpiceClub Members");
		By childMenu2 = By.linkText("Sign up");

		TwoMenumoveToEle(parentMenu, childMenu1, childMenu2);
		
	
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void TwoMenumoveToEle(By parentMenu, By childMenu1, By childMenu2) throws InterruptedException {
		Actions selMenu = new Actions(driver);

		selMenu.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		
		selMenu.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);
		
		selMenu.moveToElement(getElement(childMenu2)).perform();
		getElement(childMenu2).click();
	}
}
