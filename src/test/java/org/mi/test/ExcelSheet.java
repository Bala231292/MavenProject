package org.mi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\BaLa\\eclipse-oxygen-workspace\\MavenProject\\excel\\ExcelSheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell= row.getCell(j);
				int type = cell.getCellType();
				if (type==1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else {
					if (DateUtil.isCellDateFormatted(cell)) {
						String name= new SimpleDateFormat("dd-MMM-yy").format(cell.getDateCellValue());
						System.out.println(name);
						}
						else {
							String name = String.valueOf((long) cell.getNumericCellValue());
							boolean em = name.isEmpty();
							System.out.println(name);
							System.out.println(em);
						}
					}
				}
			
			}	

		}	}