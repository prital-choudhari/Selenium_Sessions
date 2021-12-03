package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorById {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		//Locators :
		//1. id
		
		//1st approch
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Prital");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Choudhari");
		
		//2nd approch
//		WebElement fname = driver.findElement(By.id("Form_submitForm_FirstName"));
//		WebElement lname = driver.findElement(By.id("Form_submitForm_LastName"));
//		
//		fname.sendKeys("Pri");
//		lname.sendKeys("ch");
		
		
		//3rd approch (By locator)
//		By fname = By.id("Form_submitForm_FirstName");
//		By lname = By.id("Form_submitForm_LastName");
//		
//		WebElement fn = driver.findElement(fname);
//		WebElement ln = driver.findElement(lname);
//		
//		fn.sendKeys("Prital");
//		ln.sendKeys("Choudhari");
		
		//4th approch (generic method)
//		By fname = By.id("Form_submitForm_FirstName");
//		By lname = By.id("Form_submitForm_LastName");
//		
//		getElement(fname).sendKeys("P");
//		getElement(lname).sendKeys("C");
		
		
		//5th approch 
		By fname = By.id("Form_submitForm_FirstName");
//		By lname = By.id("Form_submitForm_LastName");
//		
//		doSendkeys(fname, "Prital");
//		doSendkeys(lname, "Choudhari");
		
		
		//6th approch : Create a new elementutil class with generic methos
//		By fname = By.id("Form_submitForm_FirstName");
//		By lname = By.id("Form_submitForm_LastName");
		ElementUtil eu = new ElementUtil(driver);
//		eu.doSendkeys(fname, "Prital");
//		eu.doSendkeys(lname, "Choudhari");
		
		
		//2. Name
		
//		By fn = By.name("FirstName");
//		eu.doSendkeys(fn, "Prital"); 
		
		
		//3. ClassName
//		
//		By frn = By.className("text");
//		eu.doSendkeys(frn, "pri");
		
		//4. Link Text
		
//		By fn = By.linkText("OrangeHRM");
//		doClick(fn);
		
		
		//5. Partial link text
		
//		By fn = By.partialLinkText("CS");
//		doClick(fn);
		
		
		//6. Xpath
//		By fn = By.xpath("//*[@id=\"Form_submitForm_FirstName\"]");
//		doSendkeys(fn, "Prital");
		
		//7. CSS Selector
		
//		By fn = By.cssSelector("#Form_submitForm_FirstName");
//		doSendkeys(fn, "Roo");
		
		
		//8. TagName
		
//		By header = By.tagName("h2");
//		System.out.println(doGetText(header));
		
		
		//GetAttribute
//		By ltext = By.linkText("OrangeHRM");
//		String s = doGetAttribute(ltext, "href");
//		System.out.println(s);
		
		
		//isDisplayed
		
		By searchfiled = By.name("search");
		System.out.println(doisDisplayed(searchfiled));
		
		
//		boolean b = driver.findElement(By.name("search")).isDisplayed();
//		System.out.println(b);
		
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
//	
//	
	public static void doSendkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static String doGetAttribute(By locator, String ateName) {
		return getElement(locator).getAttribute(ateName);
	}
	
	
	public static boolean doisDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
}
