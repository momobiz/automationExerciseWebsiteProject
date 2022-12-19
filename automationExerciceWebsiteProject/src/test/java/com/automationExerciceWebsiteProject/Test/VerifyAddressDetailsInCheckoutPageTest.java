package com.automationExerciceWebsiteProject.Test;


import java.util.List;

import org.testng.annotations.Test;

import com.automationExerciceWebsiteProject.Page.EnterYourContactInformationPage;

public class VerifyAddressDetailsInCheckoutPageTest extends BaseTest{
	public VerifyAddressDetailsInCheckoutPageTest() {
		super();
	}
	@Test
	public void verifyAddressDetailsInCheckoutPage(){


//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		softAssert.assertTrue(homePage.isDisplayed(null));
		
//	    4. Click 'Signup / Login' button
		signupLoginPage=homePage.createAccount();
		
//	    5. Fill all details in Signup and create account
		String[] options={"newsletter"};
		enterYourContactInformationPage=signupLoginPage.signup("JohnDoe","johnDoe14@gmail.com");
		accountCreatedPage=enterYourContactInformationPage.enterYourInformation("Mr","JohnDoe13", "Doe123", "12",
				"12", "1980", options, "John", "Doe", "Sopra Steria",
				"rue des jasmin"," ", "Canada", "Quebec","Les trois rivières",
				"123", "321456");
		
//	    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		softAssert.assertTrue(accountCreatedPage.accountCreatedIsVisible());
		userHomePage=accountCreatedPage.moveToUserHomePage();
		
//	    7. Verify ' Logged in as username' at top
		softAssert.assertEquals(userHomePage.loggedInAsUsername(), "Logged in as "+"JohnDoe");
		
//	    8. Add products to cart
		userHomePage.getFeaturesItemElement().addProductToCart(1);
		userHomePage.getFeaturesItemElement().clickOnContinueShoppingButton();
		userHomePage.getFeaturesItemElement().addProductToCart(5);
		userHomePage.getFeaturesItemElement().clickOnContinueShoppingButton();
		
//	    9. Click 'Cart' button
		cartPage=userHomePage.clickOnCartButton();
		
//	    10. Verify that cart page is displayed
		softAssert.assertTrue(cartPage.cartPageIsDisplayed());
		
//	    11. Click Proceed To Checkout
		cartPage.clickOnProceedButton();
		
//	    12. Verify that the delivery address is same address filled at the time registration of account
		List<String> adress=cartPage.getDeliveryAdress();
		softAssert.assertEquals(adress.get(1),"Mr. John Doe");
		softAssert.assertEquals(adress.get(2), "Sopra Steria");
		softAssert.assertEquals(adress.get(3), "rue des jasmin");
		softAssert.assertEquals(adress.get(4), " ");
		softAssert.assertEquals(adress.get(5), "Les trois rivières");
		softAssert.assertEquals(adress.get(7), "Quebec");
		
		
//	    13. Click 'Delete Account' button

//	    14. Verify 'ACCOUNT DELETED!' and click 'Continue' button


		
	}
	

}
