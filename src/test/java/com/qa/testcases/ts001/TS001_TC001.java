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

public class TS001_TC001 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC001.class); // We have to add this statememt for every
																				// class whose logs we want to record.

	@Test(description = "Verify that the Create an Account form contains below mentioned fields : -", dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS001_TC001(String Email_Label, String Password_Label) throws Exception {

		driver.manage().window().maximize();

		// we need to create an object in order to use them
		SoftAssert sa = new SoftAssert();

		System.out.println("Email_Label :" + Email_Label + ", Password_Label :" + Password_Label);

		Thread.sleep(Duration.ofMillis(2000));

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
//		Map<String, String> TestData_TS001_TC001 = XLUtils.getDataForTest("TS001_TC001", "Sheet1");

		driver.get(config.getCreateAnAccountPageURL());
		logger1.info("Create an account page launched.....");
		test.pass("Create Account page got open");

		// Step1: Check presence of Email label
		if (CreateAccount.GetEmailLabel().equals(Email_Label)) {
			sa.assertTrue(true);
			logger1.info("Correct email label with value = " + CreateAccount.GetEmailLabel()
					+ "is present on Create an Account page");
			test.pass("Correct email label with value = " + CreateAccount.GetEmailLabel()
					+ "is present on Create an Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Incorrect email label with value = " + CreateAccount.GetEmailLabel()
					+ "is present on Create an Account page");
			test.fail("Incorrect email label with value = " + CreateAccount.GetEmailLabel()
					+ "is present on Create an Account page");

		}

		// Step2: Check presence of Password label
		if (CreateAccount.GetPasswordLabel().equals(Password_Label)) {
			sa.assertTrue(true);
			logger1.info("Correct password label with value = " + CreateAccount.GetPasswordLabel()
					+ "is present on Create an Account page");
			test.pass("Correct password label with value = " + CreateAccount.GetPasswordLabel()
					+ "is present on Create an Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Incorrect password label with value = " + CreateAccount.GetPasswordLabel()
					+ "is present on Create an Account page");
			test.fail("Incorrect password label with value = " + CreateAccount.GetPasswordLabel()
					+ "is present on Create an Account page");

		}

		// Step3: Check presence of Email Text-box
		if (CreateAccount.CheckEmailTextboxPresence()) {
			sa.assertTrue(true);
			logger1.info("Email textbox is present on Account page");
			test.pass("Email textbox is present on Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Email textbox is NOT present on Account page");
			test.fail("Email textbox is NOT present on Account page");

		}

		// Step4: Check presence of Password Text-box
		if (CreateAccount.CheckPasswordTextboxPresence()) {
			sa.assertTrue(true);
			logger1.info("Password textbox is present on Account page");
			test.pass("Password textbox is present on Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Password textbox is NOT present on Account page");
			test.fail("Password textbox is NOT present on Account page");

		}

		// Step5: Check presence of CreateAnAccount button

		if (CreateAccount.CheckCreateAnAccountButtonPresence()) {
			sa.assertTrue(true);
			logger1.info("Create an account button is present on Account page");
			test.pass("Create an account button is present on Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Create an account button is NOT present on Account page");
			test.fail("Create an account button is NOT present on Account page");

		}

		// the asserts used till now will not throw any exception if they fail. The @Test will not fail either.
		// If you need the test method to fail at the end, showing all exceptions, you need to use assertAll()
		sa.assertAll();
	}
}
