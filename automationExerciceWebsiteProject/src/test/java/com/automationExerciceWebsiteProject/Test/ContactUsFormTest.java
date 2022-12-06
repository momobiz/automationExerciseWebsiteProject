package com.automationExerciceWebsiteProject.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsFormTest extends BaseTest{
	
	public ContactUsFormTest(){
		super();
	}
	@Test
	public void contactUsForm() {
		String username="Doe";
		String userEmail="johnDoe@gmail.com";
		String userSubject="complain";
		String userMessage="xxxx";
		
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Click on 'Contact Us' button
		getInTouchPage=homePage.clickOnContactUs();
		
//	    5. Verify 'GET IN TOUCH' is visible
	    Assert.assertEquals(getInTouchPage.getInTouchMessage(),"GET IN TOUCH");
	    
//	    6. Enter name, email, subject and message
	    getInTouchPage.fillInFormular(username, userEmail, userSubject, userMessage);  
//	    7. Upload file
	    getInTouchPage.scrollDown(150);
	    getInTouchPage.uploadFileInFormular(prop.getProperty("filename"));
	    
//	    8. Click 'Submit' button
	    getInTouchPage.submitFormular();
	    
//	    9. Click OK button
	    getInTouchPage.clickOkAlertButton();
	    
//	    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		Assert.assertEquals("Success! Your details have been submitted successfully.", getInTouchPage.alertMessage());
	    
//	    11. Click 'Home' button and verify that landed to home page successfully
		getInTouchPage.clickOnHomeBuuton();
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());


	}
	
}
