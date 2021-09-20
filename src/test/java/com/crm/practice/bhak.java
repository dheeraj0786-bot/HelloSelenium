package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bhak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li/a"));
		System.out.println(list.size());

		for(WebElement text:list)
		{
			System.out.println(text.getText());		}
		
		String curr = System.getProperty("user.dir");
		System.out.println(curr);
		

	}

}
