package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path="J:\\Softwares\\DemoE2E\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation test reports");
		reporter.config().setDocumentTitle("Test results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sanjay");
		return extent;
		
		
		
	}
	
	

}
