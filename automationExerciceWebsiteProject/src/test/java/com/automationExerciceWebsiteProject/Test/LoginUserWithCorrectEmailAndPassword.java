package com.automationExerciceWebsiteProject.Test;

import org.junit.Assert;
import org.testng.annotations.Test;

// Before running this test, make sure that the user is already registred on the website

public class LoginUserWithCorrectEmailAndPassword extends BaseTest{
		
	public LoginUserWithCorrectEmailAndPassword() {
		super();
	}
	
//  1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
	
// 		These two steps are realised In BaseTest class when we instanciated HomePage class
 	

	@Test
	public void loginWithValidcredentials() {
//		3. Verify that home page is visible successfully
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//		4. Click on 'Signup / Login' button
		signupLoginPage=homePage.createAccount(); 
		
//		5. Verify 'Login to your account' is visible
		Assert.assertTrue(signupLoginPage.loginToYourAccountIsVisible());
		
//		6. Enter correct email address and password
//		7. Click 'login' button
	    userHomePage=signupLoginPage.loginValid("soumaya12@gmail.com", "Soumaya123");
	    
//		8. Verify that 'Logged in as username' is visible
	    
	    Assert.assertEquals(userHomePage.loggedInAsUsername(),"Logged in as soumaya");
		
//		9. Click 'Delete Account' button
	    deleteAccountPage=userHomePage.deleteAccount();
	    
//		10. Verify that 'ACCOUNT DELETED!' is visible
	    System.out.println(deleteAccountPage.accountIsDeleted());
	    Assert.assertEquals(deleteAccountPage.accountIsDeleted(),"ACCOUNT DELETED!");
	    
	    
	}



}
