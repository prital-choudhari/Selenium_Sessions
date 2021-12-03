package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintWebTable {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

//		// Company xpath = //table[@id="customers"]/tbody/tr[2]/td[1]
//		// Contact xpath = //table[@id="customers"]/tbody/tr[2]/td[2]
//
//		String beforexpath = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterxpath = "]/td[1]";
//
//		for (int i = 2; i <= 7; i++) {
//			String xpath = beforexpath + i + afterxpath;
//			String comname = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(comname);
//		}
//		
//		String beforexpath1 = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterxpath1 = "]/td[2]";
//		for (int j = 2; j <= 7; j++) {
//			String xpath = beforexpath1 + j + afterxpath1;
//			String contact = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(contact);
//		}
//		
//		
//		//table[@id="customers"]/tbody/tr[2]/td[3]
//		
//		String beforexpath2 = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterxpath2 = "]/td[3]";
//		for (int k = 2; k <= 7; k++) {
//			String xpath = beforexpath2 + k + afterxpath2;
//			String country = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(country);
//		}
		
		
	

		
		for (int k = 2; k <= 7; k++) {
			for (int i=1;i<=3;i++) {
				String beforexpath = "//table[@id=\"customers\"]/tbody/tr[";
				String afterxpath = "]/td["+i+"]";
				String xpath = beforexpath + k + afterxpath;
				String table = driver.findElement(By.xpath(xpath)).getText();
				System.out.println(table);
			}
			System.out.println("------------------------------");
		}
		
	}

}
