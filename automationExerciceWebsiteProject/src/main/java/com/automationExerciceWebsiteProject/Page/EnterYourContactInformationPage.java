package com.automationExerciceWebsiteProject.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterYourContactInformationPage extends BasePage {

	By enterContactInformation = By.xpath("//b[contains(text(),'Enter Account Information')]");
	By genders = By.xpath("//input[@type='radio']");
	By name = By.cssSelector("#name");
	By password = By.cssSelector("#password");
	By selectDayOfBirth = By.cssSelector("#days");
	By selectMonthOfBirth = By.cssSelector("#months");
	By selectYearOfBirth = By.cssSelector("#years");
	By checkboxes = By.xpath("//input[@type='checkbox']");
	By firstname = By.cssSelector("#first_name");
	By lastname = By.cssSelector("#last_name");
	By company = By.cssSelector("#company");
	By adress1 = By.cssSelector("#address1");
	By adress2 = By.cssSelector("#address2");
	By country = By.cssSelector("#country");
	By state = By.cssSelector("#state");
	By city = By.cssSelector("#city");
	By zipcode = By.cssSelector("#zipcode");
	By mobileNumber = By.cssSelector("#mobile_number");
	By createAccountButton = By.cssSelector("#form > div > div > div > div.login-form > form > button");

	public boolean enterContactInformationIsVisible() {
		return isDisplayed(enterContactInformation);

	}

	public AccountCreatedPage enterYourInformation(String gender, String userName, String userPassword, String day,
			String month, String year, String[] option, String userFirstname, String userLastName, String userCompany,
			String userAdress1, String userAdress2, String userCountry, String userState, String userCity,
			String zipcodeUser, String mobileNumberUser

	) {
		
		
		
		selectGender(genders, toCamelcase(gender));
		fillInput(name, userName);
		fillInput(password, userPassword);
		scrollDown(200);
		selectOption(selectDayOfBirth, day);
		selectOption(selectMonthOfBirth, month);
		selectOption(selectYearOfBirth, year);
		selectCheckbox(checkboxes, option);
		scrollDown(200);
		fillInput(firstname, userFirstname);
		fillInput(lastname, userLastName);
		fillInput(company, userCompany);
		fillInput(adress1, userAdress1);
		fillInput(adress2, userAdress2);
		scrollDown(200);
		selectOption(country,toCamelcase(userCountry));
		fillInput(state, userState);
		scrollDown(350);
		fillInput(city, userCity);
		fillInput(zipcode, zipcodeUser);
		scrollDown(200);
		fillInput(mobileNumber, mobileNumberUser);
		
	
		
		clickOn(createAccountButton);

		return new AccountCreatedPage();

	}

}
