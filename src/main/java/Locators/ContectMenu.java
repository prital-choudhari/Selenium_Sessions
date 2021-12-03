package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContectMenu {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
//		WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
//		
//		Actions act = new Actions(driver);
//		act.contextClick(button).perform();
	
		
		By button = By.xpath("//span[text()='right click me']");
		By menu = By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span");
		
		ContextMenuClick(button, menu, "Copy");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void ContextMenuClick(By button, By menu, String value) throws InterruptedException {
		Actions act = new Actions(driver);
		
		act.contextClick(getElement(button)).perform();
		
		List<WebElement> menulist = driver.findElements(menu);
		
		for(WebElement e : menulist) {
			String text = e.getText();
			System.out.println(text);
			Thread.sleep(2000);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
