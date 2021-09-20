package com.crm.Vtiger.genericsUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

/**
 * This class contains all the generic methods related to WebDiver actions
 * @author Dheeraj
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method will wait until the page is load for 20 seconds
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	/**
	 * This method will maximize the window
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/* *
	 * This method enables user to handle drop-down using visible text
	 */
	public void select(WebElement element,String option)
	{
		Select select= new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * This method enables user to handle drop-down using index
	 */
	public void select(WebElement element,int option)
	{
		Select select=new Select(element);
		select.selectByIndex(option);
	}
	
	/**
	 * This method will perform mouse hover action 
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/** 
	 * This method will help user to switch from one window to another
	 */
	
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> winHandle = driver.getWindowHandles();
		Iterator<String> it = winHandle.iterator();
		while(it.hasNext())
		{
			String winid=it.next();
			String title=driver.switchTo().window(winid).getTitle();
			if(title.contains(partialWinTitle))
			{
				//driver.switchTo().window(title);
				break;
			}
		}
	}
	/**
	 * This method will accept the alert
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	//This method will give text of the alert
	public String getTextAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will cancel the alert pop up
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will used for scrolling action in a webpage
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0, "+y+")",element);
	}
/**
 * This method will switch the frame with respect to index
 */
	public void switchTOFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame with respect to id
	 */
	public void switchToFrame(WebDriver driver,String FrameId)
	{
		driver.switchTo().frame(FrameId);
	}
	
	/**
	 * This method will switch the frame with respect to element
	 */
	public void  switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
		
	}
	/**
	 * This method is used to pass the enter key apper into the browser
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}
