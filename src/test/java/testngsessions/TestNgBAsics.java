package testngsessions;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBAsics {

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is DB connection");
	}
	
	@BeforeTest
	public void beforTest() {
		System.out.println("This is before test");
	}
	
	@Test
	public void test() {
		System.out.println("This is test");
	}
}
