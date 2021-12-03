package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazoneFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		By footerlink = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");

//		ElementUtil eu = new ElementUtil(driver);
//		List<WebElement> footertest = eu.getElements(footerlink);
//		System.out.println(footertest.size());

		getLinkText(footerlink);

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void getLinkText(By locator) {
		List<WebElement> linktext = getElements(locator);
		System.out.println(linktext.size());
		for (WebElement e : linktext) {
			if (!linktext.isEmpty()) {
				System.out.println(e.getText());
			}

		}
	}
}
