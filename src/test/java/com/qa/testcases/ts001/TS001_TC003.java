package com.qa.testcases.ts001;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.qa.pages.CreateAnAccountPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC003 extends ReportUtil{

	private static Logger logger1 = LogManager.getLogger(TS001_TC002.class);

	@Test(description = "Verify that system generates a validation message when clicking on submit button without filling all the mandatory fields.", groups = {
			"Regression", "Smoke" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS001_TC003(String Email_WariningMessage, String Password_WariningMessage, String FirstName_WariningMessage, String LastName_WariningMessage, String ConfirmPassword_WariningMessage) throws Exception {
		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));
		
		// we need to create an object in order to use them
		SoftAssert sa = new SoftAssert();
		
		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
	//	Map<String, String> TestData = XLUtils.getDataForTest("TS001_TC003", "Sheet1");

		driver.get(config.getCreateAnAccountPageURL());
		logger1.info("Create an account page launched.....");
		test.pass("Create Account page got open");

		// Step1: Check presence of Password text-box
		CreateAccount.ClickCreateAnAccountButton();
		logger1.info("User clicks on Create an Account button on Create an account page");
		test.pass("User clicked on Create An Account button on Create an account page");

		// Step1: Check presence of Email text-box
		if (CreateAccount.GetMandatoryErrorEmail().equals(Email_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for Email textbox on Create an account page");
			test.pass("User gets Mandatory error message for Email textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for Email textbox on Create an account page");
			test.fail("User gets incorrect error message for Email textbox on Create an account page");
			
		}
		
		
		// Step1: Check presence of Password text-box
		if (CreateAccount.GetMandatoryErrorEmail().equals(Password_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for Password textbox on Create an account page");
			test.pass("User gets Mandatory error message for Password textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for Password textbox on Create an account page");
			test.fail("User gets incorrect error message for Password textbox on Create an account page");
		}


		
		// Step3: Check presence of First Name text-box
		if (CreateAccount.GetMandatoryErrorFirstName().equals(FirstName_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for First Name textbox on Create an account page");
			test.pass("User gets Mandatory error message for First Name textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for First Name textbox on Create an account page");
			test.fail("User gets incorrect error message for First Name textbox on Create an account page");

		}
		
		
		
		// Step3: Check presence of Last Name text-box
		if (CreateAccount.GetMandatoryErrorLastName().equals(LastName_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for Last Name textbox on Create an account page");
			test.pass("User gets Mandatory error message for Last Name textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for Last Name textbox on Create an account page");
			test.fail("User gets incorrect error message for Last Name textbox on Create an account page");

		}
		
		
		// Step3: Check presence of Confirm-Password text-box
		if (CreateAccount.GetMandatoryErrorLastName().equals(ConfirmPassword_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for Confirm-Password textbox on Create an account page");
			test.pass("User gets Mandatory error message for Confirm-Password textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for Confirm-Password textbox on Create an account page");
			test.fail("User gets incorrect error message for Confirm-Password textbox on Create an account page");
		}
		// the asserts used till now will not throw any exception if they fail. The @Test will not fail either.
		// If you need the test method to fail at the end, showing all exceptions, you need to use assertAll()
		sa.assertAll();
	}

}
