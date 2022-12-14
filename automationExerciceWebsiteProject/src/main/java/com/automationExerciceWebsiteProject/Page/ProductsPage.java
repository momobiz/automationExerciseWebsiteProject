package com.automationExerciceWebsiteProject.Page;

import java.util.List;

import org.checkerframework.checker.units.qual.Substance;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends BasePage {
	By subscription=By.xpath("//h2[contains(text(),'Subscription')]");
	By copyright=By.cssSelector("p.pull-left");
	By subscribeEmail=By.cssSelector("#susbscribe_email");
	By featureItems=By.xpath("//div[@class='features_items']");
	By firstProduct=By.xpath("//a[@href='/product_details/1']");
	
	By searchProduct=By.cssSelector("#search_product");
	By searchButton=By.xpath("//button[@id='submit_search']");
	
	By modalContent=By.xpath("//div[@class='modal-content']");
	By shoppingButton=By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By viewCartButton=By.xpath("//u[contains(text(),'View Cart')]");
	
	MenuElementPage menuElementPage;
	
	public ProductsPage() {
		menuElementPage=new MenuElementPage();
	}
	
	
	public MenuElementPage getMenuElementPage() {
		return menuElementPage;
	}


	private SearchResultPage searchResultPage;
	

	
	public SearchResultPage getSearchResultPage() {
		return searchResultPage;
	}



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
//	public SearchResultPage searchProduct(String productName) {
//		moveToWebElement(searchProduct);
//		findWebElement(searchProduct).sendKeys(productName);
//		clickOn(searchButton);
//		return new SearchResultPage();
//		
//	}
	
	public void searchProduct(String productName) {
		moveToWebElement(searchProduct);
		findWebElement(searchProduct).sendKeys(productName);
		clickOn(searchButton);
		searchResultPage=new SearchResultPage();
		
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
	
	
	

	
	
	
	
	
	
	
	
	

}

