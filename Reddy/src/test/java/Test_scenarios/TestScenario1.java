package Test_scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.CheckoutPage;
import Objects.HomePage;
import Objects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario1 {
	
	WebDriver driver;
	
	
	
	
	@BeforeTest
	public void  abeforetest() {
		WebDriverManager.chromedriver().setup();
	//	WebDriverManager.chromedriver().version("78.0.3904.108").setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@BeforeMethod
	public void  launch() {
		
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void ValidCheckout() throws InterruptedException {
		LoginPage obj1=new LoginPage(driver);
		HomePage obj2=new HomePage(driver);
		CheckoutPage obj3=new CheckoutPage(driver);
	obj1.signin("standard_user", "secret_sauce");
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	obj2.AddingItems();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	obj3.Checkout("Kishore", "Reddy", "TS14NB");
	
	obj3.Logout();
	}
	
	@Test(priority=2)
	public void inValidlogin() throws InterruptedException {
	LoginPage obj4=new LoginPage(driver);	
	obj4.signin("standard", "secret");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	obj4.validate_error_msg();
	
	driver.close();
	}
	
	

}
