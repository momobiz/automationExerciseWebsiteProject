package com.automationExerciceWebsiteProject.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automationExerciceWebsiteProject.utils.ReadDataSheet;

public class BrouillonDeTest {

	public static void main(String[] args) throws InvalidFormatException, IOException {
       
		String monthFromSheet="march";
			
		String[] monthes = { "ja", "fév", "mar", "av", "mai", "ju", "juil", "au", "sep", "oct", "nov", "dec" };

		int monthIndex=-1;
		try {
			for (int i = 0; i < monthes.length; i++) {
				if (monthFromSheet.contains(monthes[i]))
					monthIndex = i + 1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(String.valueOf(monthIndex)); ;
			
	}

}
