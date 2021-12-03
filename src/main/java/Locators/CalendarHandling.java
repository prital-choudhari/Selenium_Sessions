package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {
	static WebDriver driver;
	
	public static void selectDate(String ExptMonthAndYear, String day) {
		String currentmonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		
		while(!currentmonth.equals(ExptMonthAndYear)) {
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			currentmonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}
		
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000);
		
		selectDate("March 2021", "25");
//		driver.findElement(By.xpath("//a[text()='4']")).click();
//		
//		List<WebElement> days = driver.findElements(By.cssSelector(".ui-datepicker-calendar a"));
//		
//		for(WebElement e : days) {
//			if(e.getText().equals("25")) {
//				e.click();
//				break;
//			}
//		}
	}

}
