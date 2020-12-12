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

public class ExcelSheetEdit {
	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\BaLa\\eclipse-oxygen-workspace\\MavenProject\\excel\\ExcelSheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(6);
		Cell cell = row.getCell(0);
		String name = cell.getStringCellValue();
		System.out.println(name);
		
		if (name.equals("Rakesh")) {
			cell.setCellValue("Cream");
			
		}
		FileOutputStream fileOutputStream= new FileOutputStream(file);
		book.write(fileOutputStream);
		System.out.println("Done...");
	}
}
