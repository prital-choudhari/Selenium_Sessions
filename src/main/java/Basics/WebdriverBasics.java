package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebdriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		String s = driver.getTitle();
		System.out.println("Page Title is : "+s);
		
		if(s.equals("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		driver.close();
		
		System.out.println(driver.getTitle());
	}

}
