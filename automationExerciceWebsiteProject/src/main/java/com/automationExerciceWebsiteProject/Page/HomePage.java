package com.automationExerciceWebsiteProject.Page;

import java.lang.module.FindException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	By home = By.xpath("//a[contains(text(),'Home')]");
	By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");

	By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
	By productsButton = By.xpath("//a[contains(text(),'Products')]");
	By cartButton = By.xpath("//a[contains(text(),'Cart')]");
	By modalContent = By.xpath("//div[@class='modal-content']");
	By shoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

	By featureItems = By.xpath("//div[@class='features_items']");

	By categoryMenu = By.xpath("//h2[contains(text(),'Category')]");
	By brands = By.xpath("//h2[contains(text(),'Brands')]");
	String str1="//div[@id='accordian']/div[%s]";
	String str2;
	int indexCategory=0;
	String str3="//div[@id='accordian']/div[%s]/div[2]/div/ul/li[%s]/a";
	
	 
	

	public HomePage() {
		launchBrowser();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public boolean homePageIsVisibleSuccessfully() {
		return isDisplayed(home);
	}

	public SignupLoginPage createAccount() {
		findWebElement(signupLoginButton).click();
		return new SignupLoginPage();
	}

	public boolean newUserSignupIsVisible() {
		return isDisplayed(signupLoginButton);
	}

	public GetInTouchPage clickOnContactUs() {
		findWebElement(contactUsButton).click();
		return new GetInTouchPage();
	}

	public ProductsPage clickOnProductsButton() {
		clickOn(productsButton);
		return new ProductsPage();
	}

	public ProductDetailsPage viewProductDetail(int productNumber) {

		String str = "./child::div[@class='col-sm-4'][%s]";
		String str2 = String.format(str, productNumber);

		WebElement product = findWebElement(featureItems).findElement(By.xpath(str2));
		scrollToWebElement(product);
		moveToWebElement(product);
		WebElement viewProductLink = findWebElement(featureItems).findElement(By.xpath(str2 + "/div/div[2]/ul/li/a"));
		clickOn(viewProductLink);

		return new ProductDetailsPage();
	}

	public void addProductToCart(int productNumber) {
		String str = "./child::div[@class='col-sm-4'][%s]";
		String str2 = String.format(str, productNumber);

		WebElement product = findWebElement(featureItems).findElement(By.xpath(str2));
		scrollToWebElement(product);
		moveToWebElement(product);
		WebElement e = findWebElement(featureItems).findElement(By.xpath(str2 + "/div/div/div[2]/div/a"));
		clickOnWithJavascript(e);

	}

	public void clickOnContinueShoppingButton() {
		try {
			if (findWebElement(modalContent) != null)
				clickOn(shoppingButton);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CartPage clickOnCartButton() {
		clickOn(cartButton);
		return new CartPage();
	}

	public boolean categoryIsVisible() {
		return isDisplayed(categoryMenu);
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
