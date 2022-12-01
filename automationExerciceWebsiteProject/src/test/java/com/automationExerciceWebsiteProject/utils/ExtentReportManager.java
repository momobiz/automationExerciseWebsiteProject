package com.automationExerciceWebsiteProject.utils;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {
	
	public static ExtentReports createInstance() {
		
		String reportName=getReportName();
		String directory=System.getProperty("user.dir")+"\\src\\target\\reports\\";
		new File(directory).mkdir();
		String path=directory+reportName;
		
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setCSS(".r-img{width:10%}");
		
		ExtentReports extentReport=new ExtentReports();
		extentReport.setSystemInfo("Automation Test for : ", "https://automationexercise.com/");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("By :", "ANNABI");
		extentReport.attachReporter(htmlReporter);
		
		return extentReport;
	}
	
	private static String getReportName() {
		Date d=new Date();
		String fileName="Automation_report_"+d.toString().replace(":","_").replace(" ","_")+".html";
		return fileName;
		
	}

}
