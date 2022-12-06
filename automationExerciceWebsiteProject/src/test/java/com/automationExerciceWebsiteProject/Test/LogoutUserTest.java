package com.automationExerciceWebsiteProject.Test;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LogoutUserTest extends BaseTest{
	
	public LogoutUserTest() {
		super();
	}
	
	@Test
	public void logout() {
		String email=prop.getProperty("validLogin");
		String password=prop.getProperty("validPassword");
		String username=prop.getProperty("validUsername");
		
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Click on 'Signup / Login' button
		signupLoginPage=homePage.createAccount();
		
//	    5. Verify 'Login to your account' is visible
		Assert.assertTrue(signupLoginPage.newUserSignupIsVisible());
		
//	    6. Enter correct email address and password
//	    7. Click 'login' button
		userHomePage=signupLoginPage.loginValid(email,password);
		
//	    8. Verify that 'Logged in as username' is visible
		Assert.assertEquals(userHomePage.loggedInAsUsername(), "Logged in as "+username);;
		
//	    9. Click 'Logout' button
		userHomePage.clickOnLogout();
		
//	    10. Verify that user is navigated to login page
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		


		
	}
	

}
