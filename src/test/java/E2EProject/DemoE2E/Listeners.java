package E2EProject.DemoE2E;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportsNG;
import Resources.base;

public class Listeners extends base implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}
	public void onTestSkipped(ITestResult result)
    {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult result)
	 {
		// TODO Auto-generated method stub
	 extentTest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		
		String TestMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 extentTest.get().addScreenCaptureFromPath(GetScreenShot(TestMethodName,driver), TestMethodName);
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
      test=extent.createTest(result.getMethod().getMethodName());
      extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName= result.getMethod().getMethodName();
		 extentTest.get().log(Status.PASS, MethodName);
	}

}
