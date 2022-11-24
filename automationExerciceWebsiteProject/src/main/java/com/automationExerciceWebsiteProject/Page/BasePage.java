package com.automationExerciceWebsiteProject.Page;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BasePage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Logger logger=Logger.getLogger(BasePage.class.getName());
	public static Actions actions;
	public static JavascriptExecutor  js;
	public static Select select;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
	}
	public static WebElement findWebElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> findWebElements(By locator){
		return driver.findElements(locator);
		
	}
	public static void fillInput(By locator, String str) {
		 findWebElement(locator).clear();
		 findWebElement(locator).sendKeys(str);
		
		
	}
	
	public static void clickOn(By locator) {
		findWebElement(locator).click();
		
	}
	
	
	public static boolean isDisplayed(By locator) {
		wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(findWebElement(locator)));
			
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			return false;
		}
		
		return true;
	}
	public static void moveToWebElement(By locator) {
		actions=new Actions(driver);
		actions.moveToElement(findWebElement(locator)).build().perform();
	
		
	}
	public static void scrollDown(int pixelNumber) {
		js=(JavascriptExecutor) driver;
		js.executeScript("scroll(0,"+pixelNumber+")");
		
	}
	public static void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static void selectOption(By locator, String optionName) {
		select=new Select(findWebElement(locator));
		select.selectByValue(optionName);
		
		
	}
	public static void closeWindow() {
		driver.quit();
	}
	
	public static void selectGender(By locator, String genderValue) {
		List<WebElement> genders=findWebElements(locator);
		for(WebElement gender:genders) {
			if (gender.getAttribute("value").contentEquals(genderValue)) {
				gender.click();
			}
		}
		
	}
	public static void selectCheckbox(By locator,String[] options ) {
		List<WebElement> checkboxes=findWebElements(locator);
		for(WebElement checkbox : checkboxes) {
			for(String option:options) {
				if(checkbox.getAttribute("name").contentEquals(option)) {
				checkbox.click();
				}
			}
		}
		
	}
	public static String toCamelcase(String str) {
		String str1=str.toLowerCase();
	    return Character.toUpperCase(str1.charAt(0))+str1.substring(1);
		
	}
	

}
