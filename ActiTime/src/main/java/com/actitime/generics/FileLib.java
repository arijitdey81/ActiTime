package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.usermodel.Workbook;

public class FileLib {
	
	public String getProperty(String Key, String path) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(Key);
		return data;
	}
	/*public String getExcelData(String Sheetname,int row,int cell, String path) throws FileNotFoundException {
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=Workbook
		
		
	}*/
	
	/*public void setExcelData(String sheetname,int row,int cell, String path);{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=new WorkbookFactory(fis);
		wb.getSheet(sheetname).get
	}*/
	

}
