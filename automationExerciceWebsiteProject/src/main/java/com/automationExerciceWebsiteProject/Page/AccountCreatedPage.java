package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;



public class AccountCreatedPage extends BasePage{


	By accountCreated=By.xpath("//b[contains(text(),'Account Created!')]");
	By continueButton=By.xpath("//a[@class='btn btn-primary']");
	
	
	
	public boolean accountCreatedIsVisible() {
		return isDisplayed(accountCreated);
	}
	public UserHomePage moveToUserHomePage() {
		clickOn(continueButton);
		return new UserHomePage();
	}
	
}
