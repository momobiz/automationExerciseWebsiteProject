package com.automationExerciceWebsiteProject.Test;

import org.testng.annotations.Test;

public class AddReviewOnProductTest extends BaseTest{
	
	public AddReviewOnProductTest() {
		super();
	}
	
	@Test
	public void addReviewOnProduct() {

//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Click on 'Products' button
		productsPage=homePage.clickOnProductsButton();
		
//	    4. Verify user is navigated to ALL PRODUCTS page successfully
		productsPage.moveToCopyright();
		productsPage.clickOnSubscriptionEmail();
		softAssert.assertTrue(productsPage.susbscriptionIsVisible());
		
//	    5. Click on 'View Product' button
		productDetailsPage=productsPage.viewProduct(5);
		
//	    6. Verify 'Write Your Review' is visible
		softAssert.assertTrue(productDetailsPage.writeYourReviewIsVisible());
		
//	    7. Enter name, email and review
//	    8. Click 'Submit' button
		productDetailsPage.addReview("john Doe", "johnDoe12@gmail.com","Hello world");
		
//	    9. Verify success message 'Thank you for your review.'
		softAssert.assertEquals(productDetailsPage.getSuccessMessage(),"Thank you for your review.");


		
	}
	
	

}
