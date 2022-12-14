package com.automationExerciceWebsiteProject.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
	
	By products=By.xpath("//tr[contains(@id,'product-')]");
	By proceedToCheckoutButton=By.xpath("//a[@class='btn btn-default check_out']");
	By modalDialogue=By.xpath("//div[@class='modal-dialog modal-confirm']");
	By modalRegisterLogin=By.cssSelector(".modal-body > p:nth-child(2) > a:nth-child(1)");
	
	By adressDetails=By.cssSelector("div.step-one:nth-child(2) > h2:nth-child(1)");
	By reviewYourOrders=By.cssSelector("div.step-one:nth-child(4) > h2:nth-child(1)");
	By textAreaSpace=By.cssSelector(".form-control");
	By placeOrderButton=By.xpath("//a[@class='btn btn-default check_out']");
	
	MenuElementPage menuElementPage;
	
	public CartPage() {
		menuElementPage=new MenuElementPage();
	}
	
	
	
	
	public MenuElementPage getMenuElementPage() {
		return menuElementPage;
	}


	public int getNumberOfProductInCart() {
		List<WebElement> productsInCart=new ArrayList<WebElement>();
		productsInCart=findWebElements(products);
		return productsInCart.size();
	}
	
	public List<String> getProductsInfo() {
		List<WebElement> productsInCart=new ArrayList<WebElement>();
		productsInCart=findWebElements(products);
		List<String> productsInfo=new ArrayList<String>();
		
		for(WebElement w:productsInCart) {
			
			String price= w.findElement(By.xpath("./child::td[3]/p")).getAttribute("innerHTML").substring(3).trim();
			String quantity=w.findElement(By.xpath("./child::td[4]/button")).getAttribute("innerHTML");
			String total=w.findElement(By.xpath("./child::td[5]/p")).getAttribute("innerHTML").substring(3).trim();
			String productName=w.findElement(By.xpath("./child::td[2]/h4/a")).getAttribute("innerHTML");
			
			productsInfo.add(price+","+quantity+","+total+","+productName);
			
			
		}
		return productsInfo;
		
		
	}
	public boolean cartPageIsDisplayed() {
		return isDisplayed(proceedToCheckoutButton);
		
	}
	public void clickOnProceedButton() {
		clickOn(proceedToCheckoutButton);
	}
	
	public SignupLoginPage clickToRegisterLoginInModalDialogue() {
		try {
			if(findWebElement(modalDialogue)!=null) clickOn(modalRegisterLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SignupLoginPage();
		
		
	}
	public boolean adressDetailsIsDisplayed() {
		return isDisplayed(adressDetails);
	}
	public boolean reviewyourOrderIsDisplayed() {
		return isDisplayed(reviewYourOrders);
	}
	public PayementPage enterDescriptionAndClickPlaceOrder(String str) {
		moveToWebElement(textAreaSpace);
		fillInput(textAreaSpace, str);
		scrollToWebElement(placeOrderButton);
		clickOn(placeOrderButton);
		return new PayementPage();
		
	}
	
	
	
	

}
