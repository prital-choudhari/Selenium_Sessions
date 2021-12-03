package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWetableXpath {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("ppatil");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//xpath: //a[text()='ab1 ab1']//parent::td//preceding-sibling::td/input[@type='checkbox']
		
		getElement("dell new");
		clickCheckbox("dell new");
	}
	
	public static void getElement(String value) {
		String chekbox = "//a[text()='"+value+"']//parent::td//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(chekbox)).click();
	}

	public static void clickCheckbox(String name) {
		List<WebElement> details = driver.findElements(By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td"));
		int count = 0;
		for(WebElement e : details) {
			if(count==5) {
				break;
			}
			else {
				String alldetails = e.getText();
				System.out.println(alldetails);
				count++;
			}
			
		}
		
	}
}
