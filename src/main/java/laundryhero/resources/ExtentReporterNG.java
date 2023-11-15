package laundryhero.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports giveReportObject()
	{
		//ExtentSparkReporter
		String path = System.getProperty("user.dir")+ "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web App Automation Test Report");
		reporter.config().setDocumentTitle("Laundry Hero");
		
		//ExtentReports
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SQA", "Attique Sadeeque");
		//extent.createTest("testname"); //this will add the results of the test in the report it should be called at the start of each test
		return extent;
	}
}
