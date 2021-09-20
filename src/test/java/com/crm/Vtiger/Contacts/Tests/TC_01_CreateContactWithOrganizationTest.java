package com.crm.Vtiger.Contacts.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;
import com.crm.Vtiger.genericsUtils.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_CreateContactWithOrganizationTest {
	WebDriver driver;
	@Test
	public void createContactWithOrganization() throws Throwable
	{
		/**
		 * Read all the necessary data
		 */
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		
		String URL=jsonLib.readDataFromJson("url");
		String USERNAME=jsonLib.readDataFromJson("username");
		String PASSWORD=jsonLib.readDataFromJson("password");
		String Browser=jsonLib.readDataFromJson("browser");
		
		String contactName =pLib.getPropertFileData("LastName");
		String OrgName=pLib.getPropertFileData("OrgName");
		
		/**
		 * Launch the browser
		 */
		WebDriverManager.chromedriver().setup();
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}else {
			System.err.println("browser not launched");
		}
		
		
		
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//click on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//click on create contact link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//create contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
	//switch to child window
		wLib.switchToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("DXC")).click();
		//driver.findElement(By.name("button")).click();
    // switch to parent window
		wLib.switchToWindow(driver,"Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
				
	}
	

}
