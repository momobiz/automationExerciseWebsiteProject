package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;

public class DeleteAccountPage extends BasePage {
	By accountDeleted=By.xpath("//b[contains(text(),'Account Deleted!')]");
	By continueButton=By.cssSelector("a.btn");
	
	public String accountIsDeleted() {
		return findWebElement(accountDeleted).getText();
		
	}
	
	public void deleteAccount() {
		clickOn(continueButton);
	
		
	}
}
