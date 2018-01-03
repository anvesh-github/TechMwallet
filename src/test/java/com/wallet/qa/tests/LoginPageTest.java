package com.wallet.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallet.qa.base.WalletBase;
import com.wallet.qa.pages.HomePage_;
import com.wallet.qa.pages.LoginPage_;

public class LoginPageTest extends WalletBase{
	
	LoginPage_ loginPage;
	HomePage_ homePage;
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage_();
	}
	
	@Test(priority=1)
	public void verifyLogoTest(){
		Assert.assertTrue(loginPage.validateLogo());
	}
	
	
	@Test(priority=2)
	public void userLoginTest(){
		homePage = loginPage.userLogin();
	}
	
	
	@AfterMethod
	public void tearDown(){
		//driver.close();
		driver.quit();
	}
}
