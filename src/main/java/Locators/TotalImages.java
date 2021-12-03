package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		By images = By.tagName("img");
		
		List<WebElement> imageslist = geElements(images);
		System.out.println(imageslist.size());
		
//		for(int i=0; i<imageslist.size(); i++) {
//			String altValue = imageslist.get(i).getAttribute("alt");
//			String srcValue = imageslist.get(i).getAttribute("src");
//			System.out.println(altValue+"-->"+srcValue);
//		}
		
		for(WebElement e : imageslist) {
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");
			System.out.println(altValue+"-->"+srcValue);
		}
	}

	public static List<WebElement> geElements(By locator) {
		return driver.findElements(locator);
	}
}
