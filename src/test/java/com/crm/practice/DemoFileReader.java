package com.crm.practice;

import com.crm.Vtiger.genericsUtils.JSONFileUtility;

public class DemoFileReader {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		JSONFileUtility s = new JSONFileUtility();
		System.out.println(s.readDataFromJson("browser"));

	}

}
