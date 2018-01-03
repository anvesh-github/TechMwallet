package com.wallet.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.wallet.qa.base.WalletBase;
import com.wallet.qa.pages.HomePage_;
import com.wallet.qa.pages.LoginPage_;
import com.wallet.qa.pages.RegistrationPage_;
import com.wallet.utils.ExcelUtils;



public class RegisterPageTests extends WalletBase{
	
	LoginPage_ loginPage;
	RegistrationPage_ registrationPage;
	HomePage_ homePage;
	
	public RegisterPageTests(){
		super();
	}
	
	@BeforeMethod
	public void registerUserTest(){
		initilization();
		loginPage = new LoginPage_();
		registrationPage = loginPage.clickOnCreateAccount();
	}
	
	
	@Test(dataProvider="getUserCreationData")
	public void createUserTest(String Name, String countryName, String stateName, String streetName,
			 String cityName, String zipCode, String phoneNo, String currencyCode,String birthDate,
			 String card){
		
		homePage = registrationPage.createWallet(Name, countryName, stateName, streetName, cityName, 
				                      zipCode, phoneNo, currencyCode, birthDate, card);
		
		Assert.assertEquals(homePage.getHomePageURL(), prop.getProperty("WalletHomePageURL"),"Test failed as not able to land"
				           + " to wallet home page");
	}
	
	
	@DataProvider
	public Object[][] getUserCreationData()
	{
		Object[][] data;
		data = ExcelUtils.getTestData(prop.getProperty("DataSheet_CreateAccount"));
		return data;
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
