package com.crm.autodesk.elementRepository;
/**
 * This class take user to home page
 * @author Dheeraj
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericsUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath=" //img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getOpportunitieLink() {
		return opportunitieLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(linkText="Opportunities")
	private WebElement opportunitieLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}


	@FindBy(linkText="Email")
	private WebElement  emailLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnOraganizations()
	{
		organizationLink.click();
	
	}
	public void clickOnContacts()
	{
		contactLink.click();
	}
	
	public void signOutLink(WebDriver driver)
	{
		mouseHover(driver, administatorImg);
		signoutLink.click();
	}
	
	public void clickOnOpportunities()
	{
		opportunitieLink.click();
	}
	public void clickOnLeads()
	{
		leadsLink.click();
	}
	
	public void clickOnEmail()
	{
		emailLink.click();
	}
	

}
