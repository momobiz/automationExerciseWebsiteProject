package com.automationExerciceWebsiteProject.Page;

import java.util.List;

import org.checkerframework.checker.units.qual.Substance;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
	By subscription=By.xpath("//h2[contains(text(),'Subscription')]");
	By copyright=By.cssSelector("p.pull-left");
	By subscribeEmail=By.cssSelector("#susbscribe_email");
	By featureItems=By.xpath("//div[@class='features_items']");
	By firstProduct=By.xpath("//a[@href='/product_details/1']");
	
	
	
	
	public void moveToCopyright() {
		moveToWebElement(copyright);
		
	}
	public boolean susbscriptionIsVisible() {
		return isDisplayed(subscription);
	}
	
	public void clickOnSubscriptionEmail() {
		findWebElement(subscribeEmail).click();;
	}
	public String idOfSubscribeEmail() {
		return findWebElement(subscribeEmail).getAttribute("id");
	}
	public boolean productListIsVisible() {
		List<WebElement> items=findWebElement(featureItems).findElements( By.xpath("./child::div[@class='col-sm-4']"));
		boolean state=false;
		if(items.size()>0) state=true;
		return state;
	}
	
	public ProductDetailsPage clickOnFirstProduct() {
		
		scrollToWebElement(firstProduct);
		clickOn(firstProduct);
		return new ProductDetailsPage();
		
		
	}
	
	
	
	
	
	
	

}

