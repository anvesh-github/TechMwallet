package com.wallet.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.wallet.qa.base.WalletBase;
//import com.wallet.utils.TestUtils;

public class RegistrationPage_ extends WalletBase{
	
	WebDriverWait waits;
	
	@FindBy(xpath = "//control-messages//preceding-sibling::input[@placeholder='Email Address']")
	//@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@ngcontrol='password' and @placeholder='Password']")
	//@CacheLookup
	WebElement passWord;
	
	@FindBy(xpath = "//input[@ngcontrol='cpswd' and @placeholder='Re-Enter Password']")
	//@CacheLookup
	WebElement rePassWord;
	
	@FindBy(xpath = "//div[@class='errorMsg']//following-sibling::button[contains(text(),'Continue')]")
	//@CacheLookup
	WebElement continue01;
	
	@FindBy(xpath = "//input[@ngcontrol='fName' and @placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@ngcontrol='lName' and @placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath = "//select[@id='countryData']")
	//@CacheLookup
	WebElement country;
	
	@FindBy(xpath = "//select[@ngcontrol='state']")
	//@CacheLookup
	WebElement state;
	
	@FindBy(xpath = "//input[@ngcontrol='addressline1' and @placeholder='Street Address']")
	WebElement street;
	
	@FindBy(xpath = "//input[@ngcontrol='city' and @placeholder='Town/City']")
	WebElement city;
	
	@FindBy(xpath = "//input[@ngcontrol='zip' and @placeholder='ZIP Code']")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@ngcontrol='mobile' and @placeholder='Phone Number']")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//select[@ngcontrol='currency']")
	WebElement currency;
	
	@FindBy(xpath = "//input[@placeholder='Date Of Birth']")
	//@CacheLookup
	WebElement dOB;
	
	@FindBy(xpath = "//select[@data-handler='selectYear']")
	//@CacheLookup
	WebElement year;
	
	@FindBy(xpath = "//select[@data-handler='selectMonth']")
	//@CacheLookup
	WebElement month;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
	WebElement calendar;
	
	@FindBy(xpath = "//input[@ngcontrol='isAccepted' and @type='checkbox']")
	WebElement termsAndConditionsCheck;
	
	@FindBy(xpath = "//input[@placeholder='Card number' and @ngcontrol='cardNo']")
	WebElement cardNumber;
	
	@FindBy(xpath = "//div[@class='alert  alert-danger']//preceding-sibling::button[contains(text(),'Continue')]")
	WebElement continue02;
	
	@FindBy(xpath = "//input[@ngcontrol='expiry' and @placeholder='MM/YY']")
	WebElement expiry;
	
	@FindBy(xpath = "//button[contains(text(),'Add card')]")
	WebElement addCard;
	
	@FindBy(xpath = "//div[@class='step2']//button[@class='wpBtn']//span[contains(text(),'Continue')]")
	WebElement continue03;
	
	@FindBy(xpath = "//button[contains(text(),'I will do this later')]")
	WebElement doThisLater;
	
	@FindBy(xpath = "//span[contains(text(),'Go to my account')]")
	WebElement goToMyAccount;
	
	
	public RegistrationPage_(){
		PageFactory.initElements(driver, this);
	}
	
	
	//ACTIONS ----------------------------------------------------------------------------->
	
	
	
	 public HomePage_ createWallet(String... userData)
	 
	  /*
	  public HomePage_ createWallet(String Name, String countryName, String stateName, String streetName,
			 String cityName, String zipCode, String phoneNo, String currencyCode,String birthDate,
			 String card)
	   String Name, 		 userData[0]
	   String countryName,   userData[1]
	   String stateName,     userData[2]
	   String streetName,    userData[3]
	   String cityName,      userData[4]
	   String zipCode,       userData[5]
	   String phoneNo,       userData[6]
	   String currencyCode,  userData[7]
	   String birthDate,     userData[8]
	   String card 			 userData[9]
	   */
	
	{
		
		String[] temp = userData[0].split(" "); //Name
		String fname = temp[0]; String lName = temp[2];
		String email = temp[0].concat(prop.getProperty("mailDomain"));
		temp = userData[8].split("/");          //birthDate
		String day = temp[1], month = temp[0], year = temp[2];
		waits = new WebDriverWait(driver, Long.parseLong(prop.getProperty("explicit_timeout")));
		
		/*System.out.println("day---"+day);
		System.out.println("month---"+month);
		System.out.println("year---"+year);*/
		
	try {
		
		this.email.clear();
		this.email.sendKeys(email.toLowerCase()); 
		passWord.clear();
		passWord.sendKeys(prop.getProperty("password"));
		rePassWord.clear();
		rePassWord.sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		continue01.click();
		waits.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(fname); 
		lastName.sendKeys(lName); 
		Thread.sleep(1000);
		waits.until(ExpectedConditions.elementToBeClickable(country));
		Select countryLists = new Select(country);
		countryLists.selectByVisibleText(prop.getProperty("countryname"));
		Thread.sleep(1000);
		waits.until(ExpectedConditions.elementToBeClickable(state));
		Select stateLists = new Select(state);
	    stateLists.selectByVisibleText(userData[2]);	 //stateName 
		street.sendKeys(userData[2]);  //streetName
		city.sendKeys(userData[4]);    //cityName
		this.zipCode.sendKeys(userData[5]);  //zipCode
		mobileNumber.sendKeys(userData[6]);  //phoneNo
		waits.until(ExpectedConditions.elementToBeClickable(currency));
		Select currencyList = new Select(currency);
		currencyList.selectByVisibleText(userData[7]);
		dOB.click();
		
		Thread.sleep(1000);
		waits.until(ExpectedConditions.elementToBeClickable(this.month));
		Select monthList = new Select(this.month);
		int mon = Integer.parseInt(month);
		monthList.selectByIndex(mon-1);
		
		Thread.sleep(1000);
		waits.until(ExpectedConditions.elementToBeClickable(this.year));
		Select yearList = new Select(this.year);
		yearList.selectByValue(year);
		
		List<WebElement> rowList = calendar.findElements(By.tagName("tr"));
		List<WebElement> columnList;
		boolean status = false;
		for(int i=0 ; i<rowList.size(); i++)
		{
			columnList = rowList.get(i).findElements(By.tagName("td"));
			//int columnListSize = columnList.size();
			for(WebElement tdElement :  columnList)
			{
				String dayNo = tdElement.getText();
				if(dayNo.length()==1)
				{
					dayNo = "0".concat(dayNo);
				}
				
				if(dayNo.equalsIgnoreCase(day))
				{
					tdElement.click();
					status = true;
					System.out.println("date selected "+status);
					break;
				}
			}
			
			if(status == true)
			{
				//System.out.println("Loop is broken");
				break;
			}
		}
		
		
		termsAndConditionsCheck.click();
		Thread.sleep(1000);
		waits.until(ExpectedConditions.visibilityOf(continue02));
		continue02.click();
		Thread.sleep(1000); //Mandate
		waits.until(ExpectedConditions.visibilityOf(cardNumber));
		cardNumber.sendKeys(userData[9]);  //card
		this.expiry.sendKeys(prop.getProperty("expiry"));
		Thread.sleep(1000);
		addCard.click();
		Thread.sleep(3000);
		continue03.click();
		waits.until(ExpectedConditions.visibilityOf(goToMyAccount));
		goToMyAccount.click();
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return new HomePage_();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
