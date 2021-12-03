package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandlingex1 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(2000);
		
		selectDate("March 2022", "25");
		
	}

	public static void selectDate(String ExptMonthAndYear, String day) {
		String currentmonth = driver.findElement(By.xpath("//div[@role='heading']")).getText();
		
		while(!currentmonth.equals(ExptMonthAndYear)) {
			driver.findElement(By.xpath("//span[@role='button'][2]")).click();
			currentmonth = driver.findElement(By.xpath("//div[@role='heading']")).getText();
		}
		
		driver.findElement(By.xpath("//div[@class='calDate' and text()='"+day+"']")).click();
		System.out.println(currentmonth + day);
		
	}
	
}
