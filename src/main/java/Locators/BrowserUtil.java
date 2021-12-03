package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This utility is having different menthods for different browser actions
 * @author prital.choudhari
 *
 */
public class BrowserUtil {  
	
	public WebDriver driver;
	
	/**
	 * This returns webdriver referance
	 * @param browsername
	 * @return
	 */
	
	public WebDriver launchBrowser(String browsername) {
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		}
		else {
			System.out.println("Please pass correct browser");
		}
		
		return driver;
	}

	
	public void launchUrl(String url) {
		if(url==null) {
			return;
		}
		
		if(url.isEmpty()) {
			return;
		}
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quiteBrowser() {
		driver.quit();
	}
}
