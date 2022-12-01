package com.automationExerciceWebsiteProject.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String takeScreenshot(String methodName, WebDriver driver) {
		
		String filename=getScreenshotName(methodName);
		String directory=System.getProperty("user.dir")+"\\src\\target\\screnshots\\";
		new File(directory).mkdir();
		String path=directory+filename;
		
		try {
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,new File(path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	private static String getScreenshotName(String methodName) {
		
		Date d=new Date();
		String filename=methodName+d.toString().replace(":","_").replace(" ","_")+".png";
	
		
		return filename;
	}

}
