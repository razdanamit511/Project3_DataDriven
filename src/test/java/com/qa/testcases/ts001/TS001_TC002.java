package com.qa.testcases.ts001;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC002 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC002.class);

	@Test(description = "Verify presence of valid placeholder under Password label Testbox 'Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.'", groups = {
			"Regression", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS001_TC002(String Password, String WarningMessage) throws Exception {


		driver.manage().window().maximize();

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);
		
		// we need to create an object in order to use them
		SoftAssert sa = new SoftAssert();
		
		// Get test data for current test case from TestData.xlsx using XLUtil
		// Map<String, String> TestData=XLUtils.getDataForTest("TS001_TC002", "Sheet1");

		driver.get(config.getCreateAnAccountPageURL());
		logger1.info("Create an account page launched.....");
		test.pass("Create Account page got open");

		// Step1: Check presence of Password text-box
		if (CreateAccount.CheckPasswordTextboxPresence()) {
			sa.assertTrue(true);
			logger1.info("Password textbox is present of on Create an account page");
			test.pass("Password textbox is present of on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Password textbox is NOT present of on Create an account page");
			test.fail("Password textbox is NOT present of on Create an account page");

		}

		// Step2: Enter value in Password text-box
		CreateAccount.SetPasswordTextbox(Password);
		logger1.info("User enters :" + Password + " string in Password textbox on Create an account page");
		test.pass("User enters :" + Password + " string in Password textbox on Create an account page");

		// Step3: Check presence of Password Warning placeholder under Password text-box
		if (CreateAccount.GetPasswordWarningPlaceholder().equals(WarningMessage)) {
			sa.assertTrue(true);
			logger1.info("Correct warning message is present on webpage under Password textbox");
			test.pass("Correct warning message is present on webpage under Password textbox");
		} else {
			sa.assertTrue(false);
			logger1.info("Incorrect warning message is present on webpage under Password textbox");
			test.fail("Incorrect warning message is present on webpage under Password textbox");

		}

		// the asserts used till now will not throw any exception if they fail. The
		// @Test will not fail either.
		// If you need the test method to fail at the end, showing all exceptions, you
		// need to use assertAll()
		sa.assertAll();
	}

}
