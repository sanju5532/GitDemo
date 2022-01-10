package E2EProject.DemoE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends base {
	WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Initializer() throws IOException, InterruptedException 
	{
		driver=initialiseBrowser();
	
		
	}
	 @AfterTest
	 public void TearDown() 
	 {
		 driver.close();
		 
	 }
	 @DataProvider
	 public Object[][] getData()
	 {
		 Object[][] data = new Object[2][3];
		//[3] represents number of data 
	    //[2]represents set of data
		 data[0][0]="sanju@qa.com";
		 data[0][1]="12345";
		 data[0][2]="sanju@qa.com";
		 
		 data[1][0]="sanjaykumar@qa.com";
		 data[1][1]="abcde";
		 data[1][2]="sanjaykumar@qa.com";
		 return data;
		 
	 }

	
	@Test(dataProvider="getData")
	public void basePageNav(String username,String password,String name) throws IOException, InterruptedException 
	{
		driver.get("http://qaclickacademy.com");
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		LandingPage lp=new LandingPage(driver);
		// LoginPage logp is returned from landing page
		//Thread.sleep(1000);
		LoginPage logp=lp.GetLogin();
		
		logp.enterEmail().sendKeys(username);
		logp.enterPassword().sendKeys(password);
		Thread.sleep(3000);
		ForgotPassword Fp=logp.loginClick();
		log.info("Data is validated");
		Fp.EmailLogin().sendKeys(name);
		Fp.submitbutton().click();
	
	}
	 
	
	
}
