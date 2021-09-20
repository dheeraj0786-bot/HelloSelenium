package com.crm.Vtiger.genericsUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class conatains all the basic configuration annotations
 * @author Dheeraj
 *
 */

public class BaseClass {
	
	DataBaseUtility dLib=new DataBaseUtility();
	JSONFileUtility jsonLib=new JSONFileUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	//JavaUtility jLib=new JavaUtility();
	PropertyFileUtility pLib=new PropertyFileUtility();
	public WebDriver driver;
	public static WebDriver staticDriver;
	
	@BeforeSuite(groups= {"SmokeSuite","Regression"})
	public void connectDB()
	{
		//dLib.connectionToDB();
		System.out.println("******DBConnection****");
	}
	//@Parameters("Browser")
	@BeforeClass(groups= {"SmokeSuite","Regression"})
	public void launchBrowser() throws Throwable
	{
		System.out.println("********launch browser****");
		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL=jsonLib.readDataFromJson("url");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();
			
		}else
		{
			System.out.println("invalid browser");
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		staticDriver= driver;
	}
	
  	@BeforeMethod(groups= {"SmokeSuite","Regression"})
	public void loginToApp() throws Throwable {
		String USERNAME=jsonLib.readDataFromJson("username");
		String PASSWORD=jsonLib.readDataFromJson("password");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"SmokeSuite","Regression"})
	public void logoutToApp()
	{
		System.out.println("****logout to app");
		HomePage hp=new HomePage(driver);
		hp.signOutLink(driver);
		
	}
	
	@AfterClass(groups= {"SmokeSuite","Regression"})
	public void closeBrowser()
	{
		System.out.println("******close browser********");
		driver.close();
	}
	
	@AfterSuite(groups= {"SmokeSuite","Regression"})
	public void closeDB() throws Throwable
	{
		//dLib.closeDB();
		System.out.println("****close DB");
	}
	
	public String getScreenshot(String name) throws IOException
	{
		File srcFile= ((TakesScreenshot) staticDriver).getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finalDest=new File(destFile);
		FileUtils.copyFile(srcFile,finalDest);
		return destFile;
	}
	
	

}
