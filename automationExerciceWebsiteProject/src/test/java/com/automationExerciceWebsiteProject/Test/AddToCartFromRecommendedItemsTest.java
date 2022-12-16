package com.automationExerciceWebsiteProject.Test;

import org.testng.annotations.Test;

public class AddToCartFromRecommendedItemsTest extends BaseTest{
	public AddToCartFromRecommendedItemsTest() {
		super();
	}
	
	@Test
	public void addToCartFromRecommendedItems() {
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Scroll to bottom of page
		homePage.scrollRecommendedItems();
		
//	    4. Verify 'RECOMMENDED ITEMS' are visible
		softAssert.assertTrue(homePage.recommendedItemsIsDisplayed());
		
//	    5. Click on 'Add To Cart' on Recommended product
		homePage.getRecommendedProductsPage().addRecommendedProductToCart(2);
		
//	    6. Click on 'View Cart' button
		cartPage=homePage.getRecommendedProductsPage().clickOnViewCart();
		
//	    7. Verify that product is displayed in cart page
		String productName=cartPage.getProductsInfo().get(0).split(",")[3];
		softAssert.assertEquals(productName, "Winter Top");


		
	}


}
