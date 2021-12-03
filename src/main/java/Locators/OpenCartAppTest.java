package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartAppTest {

	public static void main(String[] args) {
		BrowserUtil bu = new BrowserUtil();
		WebDriver wb = bu.launchBrowser("chrome");
		bu.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By tel = By.id("input-telephone");
		By pass = By.id("input-password");
		By cpass = By.id("input-confirm");
		
		
		ElementUtil eu = new ElementUtil(wb);
		eu.doSendkeys(fname, "Prital");
		eu.doSendkeys(lname, "Choudhari");
		eu.doSendkeys(email, "p@gmail.com");
		eu.doSendkeys(tel, "123");
		eu.doSendkeys(pass, "123");
		eu.doSendkeys(cpass, "123");
		
		bu.closeBrowser();

	}

}
