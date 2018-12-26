package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public void frameSwitch() {
		driver.switchTo().frame("mainpanel");
	}
	
   //@Test
	public static Object[][] getTestData() throws IOException {
		
		File f = new File("C:\\Users\\vikassum\\workspace_photon\\PageObjectModel\\src\\test\\resources\\ConatctData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> row = sheet.rowIterator();
		int lastrow=sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();
		System.out.println(lastrow);
		System.out.println(lastcell);
		Object[][] data = new Object[lastrow][lastcell];
		for(int j=0;j<lastrow;j++) {
			for(int i=0;i<lastcell;i++) {
				data[j][i]= sheet.getRow(j+1).getCell(i).toString();
				System.out.println(data[j][i]);
			}	
		}
		//wb.close();
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File ssfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		String dstfile =currentdir+"\\screenshots\\"+System.currentTimeMillis()+".png";
		System.out.println(dstfile);
		FileUtils.copyFile(ssfile, new File(dstfile));
		
	}

}
