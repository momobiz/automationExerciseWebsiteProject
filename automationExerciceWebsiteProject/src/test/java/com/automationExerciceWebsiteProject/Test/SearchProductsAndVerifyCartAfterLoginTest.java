package com.automationExerciceWebsiteProject.Test;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest{
	
	public SearchProductsAndVerifyCartAfterLoginTest() {
		super();
	}
	
	@Test
	public void searchProductsAndVerifyCartAfterLogin() {

//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Click on 'Products' button
		productsPage=homePage.clickOnProductsButton();
		
//	    4. Verify user is navigated to ALL PRODUCTS page successfully
		productsPage.moveToCopyright();
		productsPage.clickOnSubscriptionEmail();
		softAssert.assertTrue(productsPage.susbscriptionIsVisible());
		
//	    5. Enter product name in search input and click search button
		productsPage.searchProduct("jeans");
		
//	    6. Verify 'SEARCHED PRODUCTS' is visible
		softAssert.assertEquals(productsPage.getSearchResultPage().searchedProductsIsVisible(),"SEARCHED PRODUCTS");
		
		
		
//	    7. Verify all the products related to search are visible
		int numberOfProductsappeared=productsPage.getSearchResultPage().getNumberOfProductsCorrespondingToReseachKey();
		softAssert.assertEquals(productsPage.getSearchResultPage().getNumberOfProductsDisplayedCorrespondingToSearchKey("jeans"),numberOfProductsappeared);
		
//	    8. Add those products to cart
		for(int i=1;i<=numberOfProductsappeared;i++) {
			productsPage.addProductToCart(i);
			productsPage.clickOnContinueShoppingButton();
		}
		
//	    9. Click 'Cart' button and verify that products are visible in cart
		cartPage=productsPage.getMenuElementPage().clickOnCartButton();
		
//	    10. Click 'Signup / Login' button and submit login details
		signupLoginPage=cartPage.getMenuElementPage().clickOnSigupLoginButton();
		userHomePage=signupLoginPage.loginValid("johndoe12@gmail.com", "Doe123");
		
//	    11. Again, go to Cart page
		cartPage=userHomePage.clickOnCartButton();
		
//	    12. Verify that those products are visible in cart after login as well
		List<String> productsInCart=cartPage.getProductsInfo();
		String[] choosenProducts= {"Soft Stretch Jeans","Regular Fit Straight Jeans","Grunt Blue Slim Fit Jeans"};
		
		
		for(String product:productsInCart) {
			softAssert.assertTrue(Arrays.asList(choosenProducts).contains(product.split(",")[3]));
	
		}


	}
	

}
