package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;

public class PayementPage extends BasePage {
	By payement=By.cssSelector(".heading");
	By nameOnCard=By.cssSelector("div.form-row:nth-child(2) > div:nth-child(1) > input:nth-child(2)");
	By cardNumber=By.cssSelector(".card-number");
	By cvc=By.cssSelector(".card-cvc");
	By expirationMonth=By.cssSelector(".card-expiry-month");
	By expirationYear=By.cssSelector(".card-expiry-year");
	By payAndConfirButton=By.cssSelector("#submit");
	By sucessMessage=By.xpath("//div[contains(text(),'Your order has been placed successfully!')]");
	
	
	public void enterPaymentInformation(String name, String cardnumber,String userCvc,String month, String year) {
		
		fillInput(nameOnCard, name);
		fillInput(cardNumber, cardnumber);
		fillInput(cvc, userCvc);
		fillInput(expirationMonth, month);
		fillInput(expirationYear, year);
		clickOn(payAndConfirButton);
		
	}
	public void returnSuccessMessage() {
		System.out.println(findWebElement(sucessMessage).getText());
		//findWebElement(sucessMessage).getAttribute("innerHTML");
	}
	

}
