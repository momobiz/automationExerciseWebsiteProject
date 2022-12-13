package com.automationExerciceWebsiteProject.Page;

import java.lang.module.FindException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage{
	
	By featureItems=By.xpath("//div[@class='features_items']/h2");
	
	By categoryMenu = By.xpath("//h2[contains(text(),'Category')]");
	By brands = By.xpath("//h2[contains(text(),'Brands')]");
	String str1="//div[@id='accordian']/div[%s]";
	String str2;
	int indexCategory=0;
	String str3="//div[@id='accordian']/div[%s]/div[2]/div/ul/li[%s]/a";
	
	public String getCategoryName() {
		return findWebElement(featureItems).getAttribute("innerHTML");
		
	}
	public void clickOnCategory(String category) {
		scrollToWebElement(categoryMenu);
		String[] categoriesTab = { "women", "men", "kids" };
		
		int i = 0;

		while (i < categoriesTab.length) {
			if (categoriesTab[i].contentEquals(category.toLowerCase())) {
				indexCategory=i+1;
				str2=String.format(str1, indexCategory);
				String str = str2+"/div/h4/a";
				clickOn(By.xpath(str));

				break;
			}
			i++;
		} 
		if(i>=categoriesTab.length) throw new NoSuchElementException(String.format("category : %s doesn't exist", category));

	}
	public CategoryPage chooseOneCategory(String oneCategory) {
		String[] womenCategories= {"dress","tops","saree"};
		String[] menCategories= {"tshirts","jeans"};
		String[] kidsCategories= {"dress","Tops & Shirts"};
		System.out.println(indexCategory);
		CategoryPage productsBelongToCategoryPage=null;
		switch(indexCategory) {
		
			case 1:
				int i=0;
				while(i<womenCategories.length) {
					if(womenCategories[i].contentEquals(oneCategory.toLowerCase())) {
						WebElement category=findWebElement(By.xpath(String.format(str3,indexCategory,i+1)));
						clickOn(category);
						productsBelongToCategoryPage=new CategoryPage();
						break;
					}
					i++;
				}
				break;
			case 2:
				int j=0;
				while(j<menCategories.length) {
					if(menCategories[j].contentEquals(oneCategory.toLowerCase())) {
						WebElement category=findWebElement(By.xpath(String.format(str3,indexCategory,j+1)));
						clickOn(category);
						productsBelongToCategoryPage=new CategoryPage();
						break;
					}
					j++;
				}
				break;
			case 3:
				int k=0;
				while(k<womenCategories.length) {
					if(womenCategories[k].contentEquals(oneCategory.toLowerCase())) {
						WebElement category=findWebElement(By.xpath(String.format(str3,indexCategory,k+1)));
						clickOn(category);
						productsBelongToCategoryPage=new CategoryPage();
						break;
					}
					k++;
				}
				break;
			default: 
			  throw new NoSuchElementException("category doesnt exist");
		}
		
		if(productsBelongToCategoryPage==null) throw new NoSuchElementException("category doesnt exist");
		
		return productsBelongToCategoryPage;
	}
	
	
	

}
