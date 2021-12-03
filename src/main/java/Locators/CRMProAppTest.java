package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMProAppTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		
		By uname = By.name("username");
		By pwd = By.name("password");
		By lgnbtn = By.className("input-group-btn");
		
		doSendValues(uname, "groupautomation");
		doSendValues(pwd, "Test@12345");
		Thread.sleep(2000);
		doClick(lgnbtn);
		
		Thread.sleep(2000);
		By parentmenu = By.xpath("//li/a[contains(text(),'Contacts')]");
		By childmenu = By.xpath("//li/a[contains(text(),'New Contact')]");
		Thread.sleep(2000);
		moveToEle(parentmenu, childmenu);
		
		
		By fname = By.name("first_name");
		doSendValues(fname, "Test");
		
		By lname = By.name("surname");
		doSendValues(lname, "123");
		
		By img = By.name("image_file");
		doSendValues(img, "C:\\Users\\prital.choudhari\\Downloads\\banner.png");
		
		By statusdropdown = By.name("status");
		doSelectele(statusdropdown, "New");
		
		By address = By.name("address_title");
		doSendValues(address, "address");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendValues(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void moveToEle(By parent, By child) {
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).perform();
		act.moveToElement(getElement(child)).perform();
		getElement(child).click();
	}
	
	public static void doSelectele(By locator, String value) {
		Select sc = new Select(driver.findElement(locator));
		sc.selectByValue(value);
		
	}
	
}
