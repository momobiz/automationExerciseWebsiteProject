package com.automationExerciceWebsiteProject.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.automationExerciceWebsiteProject.Page.AccountCreatedPage;
import com.automationExerciceWebsiteProject.Page.CartPage;
import com.automationExerciceWebsiteProject.Page.DeleteAccountPage;
import com.automationExerciceWebsiteProject.Page.EnterYourContactInformationPage;
import com.automationExerciceWebsiteProject.Page.GetInTouchPage;
import com.automationExerciceWebsiteProject.Page.HomePage;
import com.automationExerciceWebsiteProject.Page.PayementPage;
import com.automationExerciceWebsiteProject.Page.ProductDetailsPage;
import com.automationExerciceWebsiteProject.Page.CategoryPage;
import com.automationExerciceWebsiteProject.Page.ProductsPage;
import com.automationExerciceWebsiteProject.Page.SearchResultPage;
import com.automationExerciceWebsiteProject.Page.SignupLoginPage;
import com.automationExerciceWebsiteProject.Page.UserHomePage;
import com.automationExerciceWebsiteProject.utils.ReadDataSheet;

public abstract class BaseTest {

	public static HomePage homePage=null;
	public static SignupLoginPage signupLoginPage;
	public static EnterYourContactInformationPage enterYourContactInformationPage;
	public static AccountCreatedPage accountCreatedPage;
	public static UserHomePage userHomePage;
	public static DeleteAccountPage deleteAccountPage;
	public static GetInTouchPage getInTouchPage;
	public static ProductsPage productsPage;
	public static ProductDetailsPage productDetailsPage;
	public static SearchResultPage searchResultPage;
	public static CartPage cartPage;
	public static PayementPage payementPage;
	public static CategoryPage categoryPage;
	
    public static SoftAssert softAssert;
	public static Properties prop;
	public static Pattern p;

	public BaseTest() {

		try {
			prop = new Properties();
			softAssert=new SoftAssert();
			FileInputStream fs = new FileInputStream("./config/config.properties");
			prop.load(fs);
		} catch (IOException e) {
             System.out.println("cannot open config file");
			e.printStackTrace();
		}
	}

	@DataProvider
	public static String[][] readData() throws InvalidFormatException, IOException {
		return ReadDataSheet.readData(prop.getProperty("sheet1"));
	}

	public static String[] stringToTable(String str) {
		p=Pattern.compile(prop.getProperty("regex"));
		return p.split(str);
	}

	public static String generateMonthIndex(String monthFromSheet) {
       String[] monthes=stringToTable(prop.getProperty("monthes"));
		int monthIndex = -1;
		try {
			for (int i = 0; i < monthes.length; i++) {
				if (monthFromSheet.contains(monthes[i]))
					monthIndex = i + 1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return String.valueOf(monthIndex);

	}
	public static int convertStringtoInt(String str) {
		int i=0;
		try {
			i=Integer.parseInt(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		

	}

	@AfterMethod
	public void afterMethod() {
//		deleteAccountPage.closeWindow();
	}

}
