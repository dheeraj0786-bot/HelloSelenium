package com.crm.autodesk.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;
import com.crm.Vtiger.genericsUtils.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03_CreateOrganizationWithIndustry {
	WebDriver driver;

	@Test
	public void createOrganizationTest() throws Throwable
	{
		
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		
		String URL=jsonLib.readDataFromJson("url");
		String USERNAME=jsonLib.readDataFromJson("username");
		String PASSWORD=jsonLib.readDataFromJson("password");
		String Browser=jsonLib.readDataFromJson("browser");
		String Industry =pLib.getPropertFileData("indType");
		
		//get all the data
		String OrgName=pLib.getPropertFileData("OrgName")+jLib.getRandomNum();
		
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
				LoginPage lp=new LoginPage(driver);
				lp.login(USERNAME, PASSWORD);
				
		//Navigate to Organization page
				
				HomePage hp=new HomePage(driver);
				hp.clickOnOraganizations();
				
		//Navigate to create Organization page
				OrganizationsPage orgPage=new OrganizationsPage(driver);
				orgPage.clickOnCreateOrgImg();
				
	   // create organization
				CreateOrganizationPage createOrgP=new CreateOrganizationPage(driver);
				createOrgP.createOrganizationWithIndustry(OrgName, Industry);
				//createOrgP.getSaveBtn();
				
				
	  
				
		// validation 
				OrganizationsInfoPage orgInfoP=new OrganizationsInfoPage(driver);
			  
				String actualOrgInfo = orgInfoP.getOrganizationinfo();
		/*validation using if else		
				if(actualOrgInfo.contains(OrgName))
				{
					System.out.println("Test script passed");
					System.out.println(actualOrgInfo);
				}
				else {
					System.out.println("oops....!! Test script failed");
				}
				*/
				
		//validation using assert
				Assert.assertTrue(actualOrgInfo.contains(OrgName));
				System.out.println(actualOrgInfo);
				
				String actualIndPage = orgInfoP.getIndustriesInfo();
				Assert.assertTrue(actualIndPage.contains(Industry));
				System.out.println(actualIndPage);

}}
