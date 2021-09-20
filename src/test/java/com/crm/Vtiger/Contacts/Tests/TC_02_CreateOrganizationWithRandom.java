package com.crm.Vtiger.Contacts.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;
import com.crm.Vtiger.genericsUtils.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02_CreateOrganizationWithRandom {
	WebDriver driver;
	@Test
	public void createOrganizationWithRandom() throws Throwable
	{
		/**
		 * Read all the necessary data
		 */
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility rn = new JavaUtility();
		int rand = rn.getRandomNum();
		
		
		String URL=jsonLib.readDataFromJson("url");
		String USERNAME=jsonLib.readDataFromJson("username");
		String PASSWORD=jsonLib.readDataFromJson("password");
		String Browser=jsonLib.readDataFromJson("browser");
		
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
		
		//click on organization 
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//create organization
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName+rand);
		WebElement element = driver.findElement(By.name("industry"));
		wLib.select(element, "Education");
		
		driver.findElement(By.name("button")).click();
		

	
		
		

}
}
