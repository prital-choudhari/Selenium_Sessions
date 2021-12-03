package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLangLink {
	static WebDriver driver;

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		
		By langlinks = By.xpath("//div[@id='SIvCob']/a");
		
		List<WebElement> langlist = driver.findElements(langlinks);
		System.out.println(langlist.size());
		
//		for(WebElement e : langlist) {
//			String linktext = e.getText();
//			System.out.println(linktext);
//			
//			if(linktext.equals("मराठी")) {
//				e.click();
//				break;
//			}
//			
//		}
	}
}
		
	ClickOnElement(langlinks, "मराठी");

	public static List<WebElement> getElements(By locator) {
		return driver.findElement(locator);
	}
	
	public static void ClickOnElement(By locator, String value) {
		List<WebElement> elelist = getElements(locator);
		System.out.println(elelist.size());
		
		for(WebElement e : elelist) {
			String eletext = e.getText();
			System.out.println(eletext);
			
			if(eletext.equals(value)) {
				e.click();
				break;
			}
		}
		
	}
}
