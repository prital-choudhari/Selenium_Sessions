package Locators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By dropdown = By.id("Form_submitForm_Industry");

		Select op = new Select(driver.findElement(By.id("Form_submitForm_Industry")));
//		List<WebElement> indoption = op.getOptions();
//		System.out.println(indoption.size());
//		
//		for(WebElement e : indoption) {
//			System.out.println(e.getText());
//		}

		doGetDropdownOptions(dropdown);
		SelectDropdownOptions(dropdown, "Agriculture / Forestry");

		// doSelectByIndex(ind, 5);
		// doSelectByValue(ind, "Education");
		// doSelectByVisibleText(ind, "Computer / Technology - Services / Consultancy");

		// Select op = new Select(driver.findElement(ind));
		// op.selectByIndex(4);
		// op.selectByValue("Automotive");
		// op.selectByVisibleText("Computer / Technology - Manufacturer");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void doSelectByIndex(By locator, int value) {
		Select op = new Select(driver.findElement(locator));
		op.selectByIndex(value);
	}

	public static void doSelectByValue(By locator, String value) {
		Select op = new Select(driver.findElement(locator));
		op.selectByValue(value);
	}

	public static void doSelectByVisibleText(By locator, String value) {
		Select op = new Select(driver.findElement(locator));
		op.selectByVisibleText(value);
	}

	public static void doGetDropdownOptions(By locator) {
		Select op = new Select(getElement(locator));
		List<WebElement> options = op.getOptions();
		System.out.println(options.size());

		for (WebElement e : options) {
			System.out.println(e.getText());
		}
	}

	public static void SelectDropdownOptions(By locator, String value) {
		Select op = new Select(getElement(locator));
		List<WebElement> options = op.getOptions();

		for (WebElement e : options) {
			String text = e.getText();

			if (text.equals(value)) {
				e.click();
				System.out.println("Following option Selected :" + value);
				break;
			}

		}
	}

}
