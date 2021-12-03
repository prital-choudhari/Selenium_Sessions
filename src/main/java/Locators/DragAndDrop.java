package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

//		WebElement s = driver.findElement(By.id("draggable"));
//		WebElement t = driver.findElement(By.id("droppable"));

//		Actions act = new Actions(driver);
//		act.clickAndHold(s).moveToElement(s).release(t).build().perform();

		By s = By.id("draggable");
		By t = By.id("droppable");
		Thread.sleep(2000);
		dragAndDrop(s, t);	

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void dragAndDrop(By source, By target) {
		Actions act = new Actions(driver);
		act.clickAndHold(getElement(source)).moveToElement(getElement(source)).release(getElement(target)).build().perform();
	}
}