package com.automationExerciceWebsiteProject.Test;


import java.util.List;

import org.testng.annotations.Test;

import com.automationExerciceWebsiteProject.Page.HomePage;

public class SearchProductTest extends BaseTest{
	
	public SearchProductTest() {
		super();
	}
	
   @Test
   public void searchProduct() {
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
	    softAssert.assertTrue(homePage.homePageIsVisibleSuccessfully());
	    
//	    4. Click on 'Products' button
	    productsPage=homePage.clickOnProductsButton();
	    
//	    5. Verify user is navigated to ALL PRODUCTS page successfully
	    productsPage.moveToCopyright();
		productsPage.clickOnSubscriptionEmail();
		softAssert.assertEquals(productsPage.returnActiveElement().getAttribute("id"),
								productsPage.idOfSubscribeEmail());
//		
//	    6. Enter product name in search input and click search button
		productsPage.searchProduct("jeans");
		
//	    7. Verify 'SEARCHED PRODUCTS' is visible
		softAssert.assertEquals(productsPage.getSearchResultPage().searchedProductsIsVisible(),"SEARCHED PRODUCTS");
		
//	    8. Verify all the products related to search are visible
		int numberOfProductAppeared=productsPage.getSearchResultPage().getNumberOfProductsCorrespondingToReseachKey();
//		
		
		int numberOfProductsCorrespondingToReseachKey=0;
		List<String> products=productsPage.getSearchResultPage().getProductsRelatedTosearch();
		for(String product:products) {
			
			if(product.contains("jeans")) numberOfProductsCorrespondingToReseachKey++;
		}

		softAssert.assertEquals(numberOfProductAppeared, numberOfProductsCorrespondingToReseachKey);
		
   }



}
