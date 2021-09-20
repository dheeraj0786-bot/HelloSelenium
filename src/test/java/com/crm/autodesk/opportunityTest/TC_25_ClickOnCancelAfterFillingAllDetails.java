package com.crm.autodesk.opportunityTest;

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
import com.crm.autodesk.elementRepository.CreateOpportunityPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OpportunityInfoPage;
import com.crm.autodesk.elementRepository.OpportunityPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.Vtiger.genericsUtils.Listeners.class)
public class TC_25_ClickOnCancelAfterFillingAllDetails extends BaseClass {
	@Test(groups="Regression")
	public void createOpportunityWithOrganizationTestCae25() throws Throwable
	{
		/**
		 * Read all the necessary data
		 */
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		
		
		//get all the data
		String OppName=pLib.getPropertFileData("oppNameEdt")+jLib.getRandomNum();
		String StageName1 = pLib.getPropertFileData("stageName1");
		String TeamName= pLib.getPropertFileData("teamName");
		
		
		
		        HomePage hp=new HomePage(driver);
                hp.clickOnOpportunities();
		
				
				OpportunityPage op=new OpportunityPage(driver);
				op.clickOnCreateOppImg();
				
				CreateOpportunityPage cop=new CreateOpportunityPage(driver);
				//cop.createOpportunity(OppName, driver, StageName1, TeamName);
				
                //validation 
				
				/*OpportunityPage oip=new OpportunityPage(driver);
				String actualOppname = oip.oppInfo();
				System.out.println(actualOppname);*/
				
				//CreateOpportunityPage copCancel=new CreateOpportunityPage(driver);
				cop.cancelOpportunity(OppName, driver, StageName1, TeamName);
				
				//Assert.assertTrue(actualOppname.contains(OppName));
				System.out.println("Test case passed");
				Assert.assertEquals(true, false);

	}

}
