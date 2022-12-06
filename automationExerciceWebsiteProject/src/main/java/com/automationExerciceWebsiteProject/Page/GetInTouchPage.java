package com.automationExerciceWebsiteProject.Page;

import java.lang.module.FindException;

import org.openqa.selenium.By;

public class GetInTouchPage extends BasePage{
	
	By getInTouch= By.xpath("//h2[contains(text(),'Get In Touch')]");
	By name=By.xpath("//div[@class='form-group col-md-6']//input[@type='text']");
	By email=By.xpath("//div[@class='form-group col-md-6']//input[@type='email']");
	By subject=By.xpath("//div[@class='form-group col-md-12']//input[@type='text']");
	By yourMessage=By.xpath("//textarea[@id='message']");
	By uploadElement=By.xpath("//input[@type='file']");
	By submitButton=By.cssSelector("input.btn");
	By alertMessage=By.xpath("//div[@class='status alert alert-success']");
	By homeButton=By.cssSelector("a.btn");
	
	
	
	public String getInTouchMessage() {
		return findWebElement(getInTouch).getText();
	}
	public void fillInFormular(String username, String userEmail,String userSubject, String userMessage ) {
		fillInput(name, username);
		fillInput(email, userEmail);
		fillInput(subject, userSubject);
		fillInput(yourMessage, userMessage);
	}
	
	public void uploadFileInFormular(String filePath) {
		uploadFile(uploadElement, filePath);
	}
	public void submitFormular() {
		findWebElement(submitButton).click();
		
	}
	public String alertMessage() {
		return findWebElement(alertMessage).getText();
	}
	public void clickOnHomeBuuton() {
		clickOn(homeButton);
	}
	
	

}
