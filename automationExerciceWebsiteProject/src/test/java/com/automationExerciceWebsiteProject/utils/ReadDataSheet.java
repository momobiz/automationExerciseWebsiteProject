package com.automationExerciceWebsiteProject.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ReadDataSheet {
	
	
	public static String[][] readData(String sheetName) throws InvalidFormatException, IOException{
		File fs=new File("data/dataAutomationExercise.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet(sheetName);
		XSSFCell cell;
		
		int Rows=sheet.getPhysicalNumberOfRows();
		int Columns=sheet.getRow(0).getLastCellNum();
		
		String[][] data= new String[Rows-2][Columns];
		
		for(int i=1;i<Rows-1;i++) {
			for(int j=0;j<Columns;j++) {
				cell=sheet.getRow(i).getCell(j);
				if(cell==null) {
					data[i-1][j]=" ";
				}
				else data[i-1][j]=cell.toString();
				
			}
		}
		wb.close();
		return data;
	}

}
