package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;



public class SignupLoginPage extends BasePage {
	
	By newUserSignup=By.xpath("//h2[contains(text(),'New User Signup!')]");
	By name=By.xpath("//input[@type='text']");
	By email=By.xpath("//form[@action='/signup']//input[@type='email']");
	By signupButton=By.xpath("//button[contains(text(),'Signup')]");
	
	public EnterYourContactInformationPage signup(String userName, String userEmail) {
		fillInput(name, userName);
		fillInput(email, userEmail);
		clickOn(signupButton);

		return new EnterYourContactInformationPage();
	}
	
	public boolean newUserSignupIsVisible() {
		return isDisplayed(newUserSignup);
	}
	

}
