package com.crm.Vtiger.genericsUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class conatins generic methods to rad data from excel sheet
 * @author Dheeraj
 *
 */

public class ExcelFileUtility {
	/**
	 * This method will read the data from excel
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 *
	 */
	public String getDataFromExcel(String sheet,int ro,int cel) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream("/.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row row=sh.getRow(ro);
		Cell cell=row.getCell(cel);
		String data=cell.getStringCellValue();
		wb.close();
		return data;
		
	}
	
	public void setDataIntoExcel(String sheet, int rowNum, int cellNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("/.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row row=sh.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("/.xlsx");
		wb.write(fos);
		wb.close();
	
	}

}
