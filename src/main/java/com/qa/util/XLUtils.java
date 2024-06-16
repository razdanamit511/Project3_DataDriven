package com.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.base.BaseTest;

public class XLUtils extends BaseTest {

	public static FileOutputStream fo;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws Exception {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int row = ws.getLastRowNum();
		wb.close();
		fi.close();
		return row + 1;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws Exception {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rowNum, int columnNum) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(columnNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlFile, String xlSheet, int rowNum, int columnNum, String data)
			throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(columnNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}

	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] data = null;
		try {

			FileInputStream fis = new FileInputStream(fileName);
			System.out.println("1");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			System.out.println("2");
			XSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println("3");
			XSSFRow row = sheet.getRow(0);
			System.out.println("4");
			int noOfRows = sheet.getPhysicalNumberOfRows();
			System.out.println("5");
			int noOfCols = row.getLastCellNum();
			System.out.println("6");
			Cell cell;
			System.out.println("7");
			data = new String[noOfRows - 1][noOfCols];
			System.out.println("8");
			for (int i = 1; i < noOfRows; i++) {
				System.out.println("9");
				for (int j = 0; j < noOfCols; j++) {
					System.out.println("10");
					row = sheet.getRow(i);
					System.out.println("11");
					cell = row.getCell(j);
					System.out.println("12");
					data[i-1][j] = getCellValueAsString(cell);
					System.out.println("13");
				}

			}

		} catch (Exception e) {
			System.out.println("13");
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}

	private static String getCellValueAsString(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		System.out.println("Cell type :"+cellType);
		String val = "";

		switch (cellType) {
		case STRING:
			val = cell.getStringCellValue();
			break;

		case NUMERIC:
			DataFormatter dataFormatter = new DataFormatter();
			val = dataFormatter.formatCellValue(cell);
			break;

		case BOOLEAN:
			val = String.valueOf(cell.getBooleanCellValue());
			break;

		case BLANK:
			break;
		}
		return val;
	}

	// Customized method dev by Amit
	public static Map<String, String> getDataForTest(String testMethodName, String sheetName) throws Exception {

		String filePath = config.getTestDataFilePath();

		// Step2: Get row count for excel's sheet1
		int rowCount = XLUtils.getRowCount(filePath, sheetName);
		System.out.println("Number of rows :" + rowCount);
		int colCount = XLUtils.getCellCount(filePath, sheetName, 0);
		System.out.println("Number of cells in each row :" + colCount);
		String data;

		// Step3: Find the Row which contains your test-case id. Also, define one array
		// of type string to store col names i.e. values of row=0

		int RowForUse = -1;

		String[] colNames = new String[colCount];

		for (int i = 0; i <= rowCount; i++) {

			for (int j = 0; j < colCount; j++) {

				data = XLUtils.getCellData(filePath, sheetName, i, j);

				if (i == 0) {
					colNames[j] = data;
				}

				System.out.println("Data :" + data + " i =" + i + " j=" + j);
				if (data.equalsIgnoreCase(testMethodName)) {
					RowForUse = i;

				}

			}

		}

		for (int i = 0; i < colNames.length; i++) {
			System.out.print(colNames[i] + " ");
		}

		System.out.println("Row at which " + testMethodName + " is found :" + RowForUse);

		// Step4: Create one map
		Map<String, String> FetchedValueMap = new HashMap<String, String>(10);

		if (RowForUse == -1) {

			// If we can't find the testMethod requested by user .... then return Blank Map.

			return FetchedValueMap;
		} else {

			for (int j = 0; j < colCount; j++) {

				data = XLUtils.getCellData(filePath, sheetName, RowForUse, j);

				FetchedValueMap.put(colNames[j], data);

			}

		}
		System.out.println(FetchedValueMap);

		return FetchedValueMap;
	}

}
