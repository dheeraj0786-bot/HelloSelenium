package com.crm.autodesk.organizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.BaseClass;
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
@Listeners(com.crm.Vtiger.genericsUtils.Listeners.class)
public class TC_02_CreateOrganizationTest extends BaseClass {
	
	
	@Test
	public void createOrganizationTest() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		
		
		
		//get all the data
		String OrgName=pLib.getPropertFileData("OrgName")+jLib.getRandomNum();
		
		
		
				
		//Navigate to Organization page
				
				HomePage hp=new HomePage(driver);
				hp.clickOnOraganizations();
				
		//Navigate to create Organization page
				OrganizationsPage orgPage=new OrganizationsPage(driver);
				orgPage.clickOnCreateOrgImg();
				
	   // create organization
				CreateOrganizationPage createOrgP=new CreateOrganizationPage(driver);
				createOrgP.createOrganization(OrgName);
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
				//getScreenshot(actualOrgInfo);
				
		//validation using assert
				Assert.assertTrue(actualOrgInfo.contains(OrgName));
				System.out.println(actualOrgInfo);
				Assert.assertEquals(true, false);
	}

}
