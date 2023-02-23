package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	By Product1_add=By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
	By Product2_add=By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
	By cart=By.xpath("//*[@id='shopping_cart_container']/a");
	
	public void AddingItems()
	{
		driver.findElement(Product1_add).click();
		driver.findElement(Product2_add).click();
		driver.findElement(cart).click();
	}


}
