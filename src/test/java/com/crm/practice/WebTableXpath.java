package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableXpath {
	WebDriver driver;
	@Test
	public void tableXpath() throws Throwable
	{
		JSONFileUtility s = new JSONFileUtility();
		String BROWSER = s.readDataFromJson("browser");
		String URL = s.readDataFromJson("url");
		String PASSWORD = s.readDataFromJson("password");
		String USERNAME = s.readDataFromJson("username");
		WebDriverManager.chromedriver().setup();
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser did not match");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
			
				for(WebElement s1:list)
				{
					s1.click();
					
				}
				
				list.get(list.size()-1).click();
				
				
				List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
				for(WebElement wv:list2)
				{
					System.out.println(wv.getText());
				}
				 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[8]//a[text()='del']")).click();
				 Alert al = driver.switchTo().alert();
				 al.accept();
				 
				
				
				
			
				
				  
				
				
			
			
		

	
	}
}
