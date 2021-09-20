package com.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromXmlTest {
	@Test
	public void readDataFromXML(XmlTest xmlObj)
	{
		WebDriver driver=null;
		String BROWSER=xmlObj.getParameter("browser");
		String URL=xmlObj.getParameter("url");
		String USERNAME=xmlObj.getParameter("username");
		String PASSWORD=xmlObj.getParameter("password");
		
		WebDriverManager.chromedriver().setup();
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("fireFox"))
		{
			driver=new FirefoxDriver();
		}else {
			System.out.println("invalid browser");
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}


}
