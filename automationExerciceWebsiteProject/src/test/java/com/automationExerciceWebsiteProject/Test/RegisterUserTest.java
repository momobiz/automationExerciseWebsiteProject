package com.automationExerciceWebsiteProject.Test;

import org.testng.annotations.Test;

import com.automationExerciceWebsiteProject.Page.HomePage;

import org.testng.annotations.BeforeMethod;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;

public class RegisterUserTest extends BaseTest {
	
	public RegisterUserTest() {
		super();
	}

	@Test(dataProvider = "readData")
	public void registration(String gender, String userName, String userEmail, String userPassword, String birth,
			String newsletter, String userFirstname, String userLastName, String userCompany, String userAdress1,
			String userAdress2, String userCountry, String userState, String userCity, String userZipcode,
			String userPhoneNumber) {

		String[] birthDate = stringToTable(birth);
		String dayOfBirth = birthDate[0];
		String monthOfBirth = generateMonthIndex(birthDate[1]);
		String yearOfBirth = birthDate[2];
		String[] options = stringToTable(newsletter);

		// Verify that home page is visible successfully
		Assert.assertTrue(homePage.homePageIsVisibleSuccessfully());
		// Click on 'Signup / Login' button
		signupLoginPage = homePage.createAccount();
		// Verify 'New User Signup!' is visible
		Assert.assertTrue(signupLoginPage.newUserSignupIsVisible());
		// Enter name and email address
		// Click Signup button
		enterYourContactInformationPage = signupLoginPage.signup(userName, userEmail);
		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		Assert.assertTrue(enterYourContactInformationPage.enterContactInformationIsVisible());
		// Fill details: Title, Name, Email, Password, Date of birth
		// Select checkbox 'Sign up for our newsletter!'
		// Select checkbox 'Receive special offers from our partners!'
		// Fill details: First name, Last name, Company, Address, Address2, Country,
		// State, City, Zipcode, Mobile Number
		// Click 'Create Account button'

		accountCreatedPage = enterYourContactInformationPage.enterYourInformation(gender, userName, userPassword,
				dayOfBirth, monthOfBirth, yearOfBirth, options, userFirstname, userLastName, userCompany, userAdress1,
				userAdress2, userCountry, userState, userCity, userZipcode, userPhoneNumber);
		// Verify that 'ACCOUNT CREATED!' is visible
		Assert.assertTrue(accountCreatedPage.accountCreatedIsVisible());
		// Click 'Continue' button
		userHomePage = accountCreatedPage.moveToUserHomePage();
		// Verify that 'Logged in as username' is visible
		Assert.assertEquals(userHomePage.loggedInAsUsername(), "Logged in as " + userName);
		// Click 'Delete Account' button
		deleteAccountPage = userHomePage.deleteAccount();
		// Verify that 'ACCOUNT DELETED!' is visible
		Assert.assertEquals(deleteAccountPage.accountIsDeleted(), "ACCOUNT DELETED!");

	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		homePage = new HomePage();
//		
//
//	}
//
//	@AfterMethod
//	public void afterMethod() {
////		deleteAccountPage.closeWindow();
//	}

}
