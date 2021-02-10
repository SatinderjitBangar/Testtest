package com.CPM.qa.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 

{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//Method to count the number of the rows
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}

	//Method to count the number of the columns
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	//Method to read the data from the particular cell
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	//Reads the data from the xlsx from the path provided
/*	public static Object[][] getData(String path) throws IOException
	{
		//no of rows  in the XL data sheet
		int rownum= getRowCount(path, "Sheet1");
		
		// no of columns in the XL data sheet
		int colcount=getCellCount(path,"Sheet1",1); 
		
		// Create a two dimensional string array 
		// Should be the same size of that of the XL sheet
		Object data[][]=new Object[rownum][colcount];  
		
		// Read data and store it in a 2 dimensional array
		// Starting from 1 since index 0 is the header part
		for(int i=1;i<=rownum;i++)
		{
			// increment the columns
			for(int j=0;j<colcount;j++)// Since the col values start from index 0
			{
				// Get data from getCellData() method and store in a 2D array
				data[i-1][j]= getCellData(path,"Sheet1", i,j);// i is row and j is column
			}
		}
		return data; // returning 2D Array
	} */
	
	public static Object [][] getData(String path, String sheetName) throws IOException
	{	 
		//Get the row count
		int rownum=XLUtils.getRowCount(path, sheetName);
		//Get the column count
		int colcount=XLUtils.getCellCount(path,sheetName,1);
		Object cellData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				cellData[i-1][j]=XLUtils.getCellData(path,sheetName, i,j);
			}
		}
		return cellData;
	}

	
	
}
