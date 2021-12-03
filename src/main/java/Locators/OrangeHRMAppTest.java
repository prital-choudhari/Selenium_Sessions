package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMAppTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		WebDriver wb = bu.launchBrowser("chrome");
		bu.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(bu.getPageTitle());
		
		By fname = By.id("Form_submitForm_FirstName");
		By lname = By.id("Form_submitForm_LastName");
		ElementUtil eu = new ElementUtil(wb);
		eu.doSendkeys(fname, "Prital");
		eu.doSendkeys(lname, "Choudhari");
		bu.closeBrowser();
		
	}

}
