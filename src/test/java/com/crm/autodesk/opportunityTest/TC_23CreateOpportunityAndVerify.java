package com.crm.autodesk.opportunityTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.BaseClass;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;
import com.crm.autodesk.elementRepository.CreateOpportunityPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OpportunityPage;
@Listeners(com.crm.Vtiger.genericsUtils.Listeners.class)
public class TC_23CreateOpportunityAndVerify extends BaseClass {
	@Test(groups="Regression")
	public void createOpportunityAndVerify() throws Throwable
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
			String VerifyTxt=pLib.getPropertFileData("verifytxt");
			
			         HomePage hp=new HomePage(driver);
                      hp.clickOnOpportunities();
					OpportunityPage op=new OpportunityPage(driver);
					op.clickOnCreateOppImg();
					
					CreateOpportunityPage cop=new CreateOpportunityPage(driver);
					//cop.createOpportunity(OppName, driver, StageName1, TeamName);
					cop.withOutFillingAllField(OppName, driver, StageName1, TeamName);
					String actualText=cop.getTextAlert(driver);
					
					Assert.assertTrue(actualText.contains(VerifyTxt));
					System.out.println(actualText);
					cop.acceptAlert(driver);
					
					Assert.assertEquals(true, false);

					
					


	}

}
