package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
		Select sc = new Select(driver.findElement(By.xpath("//select[@id=\"files\"]")));
		List<WebElement> s = sc.getOptions();
		  //driver.findElements(By.xpath("//option[@value=\"jqueryui\" or @value=\"jquery\"]"));
		
		for(WebElement e : s) {
			System.out.println(e.getText());
		}
		

	}

}
