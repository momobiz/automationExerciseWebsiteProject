package com.automationExerciceWebsiteProject.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
	
	By products=By.xpath("//tr[contains(@id,'product-')]");
	
	
	public int getNumberOfProductInCart() {
		List<WebElement> productsInCart=new ArrayList<WebElement>();
		productsInCart=findWebElements(products);
		return productsInCart.size();
	}
	
	public List getProductsInfo() {
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
	
	
	

}
