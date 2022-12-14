package com.automationExerciceWebsiteProject.Test;

import org.testng.annotations.Test;

public class ViewCategoryProductsTest extends BaseTest{
	
	public ViewCategoryProductsTest() {
		super();
	}
	
	@Test
	public void viewCategoryProducts() {

//	    1. Launch browser
//	    2. Navigate to url 'http://automationexercise.com'
//	    3. Verify that categories are visible on left side bar
		softAssert.assertTrue(homePage.categoryIsVisible());
		
//	    4. Click on 'Women' categoryq
//		homePage.clickOnCategory("women");
		homePage.getMenuCategoriesPage().clickOnCategory("women");
		categoryPage=homePage.getMenuCategoriesPage().chooseOneCategory("tops");
		
//	    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
		String category=categoryPage.getCategoryName();
		softAssert.assertEquals(category,"WOMEN - TOPS PRODUCTS");
		
//	    7. On left side bar, click on any sub-category link of 'Men' category	
		categoryPage.getMenuCategoriesPage().clickOnCategory("Men");
		categoryPage=categoryPage.getMenuCategoriesPage().chooseOneCategory("jeans");
		
		
//	    8. Verify that user is navigated to that category page
		softAssert.assertEquals(categoryPage.getCategoryName(),"MEN - JEANS PRODUCTS");
		


		
	}
		

}
