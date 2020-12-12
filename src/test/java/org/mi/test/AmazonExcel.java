package org.mi.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExcel {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone", Keys.ENTER);
		List<WebElement> iPhone = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		File file = new File("C:\\\\Users\\\\BaLa\\\\eclipse-oxygen-workspace\\\\MavenProject\\\\excel\\\\Amazon.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("iphone");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		for (int i = 0; i < iPhone.size(); i++) {
			WebElement element = iPhone.get(i);
			Row row2 = sheet.createRow(i + 1);
			Cell cell2 = row2.createCell(0);
			String text = element.getText();
			cell2.setCellValue(text);
			
		}
		
		FileOutputStream stream = new FileOutputStream(file);
		book.write(stream);
		System.out.println("Done...");
		

	}

}
