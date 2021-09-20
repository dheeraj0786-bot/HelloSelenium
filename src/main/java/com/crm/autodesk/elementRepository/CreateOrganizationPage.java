package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericsUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@name='button']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//This method will create organization with mandatory field
	public void createOrganization(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	//This method will create organization by choosing industry type
	public void createOrganizationWithIndustry(String orgName, String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropDown, indType);
		saveBtn.click();
		
		
	}

}

