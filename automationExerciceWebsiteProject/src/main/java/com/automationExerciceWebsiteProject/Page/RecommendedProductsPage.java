package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RecommendedProductsPage extends BasePage{
	By recommendedProductsContainer=By.cssSelector("#recommended-item-carousel");
	By modalContent=By.xpath("//div[@class='modal-content']");
	By shoppingButton=By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By viewCartButton=By.xpath("//u[contains(text(),'View Cart')]");
	
	public void addRecommendedProductToCart(int productNumber) {

		String str="//div[@id='recommended-item-carousel']/div/div[%s]";
		String str3 = "./child::div[@class='col-sm-4'][%s]";
		String str4 = String.format(str3, productNumber);
		moveToWebElement(recommendedProductsContainer);
		for(int i=1; i<=2;i++) {
			  String str2=String.format(str,i);
			  if(findWebElement(By.xpath(str2)).getAttribute("class").contains("active")) {
				  
					WebElement product = findWebElement(By.xpath(str2)).findElement(By.xpath(str4));				
					WebElement e = product.findElement(By.xpath("div/div/div/a"));				
					clickOnWithJavascript(e);
				 break;
			  }
		
		}
	}
	public void clickOnContinueShoppingButton() {
		try {
			if(findWebElement(modalContent)!=null) clickOn(shoppingButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public CartPage clickOnViewCart() {
		try {
			if(findWebElement(modalContent)!=null) clickOn(viewCartButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CartPage();
		
	}
	

}
