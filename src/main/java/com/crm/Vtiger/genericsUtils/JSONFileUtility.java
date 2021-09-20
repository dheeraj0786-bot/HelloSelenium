package com.crm.Vtiger.genericsUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

/**
 * 
 * @author Dheeraj
 *
 */
public class JSONFileUtility {
	/**
	 * this method reads the data from json file
	 * @throws Throwable 
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws Throwable 
	 * 
	 */
	public String readDataFromJson(String key) throws Throwable
	{
			//read the data from json file
			FileReader file= new FileReader("./commonData.json");
			
			//convert the json file into java object
			JSONParser jsonobj = new JSONParser();
			Object jobj = jsonobj.parse(file);
			
			//type cast java ob to hashmap
			HashMap map=(HashMap)jobj;
			String value=map.get(key).toString();
			
			//return the value
			
			
		
		return value;
		}

}
