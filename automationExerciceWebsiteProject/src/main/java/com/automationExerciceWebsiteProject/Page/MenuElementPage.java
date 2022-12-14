package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;

public class MenuElementPage extends BasePage{
	
	By cartButton=By.xpath("//ul[@class='nav navbar-nav']");
	By signupLoginButton=By.xpath("//a[contains(text(),'Signup / Login')]");
	
	public CartPage clickOnCartButton() {
		clickOn(cartButton);
		return new CartPage();
	}
	
	public SignupLoginPage clickOnSigupLoginButton() {
		clickOn(signupLoginButton);
		return new SignupLoginPage();
	}

}
