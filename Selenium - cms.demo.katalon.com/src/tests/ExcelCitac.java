package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelCitac {
	File fajl;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value;
	
	public ExcelCitac(String filePath) throws IOException {
		this.fajl = new File(filePath);
		this.fis = new FileInputStream(fajl);
		this.wb = new XSSFWorkbook(fis);
	}
	
	public String getStringData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		return cell.getStringCellValue();
	}
	
	public int getIntData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		return (int)cell.getNumericCellValue();
	}
	
	public String getData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		if (cell.getCellType() == CellType.NUMERIC) { 
			value = String.valueOf((int)cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}
		return value;
	}
	
	public void asertovanje(String sheetName,int columne, int row, String textSaSajta) {
		String textIzTabele = getStringData(sheetName, columne, row); 
		Assert.assertEquals(textSaSajta, textIzTabele);
		System.out.println("Asertovanje uspesno");
	}
}
