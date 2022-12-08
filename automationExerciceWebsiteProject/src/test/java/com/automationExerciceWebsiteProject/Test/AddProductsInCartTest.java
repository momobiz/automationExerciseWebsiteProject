package com.automationExerciceWebsiteProject.Test;

import java.util.List;

import org.testng.annotations.Test;

public class AddProductsInCartTest extends BaseTest{
	
	public AddProductsInCartTest() {
		super();
	}
	
	@Test
	public void addProductsInCart() {

//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		softAssert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Click 'Products' button
		productsPage=homePage.clickOnProductsButton();
		
//	    5. Hover over first product and click 'Add to cart'
		productsPage.addProductToCart(1);
		
//	    6. Click 'Continue Shopping' button
		productsPage.clickOnContinueShoppingButton();
		
//	    7. Hover over second product and click 'Add to cart'
		productsPage.addProductToCart(7);
		
//	    8. Click 'View Cart' button
		cartPage=productsPage.clickOnViewCart();
		
//	    9. Verify both products are added to Cart
		softAssert.assertEquals(cartPage.getNumberOfProductInCart(), 2);
		
//	    10. Verify their prices, quantity and total price
		
		List<String> productsInfo=cartPage.getProductsInfo();
		String[] productInfo;
		
		for(String info:productsInfo) {
			productInfo=info.split(",");
			softAssert.assertEquals(convertStringtoInt(productInfo[0]),500);
			softAssert.assertEquals(convertStringtoInt(productInfo[1]), 1);
			softAssert.assertEquals(convertStringtoInt(productInfo[2]), 500);
			
		}


	}

}
