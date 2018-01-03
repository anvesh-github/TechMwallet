package com.wallet.utils;

//import java.io.File;
//import org.apache.commons.io.FileUtils;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallet.qa.base.WalletBase;

public class TestUtils extends WalletBase{
	
	public static Select explicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("explicit_timeout")));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select countryList = new Select(element);
		return countryList;
	}
	
	
	public static int randomRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
    }
	
	
	public static int getCVV()
	{
	   int min = 100; int max = 1000;
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
    }
	
	/*public static void takeScreenshotAtEndOfTest(){
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
           FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
	}*/

}
