package com.crm.Vtiger.genericsUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to read data  from database
 * @author Dheeraj
 *
 */

public class DataBaseUtility {
	Connection con;
	ResultSet result=null;
	Driver driverRef;
	/**
	 * connection with database is established
	 * @throws Throwable 
	 */
	
	public void connectionToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	}
	/**
	 * DB connection is closed 
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * this method will return the  data wrt coloumn index
	 * @throws Throwable 
	 */
	public String getDataFromDB(String query,int columnindex) throws Throwable
	{
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(columnindex);
		}
		return value;
	}
	/**
	 * Get data from DB and Verify
	 * @throws Throwable 
	 */
	public String getDataFromDB(String query,int columnName,String expData) throws Throwable
	{
		boolean flag=false;
		result =con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData + "data verified in database");
			return expData;
		}
		else {
			System.out.println(expData + "data not verified");
			return expData;
		}
	}
	

}
