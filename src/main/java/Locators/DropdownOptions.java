package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choice = By.cssSelector(".comboTreeItemTitle");
		selectEle(choice, "all");

	}

	public static void selectEle(By locator, String... value) {
		List<WebElement> options = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement o : options) {
				String text = o.getText();
				System.out.println(text);
				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						o.click();
						break;
					}

				}
			}
		} else {
			try {

				for (WebElement o : options) {
					o.click();
				}
			} catch (Exception e) {
			}
		}
	}
}
