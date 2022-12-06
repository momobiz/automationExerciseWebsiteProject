package com.automationExerciceWebsiteProject.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;



public class HomePage extends BasePage{
	
	By home=By.xpath("//a[contains(text(),'Home')]");
	By signupLoginButton=By.xpath("//a[contains(text(),'Signup / Login')]");
	
	By contactUsButton=By.xpath("//a[contains(text(),'Contact us')]");
	By productsButton=By.xpath("//a[contains(text(),'Products')]");
	
	public HomePage() {
		launchBrowser();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public boolean homePageIsVisibleSuccessfully() {
		return isDisplayed(home);
	}
	
	public SignupLoginPage createAccount() {
		findWebElement(signupLoginButton).click();
		return new SignupLoginPage();
	}
	
	
	public boolean newUserSignupIsVisible() {
		return isDisplayed(signupLoginButton);
	}
	public GetInTouchPage clickOnContactUs() {
		findWebElement(contactUsButton).click();
		return new GetInTouchPage();
	}
	public ProductsPage clickOnProductsButton() {
		clickOn(productsButton);
		return new ProductsPage();
	}

}
