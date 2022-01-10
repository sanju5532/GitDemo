package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword 
{
	WebDriver driver;
     
	By Email = By.xpath("//input[@id='user_email']");
	By Submit=By.xpath("//input[@type='submit']");
	
	ForgotPassword(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	public WebElement EmailLogin()
	{
		
		return driver.findElement(Email);
		
		
	}
	public WebElement submitbutton()
	{
		
		return driver.findElement(Submit);
		
		
	}
	
	

}
