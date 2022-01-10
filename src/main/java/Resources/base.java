package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class base {

	public WebDriver driver;
	WebDriver wait;

	@Test
	public WebDriver initialiseBrowser() throws IOException, InterruptedException {
		String path = System.getProperty("user.dir");

		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path + "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fs);

		//String BrowserName = System.getProperty("Browser");
		 String BrowserName= prop.getProperty("Browser");
		System.out.println(BrowserName);

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		} else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", path + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

		}

		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String GetScreenShot(String TestCaseName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dp = ("J:\\Softwares\\DemoE2E\\reports\\" + TestCaseName + ".png");
		try {
			FileUtils.copyFile(source, new File(dp));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dp;

	}
}