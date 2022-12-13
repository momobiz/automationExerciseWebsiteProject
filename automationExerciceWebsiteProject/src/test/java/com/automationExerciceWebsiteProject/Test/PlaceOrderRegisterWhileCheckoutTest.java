package com.automationExerciceWebsiteProject.Test;

import org.apache.commons.io.FileSystemUtils;
import org.testng.annotations.Test;

import com.automationExerciceWebsiteProject.Page.EnterYourContactInformationPage;

public class PlaceOrderRegisterWhileCheckoutTest extends BaseTest{
	
	public PlaceOrderRegisterWhileCheckoutTest() {
		super();
	}
	
	@Test
	public void placeOrderRegisterWhileCheckout() {

//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		softAssert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Add products to cart
		homePage.addProductToCart(2);
		homePage.clickOnContinueShoppingButton();
		homePage.addProductToCart(5);
		homePage.clickOnContinueShoppingButton();
		homePage.addProductToCart(10);
		homePage.clickOnContinueShoppingButton();
		
//	    5. Click 'Cart' button
		cartPage=homePage.clickOnCartButton();
		
//	    6. Verify that cart page is displayed
		softAssert.assertTrue(cartPage.cartPageIsDisplayed());
		
//	    7. Click Proceed To Checkout
		cartPage.clickOnProceedButton();
		
//	    8. Click 'Register / Login' button
		signupLoginPage=cartPage.clickToRegisterLoginInModalDialogue();
		
//	    9. Fill all details in Signup and create account
		enterYourContactInformationPage=signupLoginPage.signup("John", "johndoe17@gmail.com");
		String[] options= {"newsletter"};
		String username="johnDoe";
		accountCreatedPage=enterYourContactInformationPage.enterYourInformation("Mr", username, "Doe123", "15",
				"12", "1977",options,"Doe", "John", "EDS",
				"Brad Street"," ", "Canada","Quebec", "Montreal",
				"123", "3261256"
);
		
//	    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		softAssert.assertTrue(accountCreatedPage.accountCreatedIsVisible());
		userHomePage=accountCreatedPage.moveToUserHomePage();
		
//	    11. Verify ' Logged in as username' at top
		softAssert.assertEquals(userHomePage.loggedInAsUsername(),"Logged in as "+username);
		
//	    12.Click 'Cart' button
		cartPage=userHomePage.clickOnCartButton();
		
//	    13. Click 'Proceed To Checkout' button
		cartPage.clickOnProceedButton();
		
//	    14. Verify Address Details and Review Your Order
		softAssert.assertTrue(cartPage.adressDetailsIsDisplayed());
		softAssert.assertTrue(cartPage.reviewyourOrderIsDisplayed());
		
		
//	    15. Enter description in comment text area and click 'Place Order'
		payementPage=cartPage.enterDescriptionAndClickPlaceOrder("Le lorem ipsum est, en imprimerie,"
				+ " une suite de mots sans signification utilisée à titre provisoire pour calibrer"
				+ " une mise en page");
		
//	    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//		 17. Click 'Pay and Confirm Order' button
		payementPage.enterPaymentInformation("Doe", "xx", "xx", "12","2025");
		
//	  
//	    18. Verify success message 'Your order has been placed successfully!'
		payementPage.returnActiveElement();
		
//	    19. Click 'Delete Account' button
//	    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button


		
	}

}
