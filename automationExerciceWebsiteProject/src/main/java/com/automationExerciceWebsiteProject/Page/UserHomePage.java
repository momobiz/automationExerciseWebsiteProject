package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;

public class UserHomePage extends BasePage {
   // Elements for registration
	By loginAs = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a");
	By deleteAccountButton = By.cssSelector(".navbar-nav > li:nth-child(5) > a:nth-child(1)");
    
	
	
	public String loggedInAsUsername() {
		return findWebElement(loginAs).getText();

	}

	public DeleteAccountPage deleteAccount() {
		findWebElement(deleteAccountButton).click();
		return new DeleteAccountPage();
	}

}
