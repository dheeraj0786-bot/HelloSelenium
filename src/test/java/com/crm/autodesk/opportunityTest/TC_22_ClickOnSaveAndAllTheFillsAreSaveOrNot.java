package com.crm.autodesk.opportunityTest;




import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.BaseClass;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;

import com.crm.autodesk.elementRepository.CreateOpportunityPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OpportunityInfoPage;
import com.crm.autodesk.elementRepository.OpportunityPage;

@Listeners(com.crm.Vtiger.genericsUtils.Listeners.class)
public class TC_22_ClickOnSaveAndAllTheFillsAreSaveOrNot extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void createOpportunityWithOrganization() throws Throwable
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
				cop.createOpportunity(OppName, driver, StageName1, TeamName);
				
                //validation 
				
				OpportunityInfoPage oip=new OpportunityInfoPage(driver);
				String actualOppname = oip.oppInfo();
				
				Assert.assertTrue(actualOppname.contains(OppName));
				System.out.println(actualOppname);
				System.out.println("Test case passed");
				Assert.assertEquals(true, false);


}
}

