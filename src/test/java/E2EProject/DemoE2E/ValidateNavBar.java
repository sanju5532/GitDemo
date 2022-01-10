package E2EProject.DemoE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObject.LandingPage;

public class ValidateNavBar extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initializer() throws IOException, InterruptedException 
	{
		driver=initialiseBrowser();
		driver.get("http://qaclickacademy.com");
		log.info("Browser is initilised");
	}
	 @AfterTest
	 public void TearDown() 
	 {
		 driver.close();
		 log.info("Browser is closed");
		 
	 }
	
	
	@Test
	public void NavBarTitlevalidate() throws IOException, InterruptedException 
	{
		
		
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.Navigation().isDisplayed());
	
	
		
		
		
		
		
		
		
		
		
		
		
	}
	 
		
	
	
	
}
