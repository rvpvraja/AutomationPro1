package com.vmetry.testutill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vmetry.TestBase.Intialization;

public class TestutilityClass extends Intialization {

	public static boolean isrunmode(String module) throws IOException {
		File f = new File("C:\\Users\\raja\\workspace\\EPFO\\src\\test\\resources\\Excel data\\Controller.xls");

		FileInputStream fis = new FileInputStream(f);
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheetAt(0);
		int rownum = sh.getLastRowNum() + 1;
		int colnum = sh.getRow(0).getLastCellNum();
		System.out.println("row num is: " + rownum);
		System.out.println("col num is: " + colnum);
		for (int i = 1; i < rownum; i++) {
			Row rw = sh.getRow(i);

			for (int j = 0; j < colnum; j++) {

				Cell cl = rw.getCell(j);

				if (cl.getStringCellValue().equalsIgnoreCase(module)) {
					Cell cll = rw.getCell(1);
					System.out.println(cll.getStringCellValue());
					if (cll.getStringCellValue().equalsIgnoreCase("Y")) {
						System.out.println(cll.getStringCellValue());
						return true;
					} 

				}
			}

		}
		return false;

	}
	

	
	public static Object[][] getExcelData(String sheet) throws IOException {
		File f = new File("C:\\Users\\raja\\workspace\\EPFO\\src\\test\\resources\\Excel data\\Testdata.xls");

		FileInputStream fis = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet(sheet);
		int rownum = sh.getLastRowNum() + 1;
		int colnum = sh.getRow(0).getLastCellNum();
		System.out.println("row num is: " + rownum);
		System.out.println("col num is: " + colnum);
		Object a[][]=new Object[rownum-1][colnum];
		for (int i = 1; i < rownum; i++) {
			Row rw = sh.getRow(i);

			for (int j = 0; j < colnum; j++) {

				Cell cl = rw.getCell(j);
				System.out.println(cl.getStringCellValue());
			 a[i-1][j]=cl.getStringCellValue();

				
			}

		}
		return a;

	}
	
	
	public static void takesnapshot(String tcid) throws IOException{
		
		
		
		File sf=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File df=new File("C:\\Users\\raja\\workspace\\EPFO\\ScreenShots\\"+tcid+".jpeg");
		FileUtils.copyFile(sf, df);
	}
}
