package com.automationExerciceWebsiteProject.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailpageTest extends BaseTest{
	
	public VerifyAllProductsAndProductDetailpageTest() {
		super();
	}
	@Test
	public void verifyAllProductsAndProductDetailpage() {
		
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
		
		
//	    6. The products list is visible
		softAssert.assertTrue(productsPage.productListIsVisible());
		
//	    7. Click on 'View Product' of first product
//	    8. User is landed to product detail page
		productDetailsPage= productsPage.clickOnFirstProduct();
		
//	    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        softAssert.assertTrue(productDetailsPage.productNameIsVisible());
        softAssert.assertTrue(productDetailsPage.productCategoryIsVisible());
        softAssert.assertTrue(productDetailsPage.productPriceIsVisible());
        softAssert.assertTrue(productDetailsPage.productAvailabilityIsVisible());
        softAssert.assertTrue(productDetailsPage.productConditionsIsVisible());
        softAssert.assertTrue(productDetailsPage.productBrandIsVisible());
	
		
	}




}
