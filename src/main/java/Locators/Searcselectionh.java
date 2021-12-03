package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Searcselectionh {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.name("search_query")).sendKeys("dress");
		Thread.sleep(2000);
		List<WebElement>search = driver.findElements(By.xpath("//ul/li"));
		
		for(WebElement e : search) {
			String s = e.getText();
			//System.out.println(s);
			if(s.equals("Summer Dresses > Printed Chiffon Dress")) {
				e.click();
				break;
			}
		}

	}

}
