package Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		//wait in selenium : Synchronization
		//wait in selenium applied for webelement and non webelement also (non web element -> url, popup, alert, title)
		
		//Two types:
		//1. Static wait --> Thread.sleep(5000) -- will pause the whole script for 5 sec
		//2. Dynamic wait --> 10 sec --> if element is found within 4 sec (rest of the 6 sec will be ignored)
			//a. implicitly wait
			//b. explict wait --> WebDriverWait (c) --> FluentWait (c) --> Wait (I)
		
		
		//a. implicitly wait --> 
		//1. It is dynamic in nature 
		//2. It is only aplicable for web elements
		//3. It is a global wait --> applied with driver --> will be applicable for all the upcoming web elements
		//4. We never user implicitly wait due to performance issue
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement btnlogin = driver.findElement(By.xpath("//input[@value='Login']"));
		
		email.sendKeys("prital");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // This is override wait means next all elements wait will applied 5 sec
		password.sendKeys("123");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // This is called nullify of wait
		btnlogin.click();
		
	}

}
