package com.crm.autodesk.opportunityTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.crm.autodesk.elementRepository.CreateOpportunityPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OpportunityInfoPage;
import com.crm.autodesk.elementRepository.OpportunityPage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.crm.Vtiger.genericsUtils.Listeners.class)  in real time we don't use listeners here
//because for each test script i have to write listeners so instead we write listeners in testNG.xml file before suite tag
public class TC_21_CreateOpportunityWithSalesStageClosedLost extends BaseClass {
	
	@Test(groups="SmokeSuite",retryAnalyzer= com.crm.Vtiger.genericsUtils.RetryAnalyzer.class)
	public void createOpportunityWithOrganizationTestCase1() throws Throwable
	{
		/**
		 * Read all the necessary data
		 */
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		
				
		//get all the data
		String OppName=pLib.getPropertFileData("oppNameEdt")+jLib.getRandomNum();
		String StageName = pLib.getPropertFileData("stageName");
		String TeamName= pLib.getPropertFileData("teamName");
		
		
				
		 HomePage hp=new HomePage(driver);
         hp.clickOnOpportunities();
				
				OpportunityPage op=new OpportunityPage(driver);
				op.clickOnCreateOppImg();
				
				CreateOpportunityPage cop=new CreateOpportunityPage(driver);
				cop.createOpportunity(OppName, driver, StageName, TeamName);
				
				OpportunityInfoPage oip=new OpportunityInfoPage(driver);
				String actualOppname = oip.oppInfo();
			
				
				Assert.assertTrue(actualOppname.contains(OppName));
				System.out.println(actualOppname);
				System.out.println("Test case passed");
				Assert.assertEquals(true, false);
				
					
				
		
	

				
}
}
