package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	
	public OpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateOppImg() {
		return createOppImg;
	}

	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement createOppImg;
	
	public void clickOnCreateOppImg()
	{
		createOppImg.click();
	}

}
