package com.automationExerciceWebsiteProject.Test;

import org.junit.Assert;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.testng.annotations.Test;

public class LoginUserWithIncorrectEmailAndPassword extends BaseTest{
	
	public LoginUserWithIncorrectEmailAndPassword() {
		super();
	}
	@Test
	public void loginWithInvalidCredential() {
		String userEmail=prop.get("userEmail").toString();
		String userPassword=prop.get("userPassword").toString();
		
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'	
//	    3. Verify that home page is visible successfully
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Click on 'Signup / Login' button
		signupLoginPage=homePage.createAccount();
		
//	    5. Verify 'Login to your account' is visible
		Assert.assertTrue(signupLoginPage.loginToYourAccountIsVisible());;
		
//	    6. Enter incorrect email address and password
//	    7. Click 'login' button
		signupLoginPage.loginInvalid(userEmail,userPassword);
		
//	    8. Verify error 'Your email or password is incorrect!' is visible
		Assert.assertEquals(signupLoginPage.returnAlertMessage(),"Your email or password is incorrect!" );


		
	}
	

}
