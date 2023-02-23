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
	By Checkout=By.xpath("//*[@id='checkout']");
	By remove=By.xpath("//*[@id='remove-sauce-labs-bike-light']");
	By Continue_Shopping=By.xpath("//*[@id='continue-shopping']");
	
	By FirstName=By.xpath("//*[@id='first-name']");
	By LastName=By.xpath("//*[@id='last-name']");
	By Postcode=By.xpath("//*[@id='postal-code']");
	By Continue=By.xpath("//*[@id='continue']");
	By Finish=By.xpath("//*[@id='finish']");
	By Message=By.xpath("//*[@id='checkout_complete_container']/h2");
	
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
         String expected ="THANK YOU FOR YOUR ORDER";
 		Assert.assertEquals(msg, expected);
		
	}

}
