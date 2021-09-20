package com.crm.practice;


/**
 * This class will help you to find the dynamic xpath
 * @author Dheeraj
 *
 */


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathGoogle {
	

	



		/**
		 * This method will help you to handle dynamic xpath in google
		 * @param args
		 */

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			//launching driver
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			//maximizing the window
			driver.manage().window().maximize();
			
		   //waiting statement
			//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//enter the url
			driver.get("https://www.google.com/");
			
		    // entering the data in search box
			driver.findElement(By.name("q")).sendKeys("java");
			
			List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
			System.out.println("total number of suggestions "+list.size());
			for(WebElement element:list)
			{
				System.out.println(element);//This provides id
				System.out.println(element.getText());//this will print the text of the webelement
				if(element.getText().equals("javascript"))
				{
					element.click();
					break;
				}
			}
			
			 
			

		}

	}



