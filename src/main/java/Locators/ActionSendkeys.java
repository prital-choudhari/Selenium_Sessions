package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSendkeys {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By tel = By.id("input-telephone");
		By pass = By.id("input-password");
		By cpass = By.id("input-confirm");
		By radiono = By.xpath("//div//label//input[contains(@value,'0')]");
		By checkagree = By.name("agree");
		By btncontinue = By.xpath("//input[contains(@class,'btn btn-primary')]");
		By msg = By.xpath("//div[@id='content']/h1");
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(fname),"Prital").perform();
		act.sendKeys(driver.findElement(lname), "Choudhari").perform();
		act.sendKeys(driver.findElement(email), "newtest3@gmail.com").perform();
		act.sendKeys(driver.findElement(tel), "1234567890").perform();
		act.sendKeys(driver.findElement(pass), "Test@123").perform();
		act.sendKeys(driver.findElement(cpass), "Test@123").perform();
		act.click(driver.findElement(radiono)).perform();
		act.click(driver.findElement(checkagree)).perform();
		act.click(driver.findElement(btncontinue)).perform();
		
		String header = driver.findElement(msg).getText();
		System.out.println(header);
		
		if(header.equals("Your Account Has Been Created!")) {
			System.out.println("DONE");
		}
	}

}
