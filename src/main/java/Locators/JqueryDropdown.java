package Locators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropdown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox1")).click();
		Thread.sleep(2000);

//		List<WebElement> op = driver.findElements(By.cssSelector(".comboTreeItemTitle"));
//		for (WebElement e : op) {
//			String s = e.getText();
//			if(s.equals("choice 2")) {
//			e.click();
//		}

		By choice = By.cssSelector(".comboTreeItemTitle");

		// TC01
		// selectEle(choice, "choice 2");

		// TC02

//		ArrayList<String> ch = new ArrayList<String>();
//		ch.add("choice 2");
//		ch.add("choice 5");
//		ch.add("choice 7");

		selectEle(choice, "choice 2","choice 5","choice 7");

		// TC03
		//selectEle(choice, "all");
	}

	// public static void selectOption(By locator, ArrayList<String> ch) throws
	// InterruptedException {

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