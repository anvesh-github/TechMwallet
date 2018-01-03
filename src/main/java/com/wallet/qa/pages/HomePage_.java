package com.wallet.qa.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallet.qa.base.WalletBase;
import com.wallet.utils.TestUtils;

public class HomePage_ extends WalletBase{
	
	@FindBy(xpath="//button[contains(text(),'Add Funds')]")
	WebElement addFund;
	
	@FindBy(xpath="//button[contains(text(),'Withdraw Funds')]")
	WebElement withDrawFund;
	
	@FindBy(xpath="//button[contains(text(),'Add a bank account')]")
	WebElement addBank;
	
	@FindBy(xpath="//button[contains(text(),'Add a Credit/Debit Card')]")
	WebElement addCardInHome;
	
	@FindBy(xpath="//a[contains(text(),'Transactions')]")
	WebElement transactions;
	
	@FindBy(xpath="//a[contains(text(),'Wallet')]")
	WebElement wallet;
	
	@FindBy(xpath="//a[contains(text(),'Account settings')]")
	WebElement accountSettings;
	
	@FindBy(xpath="//div[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath="//input[@ngcontrol='amt' and @placeholder='Enter Amount']")
	WebElement paymentAmount;
	
	//@FindBy(xpath="//button[contains(text(),'Next')]")
	@FindBy(xpath="//control-messages//following-sibling::button[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//label[@class='subHeader sec']//following-sibling::button[text()='Add credit/debit card']")
	WebElement addCard;
	
	@FindBy(xpath="//label[@class='title inlineImp']//following-sibling::input[@ngcontrol='cardNo' and @placeholder='Card Number']")
	WebElement cardNo;
	
	@FindBy(xpath="//div[@class='step5']//preceding-sibling::div[@class='step4']//button[text()='PAY']")
	WebElement pay01;
	
	@FindBy(xpath="//control-messages//following-sibling::input[@ngcontrol='expiry'  and @placeholder='MM/YY']")
	WebElement expiry;
	
	@FindBy(xpath="//input[@placeholder='MM/YY']//following-sibling::input[@ngcontrol='cvv' and @placeholder='CVV']")
	WebElement cvv;
	
	@FindBy(xpath="//input[@placeholder='CVV']//following-sibling::button[contains(text(),'PAY')]")
	WebElement pay02;
	
	@FindBy(xpath="//input[@placeholder='Last Name']//following-sibling::button[text()='PAY']")
	WebElement pay03;
	
	@FindBy(xpath="//button[contains(text(),'DONE')]")
	WebElement done;
	
	@FindBy(xpath="//button[contains(text(),'Log out')]")
	WebElement logOut;
	
	////
	
	public HomePage_(){
		PageFactory.initElements(driver, this);
	}
	
	
	//ACTIONS ---------------------------------------------------------------------------------->
	
	
	public String getHomePageURL(){
		String URL = driver.getCurrentUrl();
		return URL;
	}
	
	public LoginPage_ addFunds(String cardNO){ //String cardNo
		
	int amount = TestUtils.randomRange(Integer.parseInt(prop.getProperty("MinAmount")), Integer.parseInt(prop.getProperty("MaxAmount")));
	int CVV = TestUtils.getCVV();
	WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("element_timeout")));
	
	try {
	addFund.click();
	/*System.out.println("amount is " + amount);
	System.out.println("amount is " + String.valueOf(amount).substring(1));
	System.out.println("CVV is " +CVV);
	System.out.println("CVV is " +String.valueOf(CVV));*/
	paymentAmount.clear();
	paymentAmount.sendKeys(String.valueOf(amount));
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(next));
	next.click();
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(addCard));
	addCard.click();
	//Thread.sleep(2000);
	this.cardNo.clear();
	this.cardNo.sendKeys(cardNO);
	Thread.sleep(2500);//Mandate
	wait.until(ExpectedConditions.elementToBeClickable(pay01));
	pay01.click();
	//Thread.sleep(2000);
	expiry.sendKeys(prop.getProperty("expiry"));
	cvv.sendKeys(String.valueOf(CVV));
	wait.until(ExpectedConditions.elementToBeClickable(pay02));
	pay02.click();
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(pay03));
	pay03.click();
	Thread.sleep(2500);
	wait.until(ExpectedConditions.elementToBeClickable(done));
	done.click();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}catch(ElementNotInteractableException ei){
		ei.printStackTrace();
	}
	
	logOut.click();
	return new LoginPage_();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
