package Locators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveScoreXpath {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/world-cup-league-2-2019-2021-22-1196667/oman-vs-united-states-of-america-39th-match-1275251/full-scorecard");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		System.out.println(getPlayerDetails("Ayan Khan"));
	}

	public static List<String> getPlayerDetails(String name) {
		List<WebElement> details = driver.findElements(By
				.xpath("//table[@class='table batsman']//a[text()='" + name + "']//parent::td//following-sibling::td"));

		List<String> scoreDetails = new ArrayList<String>();

		for (WebElement e : details) {
			String alldetails = e.getText();
			// scoreDetails.add(alldetails);
			// scoreDetails.removeAll(Collections.singleton(""));

			if (!alldetails.isEmpty()) {
				scoreDetails.add(alldetails);
			}
		}
		return scoreDetails;
	}
}
