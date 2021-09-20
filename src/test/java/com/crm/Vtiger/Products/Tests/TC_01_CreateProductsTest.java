package com.crm.Vtiger.Products.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;
import com.crm.Vtiger.genericsUtils.JavaUtility;
import com.crm.Vtiger.genericsUtils.PropertyFileUtility;
import com.crm.Vtiger.genericsUtils.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class will create the product
 */

public class TC_01_CreateProductsTest {
	WebDriver driver;
	@Test
	public void createProduct() throws Throwable
	{
		/**
		 * Read all the necessary data
		 */
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		JavaUtility rn = new JavaUtility();
		int rand = rn.getRandomNum();
		
		String URL=jsonLib.readDataFromJson("url");
		String USERNAME=jsonLib.readDataFromJson("username");
		String PASSWORD=jsonLib.readDataFromJson("password");
		String Browser=jsonLib.readDataFromJson("browser");
		String productName =pLib.getPropertFileData("ProductName");
		String partName=pLib.getPropertFileData("PortNumber");
		/**
		 * Launch the browser
		 */
		WebDriverManager.chromedriver().setup();
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}else {
			System.err.println("browser not launched");
		}
		
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on products module
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.id("productcode")).sendKeys(partName+rand);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify the portNumber
		driver.findElement(By.linkText("Products")).click();
		
		WebElement element = driver.findElement(By.id("bas_searchfield"));
		wLib.select(element, "Part Number");
		driver.findElement(By.name("search_text")).sendKeys(partName);
		driver.findElement(By.name("submit")).click();
		
		 List<WebElement> element1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
		 for(WebElement wb:element1)
		 {
			  String actText = wb.getText()  ;
					  //System.out.println(actText);  
			  if((actText).equals(partName+rand))
				{
					System.out.println("verified");
					System.out.println(actText+" "+"verified with"+" "+partName+rand);
				}
				
		 }
		
		
	}
	}
		
		
	

