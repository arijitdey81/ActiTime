package in.amazon.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	@BeforeTest
	public void openBrowser(){
		Reporter.log("OpenBrowser",true);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser(){
		Reporter.log("CloseBrowser",true);
	}
	@BeforeMethod
	public void login() {
		Reporter.log("Login",true);
	}
	@AfterMethod
	public void logout() {
		Reporter.log("Logout",true);
	}

}
