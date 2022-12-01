package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;



public class SignupLoginPage extends BasePage {
	
	// Elements for registration
	By newUserSignup=By.xpath("//h2[contains(text(),'New User Signup!')]");
	By name=By.xpath("//input[@type='text']");
	By email=By.xpath("//form[@action='/signup']//input[@type='email']");
	By signupButton=By.xpath("//button[contains(text(),'Signup')]");
	By loginToYourAccountText=By.xpath("//h2[contains(text(),'Login to your account')]");
	
	//Elements for Login
	By loginEmail=By.xpath("//form[@action='/login']//input[@type='email']");
	By loginPassword=By.xpath("//input[@type='password']");
	By loginButton=By.xpath("//button[contains(text(),'Login')]");
	
	// Elements for login with invalid credentials
	By invalidCredentialAlert=By.xpath("//p[@style='color: red;']");
	
	public EnterYourContactInformationPage signup(String userName, String userEmail) {
		fillInput(name, userName);
		fillInput(email, userEmail);
		clickOn(signupButton);

		return new EnterYourContactInformationPage();
	}
	
	public boolean newUserSignupIsVisible() {
		return isDisplayed(newUserSignup);
	}
	public boolean loginToYourAccountIsVisible() {
		return isDisplayed(loginToYourAccountText);
	}
	
	public UserHomePage loginValid(String email, String password) {
		fillInput(loginEmail, email);
		fillInput(loginPassword, password);
		clickOn(loginButton);
		return new UserHomePage();
	}
	public void loginInvalid(String email, String password) {
		fillInput(loginEmail, email);
		fillInput(loginPassword, password);
		clickOn(loginButton);
		
	}
	
	public String returnAlertMessage() {
		return findWebElement(invalidCredentialAlert).getText();
	}
	

}
