package com.crm.Vtiger.genericsUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class  Listeners implements ITestListener {
	ExtentReports reports;//attach the report
	ExtentTest test;//to make entries of test cases and logs

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is Failed");
		BaseClass baseClass=new BaseClass();
		try {
			String path =baseClass.getScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is Skiiped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter reporter =new ExtentHtmlReporter(System.getProperty("user.dir")
				+"/ExtentReportsSDET21/ExtentReports1.html");
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Testing");
		reports.setSystemInfo("Platform", "windows");
		reports.setSystemInfo("Browser", "chrome-92");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
		
	}
	 
	}

	
	
	
	


