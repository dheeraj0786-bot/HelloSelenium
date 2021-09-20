package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericsUtils.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {
	
	     
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getSelectOrgNameImg() {
		return selectOrgNameImg;
	}

	public WebElement getExpCloseDateBtn() {
		return expCloseDateBtn;
	}

	public WebElement getSalesStageDropdown() {
		return salesStageDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(name="potentialname")
	private WebElement oppNameEdt;

	@FindBy(xpath="//img[@alt='Select']")    //img[@alt='Select']
	private WebElement selectOrgNameImg;
	
	@FindBy(xpath="//a[text()='apple']")
	private WebElement selectOrgName;
	
	public WebElement getGroupBtn() {
		return groupBtn;
	}



	public WebElement getSelectTeam() {
		return selectTeam;
	}
	@FindBy(xpath="//input[@name='assigntype' and @value ='T']")
	private WebElement groupBtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement selectTeam;
	
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement expCloseDateBtn;
	

	

	//@FindBy(xpath="//div[@class='calendar'][3]/table/tbody/tr[5]/td[6]")
	//private WebElement selectDateClick;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDropdown;
	
	/*public WebElement getSelectDate() {
		return selectDateClick;
	}*/

	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	
	
	
	
	//This method will create opportunity with mandatory field
	public void createOpportunity(String oppName,WebDriver driver, String stageName,String teamName)
	{
		oppNameEdt.sendKeys(oppName);
		selectOrgNameImg.click();
		
		switchToWindow(driver, "Accounts");
		 selectOrgName.click();
		
	    switchToWindow(driver,"Contacts");
	    groupBtn.click();
	    select(selectTeam, teamName);
		//expCloseDateBtn.click();
		//selectDateClick.click();
		
		select(salesStageDropdown, stageName);

		saveBtn.click();
		
	    
}
	
	public void cancelOpportunity(String oppName,WebDriver driver, String stageName,String teamName) throws InterruptedException
	{
		oppNameEdt.sendKeys(oppName);
		selectOrgNameImg.click();
		
		switchToWindow(driver, "Accounts");
		 selectOrgName.click();
		
	    switchToWindow(driver,"Contacts");
	    groupBtn.click();
	    select(selectTeam, teamName);
		//expCloseDateBtn.click();
		//selectDateClick.click();
		
		select(salesStageDropdown, stageName);
		Thread.sleep(5000);
		cancelBtn.click();
	    
	}
	
	public void withOutFillingAllField(String oppName,WebDriver driver, String stageName,String teamName)
	{
		oppNameEdt.sendKeys(oppName);
		selectOrgNameImg.click();
		
		switchToWindow(driver, "Accounts");
		 selectOrgName.click();
		
	    switchToWindow(driver,"Contacts");
	    groupBtn.click();
	    select(selectTeam, teamName);
		//expCloseDateBtn.click();
		//selectDateClick.click();
		
		select(salesStageDropdown, stageName);
		oppNameEdt.clear();
		saveBtn.click();

		
	    getTextAlert(driver);
	}
	
	
		
}


