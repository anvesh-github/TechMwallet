package com.wallet.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wallet.qa.base.WalletBase;
import com.wallet.qa.pages.HomePage_;
import com.wallet.qa.pages.LoginPage_;
import com.wallet.utils.ExcelUtils;

public class HomePageTest extends WalletBase{

	LoginPage_ loginPage;
	HomePage_ homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage_();
		
	}
	
	@Test(dataProvider="addFundsData")
	public void addFunds(String loginID, String cardNO){
		homePage = loginPage.userLoginToAddfunds(loginID);
		loginPage = homePage.addFunds(cardNO);
		Assert.assertTrue(loginPage.validateLogo());
	}
	
	
	@DataProvider
	public Object[][] addFundsData()
	{
		Object[][] data;
		data = ExcelUtils.getTestData(prop.getProperty("DataSheet_cards"));
		return data;	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
