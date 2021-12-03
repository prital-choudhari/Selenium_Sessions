package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		// Get the count of each link
		// Get the text of link

		By links = By.tagName("a");
		List<WebElement> linkslist = geElements(links);
		
		//List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		System.out.println("Total Links :" + linkslist.size());

		for (int i = 0; i < linkslist.size(); i++) {
			String linktext = linkslist.get(i).getText();
			if (!linktext.isEmpty()) {
				System.out.println(linktext);
			}
		}
	}
	
	public static List<WebElement> geElements(By locator) {
		return driver.findElements(locator);
	}

}
