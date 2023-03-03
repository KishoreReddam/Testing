package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public By Checkout=By.xpath("//*[@id='checkout']");
	public By remove=By.xpath("//*[@id='remove-sauce-labs-bike-light']");
	public By Continue_Shopping=By.xpath("//*[@id='continue-shopping']");
	
	public By FirstName=By.xpath("//*[@id='first-name']");
	public By LastName=By.xpath("//*[@id='last-name']");
	public By Postcode=By.xpath("//*[@id='postal-code']");
	public By Continue=By.xpath("//*[@id='continue']");
	public By Finish=By.xpath("//*[@id='finish']");
	public By Message=By.xpath("//*[@id='checkout_complete_container']/h2");
	public By Menu=By.xpath("//*[@id='react-burger-menu-btn']");
	public By Logout=By.xpath("//*[@id='logout_sidebar_link']");
	public By Message2=By.xpath("//*[@id='login_credentials']/h4");
	
	public void Checkout(String firstName,String lastName,String postCode) throws InterruptedException
	{
		driver.findElement(Checkout).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(FirstName).sendKeys(firstName);
		driver.findElement(LastName).sendKeys(lastName);
		driver.findElement(Postcode).sendKeys(postCode);
		driver.findElement(Continue).click();
         Thread.sleep(3000);
         driver.findElement(Finish).click();
         Thread.sleep(3000);
         String msg=driver.findElement(Message).getText();
         System.out.print(msg);
         String expected ="Thank you for your order!";
 		Assert.assertEquals(msg, expected);
		
	}
	public void Logout() throws InterruptedException
	{
		driver.findElement(Menu).click();
        Thread.sleep(3000);
        driver.findElement(Logout).click();
        String msg2=driver.findElement(Message2).getText();
        System.out.print(msg2);
        String expected2 ="Accepted usernames are:";
		Assert.assertEquals(msg2, expected2);
		
	}
	
}
