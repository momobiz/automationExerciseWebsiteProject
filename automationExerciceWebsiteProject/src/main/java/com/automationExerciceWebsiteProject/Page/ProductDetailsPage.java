package com.automationExerciceWebsiteProject.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage{
	 By productInformation=By.xpath("//div[@class='product-information']");
	 By addYourReview=By.xpath("//a[contains(text(),'Write Your Review')]");
	 By quantity=By.id("quantity");
	 By addCartButton=By.xpath("//button[@type='button']");
	 
	 By modalContent=By.xpath("//div[@class='modal-content']");
	 By viewCartButton=By.xpath("//u[contains(text(),'View Cart')]");
	 
	 public boolean productNameIsVisible() {
		 WebElement name=findWebElement(productInformation).findElement(By.xpath("child::h2"));
		 return !name.getText().isEmpty(); 
	 }
	 public boolean productCategoryIsVisible() {
		 WebElement category=findWebElement(productInformation).findElement(By.xpath("child::p[1]"));
		 return !category.getText().isEmpty();
	 }
	 public boolean productPriceIsVisible() {
		 WebElement price=findWebElement(productInformation).findElement(By.xpath("child::span/span"));
	     return !price.getText().isEmpty();
	 }
	 public boolean productAvailabilityIsVisible() {
		 WebElement availability=findWebElement(productInformation).findElement(By.xpath("child::p[2]/b"));
		 return !availability.getText().isEmpty();
	 }
	 public boolean productConditionsIsVisible() {
		 WebElement conditions=findWebElement(productInformation).findElement(By.xpath("child::p[3]/b"));
		 return !conditions.getText().isEmpty();
				 
	 }
	 public boolean productBrandIsVisible() {
		 WebElement brand=findWebElement(productInformation).findElement(By.xpath("child::p[4]/b"));
		 return !brand.getText().isEmpty();	
	 }
	 public boolean addYourReviewIsVisible() {
		 return isDisplayed(addYourReview);
	 }
	 
	 public void increaseQuantity(String value) {
		 findWebElement(quantity).clear();
		 findWebElement(quantity).sendKeys(value);
	 }
	 
	 public void clickAddCartButton() {
		 clickOn(addCartButton);
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
