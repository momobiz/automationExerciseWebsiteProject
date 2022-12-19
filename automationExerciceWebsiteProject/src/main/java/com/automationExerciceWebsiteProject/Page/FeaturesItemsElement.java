package com.automationExerciceWebsiteProject.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeaturesItemsElement extends BasePage{
	
	By featureItems=By.xpath("//div[@class='features_items']");
	By modalContent=By.xpath("//div[@class='modal-content']");
	By shoppingButton=By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By viewCartButton=By.xpath("//u[contains(text(),'View Cart')]");
	

	
	public boolean productListIsVisible() {
		List<WebElement> items=findWebElement(featureItems).findElements( By.xpath("./child::div[@class='col-sm-4']"));
		boolean state=false;
		if(items.size()>0) state=true;
		return state;
	}
	public void addProductToCart(int productNumber) {
		String str="./child::div[@class='col-sm-4'][%s]";
		String str2=String.format(str,productNumber);
		
		WebElement product=findWebElement(featureItems).findElement(By.xpath(str2));
		scrollToWebElement(product);
		moveToWebElement(product);
		WebElement e=findWebElement(featureItems).findElement(By.xpath(str2+"/div/div/div[2]/div/a"));
		clickOnWithJavascript(e);
		
	
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
 public ProductDetailsPage viewProduct(int productNumber) {
	 
		String str="./child::div[@class='col-sm-4'][%s]";
		String str2=String.format(str,productNumber);
		
		WebElement product=findWebElement(featureItems).findElement(By.xpath(str2));
		scrollToWebElement(product);
		moveToWebElement(product);
		WebElement viewProductButton=findWebElement(featureItems).findElement(By.xpath(str2+"/div/div[2]/ul/li/a"));
		clickOn(viewProductButton);
		return new ProductDetailsPage();
		 
	 }

}
