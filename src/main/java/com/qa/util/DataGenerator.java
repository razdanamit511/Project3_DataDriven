package com.qa.util;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.qa.base.BaseTest;

/* This class will serve as data provider reader class which we'll be using as source of data provider in every test case class */

public class DataGenerator extends BaseTest {

	@DataProvider(name = "excelData")
	public String[][] excelDataProvider(Method m) {

		System.out.println("Method name :" + m.getName());
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		String[][] arrObj = XLUtils.getExcelData(config.getTestDataFilePath(), m.getName());
		return arrObj;
	}

	// This method handles the excel - opens it and reads the data from the
	// respective cells using a for-loop & returns it in the form of a string array
	

}