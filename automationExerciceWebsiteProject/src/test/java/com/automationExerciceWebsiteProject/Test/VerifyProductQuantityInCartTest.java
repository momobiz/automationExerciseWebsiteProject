package com.automationExerciceWebsiteProject.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationExerciceWebsiteProject.Page.ProductDetailsPage;

public class VerifyProductQuantityInCartTest extends BaseTest{
	
	public VerifyProductQuantityInCartTest() {
		super();
	}
	
	@Test
	public void  verifyProductQuantityInCart() {
//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that home page is visible successfully
		softAssert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		
//	    4. Click 'View Product' for any product on home page
		productDetailsPage=homePage.viewProductDetail(10);
		
//	    5. Verify product detail is opened
		softAssert.assertTrue(productDetailsPage.addYourReviewIsVisible());
		
//	    6. Increase quantity to 4
		productDetailsPage.increaseQuantity("4");
		
//	    7. Click 'Add to cart' button
		productDetailsPage.clickAddCartButton();
		
//	    8. Click 'View Cart' button
		cartPage=productDetailsPage.clickOnViewCart();
		
//	    9. Verify that product is displayed in cart page with exact quantity
		List<String> products=cartPage.getProductsInfo();
		int index=getIndexOfProductInCart(products,"Half Sleeves Top Schiffli Detailing - Pink");
	 	Assert.assertTrue(index<products.size());
		String productQuantity=products.get(index).split(",")[1];
	    softAssert.assertEquals(productQuantity,"4");
	    


	}
	
	
	
	private int getIndexOfProductInCart(List<String> products,String productName) {
		int numberOfProductInCart=products.size();
		int i=0;
		while(i<numberOfProductInCart) {
			if(products.get(i).contains(productName)) break;
		
			i++;
			
		}
		return i;
	}
	
	

}
