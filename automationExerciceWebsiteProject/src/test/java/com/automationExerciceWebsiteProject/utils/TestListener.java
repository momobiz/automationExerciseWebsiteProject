package com.automationExerciceWebsiteProject.utils;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationExerciceWebsiteProject.Page.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {

	public static ExtentReports extentReport = ExtentReportManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extentReport
				.createTest(result.getClass().getName() + "::" + result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String logMessage = "<b>Test method " + result.getMethod().getMethodName() + " succeed</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red> Exception occured, click on </font></b></summary>"
				+exceptionMessage.replaceAll(",","<br>")+"</details>\n");
		// importation du driver 
		WebDriver driver=BasePage.driver;
		String path=Screenshot.takeScreenshot(result.getMethod().getMethodName(), driver);
		try {
			extentTest.get().fail("<b><font color=red> Screenshot of the failure test</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String logMessage = "<b>Test method :" + result.getMethod().getMethodName() + " skipped</b>";
		Markup m = MarkupHelper.createLabel(logMessage, ExtentColor.AMBER);
		extentTest.get().log(Status.SKIP, m);

	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReport != null) {
			extentReport.flush();
		}

	}

}
