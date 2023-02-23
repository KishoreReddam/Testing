package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By username=By.xpath("//*[@id='user-name']");
	By password=By.xpath("//*[@id='password']");
	By login=By.xpath("//*[@id='login-button']");
	By errormsg=By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
	
	public void signin(String User,String pwd)
	{
		driver.findElement(username).sendKeys(User);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		
		
	}
	
	public void validate_error_msg() {
		String msg=driver.findElement(errormsg).getText();
		System.out.print(msg);
		String expected ="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(msg, expected);
	}

}
