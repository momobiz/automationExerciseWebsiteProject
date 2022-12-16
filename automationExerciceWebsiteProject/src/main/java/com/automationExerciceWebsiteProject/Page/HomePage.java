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
	By recommendedItems=By.xpath("//h2[contains(text(),'recommended items')]");
	By subscription=By.xpath("//h2[contains(text(),'Subscription')]");
	
	
	private RecommendedProductsPage recommendedProductsPage;
	private MenuCategoriesPage  menuCategoriesPage;
	

	public HomePage() {
		launchBrowser();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		menuCategoriesPage=new MenuCategoriesPage();
		recommendedProductsPage=new RecommendedProductsPage();

	}
	
	
	

	public RecommendedProductsPage getRecommendedProductsPage() {
		return recommendedProductsPage;
	}


	public MenuCategoriesPage getMenuCategoriesPage() {
		return menuCategoriesPage;
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
		return isDisplayed(menuCategoriesPage.getCategoryMenu());
	}
	
	public void scrollRecommendedItems() {
		scrollToWebElement(recommendedItems);
	}
	public boolean recommendedItemsIsDisplayed() {
		return isDisplayed(recommendedItems);
	}
	



}
