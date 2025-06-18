package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener{
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		sparkReporter.config().setDocumentTitle("PlanSource Automation Test Report");
		sparkReporter.config().setReportName("Plansource Fuctional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		//Populate common info
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "PlanSource");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Employee");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Operating Systems", "WIN11");
		extent.setSystemInfo("Browser", "Chrome");
		
	  }
		
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.PASS, result.getName()+" got successfully executed");
	  }
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL, result.getName()+" got failed");
	    test.log(Status.INFO, result.getThrowable().getMessage());
	    try {
	    	String imgPath = new BaseClass().captureScreen(result.getName());
	    	test.addScreenCaptureFromPath(imgPath);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	  }
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");//update the skipped test details
		test.log(Status.INFO, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext context) {
		extent.flush();//it will update all the details we have provided in report
		String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
	  }
	
	
	

}
