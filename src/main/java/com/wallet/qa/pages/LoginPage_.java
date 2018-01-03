package com.wallet.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallet.qa.base.WalletBase;

public class LoginPage_ extends WalletBase{
	
	@FindBy(name="email")
	//@CacheLookup
	WebElement email;
	
	@FindBy(name="password")
	//@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//button[contains(text(),'Forgot password?')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//a[contains(text(),'Create account')]")
	WebElement createAccount;
	
	@FindBy(xpath="html/body/wallet-plus/wp-login/div/div[2]/div/div[1]")
	WebElement logo;
	
	
	public LoginPage_(){
		//super();
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS---------------------------------------------------------------------- >
	
	public RegistrationPage_ clickOnCreateAccount(){
		createAccount.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //Mandate
		return new RegistrationPage_();
	}
	
	public HomePage_ userLogin(){
		email.sendKeys(prop.getProperty("walletplus_USR"));
		password.sendKeys(prop.getProperty("walletplus_PWD"));
		login.click();
		return new HomePage_();
	}
	
	public HomePage_ userLoginToAddfunds(String loginId){
		email.sendKeys(loginId);
		password.sendKeys(prop.getProperty("addfunds_loginPassword"));
		login.click();
		return new HomePage_();
	}
	
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	

}
