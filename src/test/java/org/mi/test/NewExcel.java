package org.mi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcel {
	
	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\BaLa\\eclipse-oxygen-workspace\\MavenProject\\excel\\ExcelBook.xlsx");
		//FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook();
		
		Sheet sheet = book.createSheet("Test");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Python");
		
		FileOutputStream OutputStream= new FileOutputStream(file);
		book.write(OutputStream);
		System.out.println("Done");
	}

}
