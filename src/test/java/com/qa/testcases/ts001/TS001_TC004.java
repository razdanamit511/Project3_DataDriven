package com.qa.testcases.ts001;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC004 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC004.class);

	@Test(description = "Verify that entering blank spaces on mandatory fields lead to validation error", groups = {
			"Functional", "Smoke" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS001_TC004(String Email_Val,String Password_Val,String FirstName_Val, String LastName_Val, String ConfirmPassword_Val,String Email_WariningMessage, String Password_WariningMessage, String FirstName_WariningMessage, String LastName_WariningMessage, String ConfirmPassword_WariningMessage) throws Exception {

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// we need to create an object in order to use them
		SoftAssert sa = new SoftAssert();		
		
		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
		//Map<String, String> TestData = XLUtils.getDataForTest("TS001_TC004", "Sheet1");

	                                                               	/* TEST STEPS */
	
		// Step1: Open Create an account page
		driver.get(config.getCreateAnAccountPageURL());
		logger1.info("Create an account page launched.....");
		test.pass("Create Account page got open");

		Thread.sleep(3000);

		// Step2: Enter Blank space in First Name text-box
		CreateAccount.SetFirstNameTextbox(FirstName_Val);
		logger1.info("Entererd "+FirstName_Val+" in First Name textbox");
		test.pass("Entererd "+FirstName_Val+" in First Name textbox");

		Thread.sleep(3000);

		// Step3: Enter Blank space in Last Name text-box
		CreateAccount.SetLastNameTextbox(LastName_Val);
		logger1.info("Entererd "+LastName_Val+" in Last Name textbox");
		test.pass("Entererd "+LastName_Val+" in Last Name textbox");

		Thread.sleep(2000);
		
		// Step2: Enter Blank space in Email text-box
		CreateAccount.SetEmailTextbox(Email_Val);
		logger1.info("Entererd "+Email_Val+" in Email textbox");
		test.pass("Entererd "+Email_Val+" in Email textbox");

		Thread.sleep(3000);
		
		// Step3: Enter Blank space in Password text-box
		CreateAccount.SetPasswordTextbox(Password_Val);
		logger1.info("Entererd "+Password_Val+" in Password textbox");
		test.pass("Entererd "+Password_Val+" in Password textbox");

		Thread.sleep(3000);

		// Step3: Enter Blank space in Confirm Password text-box
		CreateAccount.SetConfirmPasswordTextbox(ConfirmPassword_Val);
		logger1.info("Entererd "+ConfirmPassword_Val+" in Confirm Password textbox");
		test.pass("Entererd "+ConfirmPassword_Val+" in Confirm Password textbox");

		Thread.sleep(5000);

		// Step4: Clicks on CreateAnAccount button
		CreateAccount.ClickCreateAnAccountButton();
		logger1.info("User clicks on Create an Account button on Create an account page");
		test.pass("User clicks on Create an Account button on Create an account page");

		Thread.sleep(3000);

		                                                 /* Check warning messages for all mandatory text-boxes */

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
		
		
		// Step2: Check presence of Password text-box
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

		// Step4: Check presence of Last Name text-box
		if (CreateAccount.GetMandatoryErrorLastName().equals(LastName_WariningMessage)) {
			sa.assertTrue(true);
			logger1.info("User gets Mandatory error message for Last Name textbox on Create an account page");
			test.pass("User gets Mandatory error message for Last Name textbox on Create an account page");
		} else {
			sa.assertTrue(false);
			logger1.info("User gets incorrect  error message for Last Name textbox on Create an account page");
			test.fail("User gets incorrect error message for Last Name textbox on Create an account page");

		}
	
		// Step5: Check presence of Confirm-Password text-box
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
