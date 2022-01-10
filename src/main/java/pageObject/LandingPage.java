package pageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	public WebDriver driver;
	public Timeouts Wait;

	By signIN = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navTitle = By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]");
	By ClickPop = By.xpath("//button[contains(text(),'NO THANKS')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	// @SuppressWarnings("deprecation")
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement el =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(signIN));
	 */

	public WebElement GetTitle() {
		return driver.findElement(title);

	}

	public WebElement Navigation() {
		return driver.findElement(navTitle);

	}


	public LoginPage GetLogin() 
	
	{


		WebElement searchButton = driver.findElement(signIN);
		
		if(searchButton.isDisplayed()==true) 
		{

			searchButton.click();

		}

		else

		{
			Wait= driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			System.out.println(Wait.getImplicitWaitTimeout());
			
			//Wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ClickPop)));

			driver.findElement(ClickPop).click();
			
			searchButton.click();

		}

		LoginPage logp = new LoginPage(driver);
		return logp;

	}
}
