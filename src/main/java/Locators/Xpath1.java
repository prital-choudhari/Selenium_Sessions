package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath1 {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//xpath --> Address of the element in HTML DOM
		
		//1. absolute xpath --> /html/body/div/div[3]/dev[4]/ui/li
		//2. relative xpath (custom) --> by using html tag and attribute  + functions + xpath axes
		
		//Formula for 1 attribute --> //htmltag[@attribute = 'value']
	
		//input[@id='input-email']
		
		//Formula for 2 attribute --> 
		
		//1. //input[@id='input-email' and @name='email'] 
		//2. //input[@id='input-email' or @name='email']
		
		//We can write it in below format as well
		//input[@id=\"input-email\"]
		
		
		//Indexing in xpath
		//1. (//input[@class='form-control'])[1] --> Stored in capture group then applied indexing
		//2. (//input[@class='form-control'])[position()=2]
		//3. (//input[@class='form-control'])[last()] --> This will always point to last element
		//4. (//div[@class='col-sm-3']//a)[position()=last()]
		
		
		//xpath with text() --> Text is not an attribute
		//1. //a[text()='Login']
		
		
		//contains in xpath
		// htmltag[contains(@attribute,'value')]
		
		
		//contains with one attribute and second attribute without contains
		// htmltag[contains(@attribute,'value') and @attribute2='value']
		//input[contains(@name,'Contact') and @class='text']
		
		
		//Starts-with
		//h2[starts-with(text(),'Refreshing')]
		//input[starts-with(@id,'Form_submitForm_JobTitle')]
		
		//*[@type='text'] --> it will check all the elements in DOM
		//input[@type=''text] --> it will check elements which is having input tag so this is preferable approch
		
		String xpath1 = "//input[@name='email']";
		//String xpath2 = "//input[@id='input-email']";
		
		By email = getBy("xpath", xpath1);
		getElement(email).sendKeys("Prital");
		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			 locator = By.id(locatorValue);
			break;
			
		case "name":
			 locator = By.name(locatorValue);
			break;
			
		case "className":
			 locator = By.className(locatorValue);
			break;
			
		case "linkText":
			 locator = By.linkText(locatorValue);
			break;
			
		case "partialLinkText":
			 locator = By.partialLinkText(locatorValue);
			break;
			
		case "tagName":
			 locator = By.tagName(locatorValue);
			break;
			
		case "xpath":
			 locator = By.xpath(locatorValue);
			break;
			
		case "cssSelector":
			 locator = By.cssSelector(locatorValue);
			break;

		default:
			break;
		}
		
		return locator;
	}
}
