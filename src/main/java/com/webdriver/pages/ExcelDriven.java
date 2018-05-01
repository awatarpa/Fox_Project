package com.webdriver.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class ExcelDriven {
	
	//private XSSFCell cell = null;

	public static XSSFWorkbook wb;

	public static XSSFSheet sheet;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static FileInputStream fis;

	//-----------------------------Update Rows In Excel Sheet--------------------------------------------------------
	
	public boolean updateXLSRow(String xlsFilePath, String sheetName, String[][] obj) {
		boolean result = false;
		try {
			System.out.println("Start Updating Datasheet Rows ...");
			
			FileInputStream input_document = new FileInputStream(new File(xlsFilePath));

			wb = new XSSFWorkbook(input_document);
			sheet = wb.getSheet(sheetName);
			
			int iRows=obj.length;
		    int iCols=obj[0].length;
		
		    for (int iR_count=0;iR_count<=iRows-1;iR_count++ )
		    {
		        Row row = sheet.createRow(iR_count);
		        for (int iC_count=0;iC_count<=iCols-1;iC_count++)
		        {
		            row.createCell(iC_count).setCellValue(obj[iR_count][iC_count]);
		        }
		    }
		    //Close input stream

		    input_document.close();

		    //Create an object of FileOutputStream class to create write data in excel file

		    FileOutputStream outputStream = new FileOutputStream(xlsFilePath);

		    //write data in the excel file

		    wb.write(outputStream);

		    //close output stream

		    outputStream.close();

			
}
		
catch (Exception e) {
	     System.out.print("file not created ");
		}
		return result;
		}

//--------------------------------Read rows from Excel Sheet--------------------------------------------------
	
public Object[][] getCellData(String xlsFilePath, String sheetname) throws Exception{
	String[][] data = null; 
	boolean result = false;
	try {
		System.out.println("Start Reading Datasheet Rows ...");
		FileInputStream input_document = new FileInputStream(new File(xlsFilePath));

		wb = new XSSFWorkbook(input_document);
		sheet = wb.getSheet(sheetname);
		row = sheet.getRow(0);
		 
		int colCount = row.getLastCellNum();
		//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		int rowCount = sheet.getLastRowNum() + 1;

		data = new String[rowCount][colCount];
        // Loop over first 10 column and lines
   //     System.out.println(sheet.getColumns() +  " " +sheet.getRows());
        for (int j = 0; j <colCount; j++) 
        {
            for (int i = 0; i < rowCount; i++) 
            {
            	row=sheet.getRow(i);

            	cell=row.getCell(j);
                //Cell cell = sheet.getCell(i, j);
                data[i][j] = cell.getStringCellValue();
              //  System.out.println(cell.getContents());
            }
        }
    		
}
	
catch (Exception e) {
	 System.out.print("File not found");
	}
	return data;
}
}



