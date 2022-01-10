package E2EProject.DemoE2E;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExampleDemo {
	
	@Test
	void startPage() {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",path +"\\Drivers\\geckodriver.exe");  
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("--headless");
		WebDriver driver=new FirefoxDriver(option);
		/*System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless");
		WebDriver driver = new ChromeDriver(option);*/

		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'NO THANKS')]"))); 
     driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
     driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	 System.out.println(System.getProperty("user.dir"));
	
	}
}
