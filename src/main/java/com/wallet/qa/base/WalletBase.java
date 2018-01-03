package com.wallet.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.wallet.utils.WebEventListener;

public class WalletBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public WalletBase()
	{
		FileInputStream file = null;
		prop = new Properties();
		
		     try {
				file = new FileInputStream(".\\src\\main\\java\\com\\wallet\\qa\\configurations\\config.properties");
		     } catch (FileNotFoundException e) {
				 e.printStackTrace();
			 }
		     
		     try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	
	public static void initilization()
	{
		DesiredCapabilities caps;
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
			caps = DesiredCapabilities.firefox();
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(false);
			profile.setAssumeUntrustedCertificateIssuer(true);
			caps.setCapability(FirefoxDriver.PROFILE, profile);
			//caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			driver = new FirefoxDriver(caps);
		}
		else if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver");
		    caps = DesiredCapabilities.chrome();
			caps.setPlatform(Platform.WINDOWS);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
			driver = new ChromeDriver(caps);
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEdriver");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.
					  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(caps);
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("page_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("element_timeout")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("walletplus_URL"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
