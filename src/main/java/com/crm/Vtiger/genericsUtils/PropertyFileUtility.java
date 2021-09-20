package com.crm.Vtiger.genericsUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



/**
 * 
 * @author Dheeraj
 * This class contains generic methods to read data from property file
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method reads data from property file 
	 * @throws Throwable 
	 */
	public String getPropertFileData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathContains.PropertyFilePath);
		Properties  p=new Properties();
	    p.load(fis);
	    String value= p.getProperty(key);
		return value; 
		
		
	}

}
