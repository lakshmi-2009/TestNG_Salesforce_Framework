package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXfileUtilityFramework {
	
	public static void readCellDataFromXLfile(File path,String sheetName,int rowNum,int cellNum)  {
		
		XSSFWorkbook workbook=null;
		try {
			workbook = new XSSFWorkbook(path);
			
			System.out.println(workbook.getSheetName(0));
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			XSSFRow row= sheet.getRow(rowNum);
			XSSFCell cell= row.getCell(cellNum);
			
			
			if(cell.getCellType()==CellType.NUMERIC)
				System.out.println("data is = "+cell.getNumericCellValue());
			else if(cell.getCellType()==CellType.STRING)
				System.out.println("data is = "+cell.getStringCellValue());
				
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//   To read All Data from the Sheet//
	
	
	
	public static void readAllCellDataFromXLfile(File path,String sheetName) {
	
		XSSFWorkbook workbook=null;
		try {
			workbook = new XSSFWorkbook(path);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	    //we have to iterate through all sheet to get all rows and coloumns
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		  Iterator<Row> rows = sheet.iterator(); //iterates all rows
		  while(rows.hasNext()) {
			 Row row = rows.next();
			 
			 Iterator<Cell> cells = row.iterator(); //iterates all cells
			 while(cells.hasNext()) {
				 Cell cell = cells.next();
				 
				 if(cell.getCellType()==CellType.NUMERIC)
						System.out.println("data is = "+cell.getNumericCellValue());
					else if(cell.getCellType()==CellType.STRING)
						System.out.println("data is = "+cell.getStringCellValue());
				 
			 }
			 System.out.println();
		  }
		
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}

	public static void readAllCellDataFromXLfile(File path) {
		
		XSSFWorkbook workbook=null;
		try {
			workbook = new XSSFWorkbook(path);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Sheet> sheets = workbook.iterator(); // iterates through all sheets
		 while(sheets.hasNext()) {
			 Sheet sheet = sheets.next();
			 
			 Iterator<Row> rows = sheet.iterator(); //iterates all rows
			  while(rows.hasNext()) {
				 Row row = rows.next();
				 
				 Iterator<Cell> cells = row.iterator(); //iterates all cells
				 while(cells.hasNext()) {
					 Cell cell = cells.next();
					 
					 if(cell.getCellType()==CellType.NUMERIC)
							System.out.println("data is = "+cell.getNumericCellValue());
						else if(cell.getCellType()==CellType.STRING)
							System.out.println("data is = "+cell.getStringCellValue());
			 
		 }
		}System.out.println();
	  }
		 
		 try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}
		 
}
