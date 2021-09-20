package com.crm.Vtiger.genericsUtils;

import java.util.Random;

/**
 * This class contains generic methods pertaining to java
 * @author Dheeraj
 *
 */

public class JavaUtility {
	
	/**
	 * This method generates random number
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum =ran.nextInt(100);
		return randomNum;
				
	}

}
