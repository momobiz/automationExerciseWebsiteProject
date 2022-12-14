package com.automationExerciceWebsiteProject.Page;

import java.lang.module.FindException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage{
	
	By featureItems=By.xpath("//div[@class='features_items']/h2");

	
	 MenuCategoriesPage menuCategoriesPage;
	
	public CategoryPage() {
		menuCategoriesPage=new MenuCategoriesPage();
	}
	
	public String getCategoryName() {
		return findWebElement(featureItems).getAttribute("innerHTML");
		
	}

	public MenuCategoriesPage getMenuCategoriesPage() {
		return menuCategoriesPage;
	}

	

}
