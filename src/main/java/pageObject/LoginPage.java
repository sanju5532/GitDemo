package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
     public WebDriver driver;
     public WebDriverWait wait;
     
     By Email = By.xpath("//input[@type='email']");
     By Password = By.xpath("//input[@type='password']");
     By clickLogin=By.xpath("//input[@value='Log In']");
     By ForgotPassword= By.xpath("//a[@class='link-below-button']");	
   
     public LoginPage(WebDriver driver)
     {
	  this.driver=driver;
    	 
	 }

	
   

	public WebElement enterPassword() 
     {
    	return driver.findElement(Password);	 
    	 
     }

	public ForgotPassword loginClick() 
     {
		
			 wait = new WebDriverWait(driver, 10);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(clickLogin));
			System.out.println(element);
    	driver.findElement(clickLogin).click(); 
    	driver.findElement(ForgotPassword).click();
		ForgotPassword Fp= new ForgotPassword(driver);
		return Fp;
     }

	public WebElement enterEmail() 
		
		  {
		    	return driver.findElement(Email);
		    	 
		    	 
		     }
	
	
	
	}

	
	
	
	
