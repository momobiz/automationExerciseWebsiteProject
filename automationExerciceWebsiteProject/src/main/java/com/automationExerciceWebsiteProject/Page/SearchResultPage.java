package com.automationExerciceWebsiteProject.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage{
	
	By searchedProductsMessage=By.xpath("//h2[@class='title text-center']");
	By featureItems=By.xpath("//div[@class='features_items']");
	
	
	public String searchedProductsIsVisible() {
		return findWebElement(searchedProductsMessage).getText();
		
		
	}
	public int getNumberOfProductsCorrespondingToReseachKey() {
		List<WebElement> productList=new ArrayList<WebElement>();
		productList=findWebElement(featureItems).findElements(By.xpath("./child::div[@class='col-sm-4']/div/div/div[2]/div/p"));
		return productList.size();
	}
	
	public List<String> getProductsRelatedTosearch() {
		List<WebElement> productList=new ArrayList<WebElement>();
		productList=findWebElement(featureItems).findElements(By.xpath("./child::div[@class='col-sm-4']/div/div/div[2]/div/p"));
		List<String> productsNameList=new ArrayList<String>();
		for(WebElement w:productList) {
			productsNameList.add(w.getAttribute("innerHTML").toLowerCase());
		}
		return productsNameList;
		
		
	}

}
