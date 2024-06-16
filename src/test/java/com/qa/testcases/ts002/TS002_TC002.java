package com.qa.testcases.ts002;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.SignInPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS002_TC002 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC002.class);

	@Test(description = "Verify that user gets an error message as 'This is required' under Email/Password textbox provided enters do not enter any value and clicks on SignIn button", groups = {
			"Smoke", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS002_TC002(String Email_Val, String Password_Val, String Email_Mandatory_Error,
			String Password_Mandatory_Error) throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		SignInPage signin = new SignInPage(driver);

		// SoftAssert object creation
		SoftAssert sa = new SoftAssert();

		// Step1: Open Signin page
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign IN page");
		test.pass("Launched Sign IN page");

		Thread.sleep(3000);

		// Step1:set value in Email text box
		signin.SetEmail(Email_Val);
		logger1.info("User enters " + Email_Val + " in Email textbox");
		test.pass("User enters " + Email_Val + " in Email textbox");

		Thread.sleep(3000);

		// Step2: Set value in Password text box
		signin.SetPassword(Password_Val);
		;
		logger1.info("User enters " + Password_Val + " in Password textbox");
		test.pass("User enters " + Password_Val + " in Password textbox");

		Thread.sleep(3000);

		// Step3: Check presence of Email text box
		signin.ClickSignInButton();
		logger1.info("User clicked on signin button");
		test.pass("User clicked on signin button");

		Thread.sleep(5000);

		// Step1: User gets Mandatory error message under Email Text-box
		if (signin.getEmailMandatoryError().equals(Email_Mandatory_Error)) {
			sa.assertTrue(true);
			if (Email_Mandatory_Error.equals("NA"))
				test.pass("There is no Mandatory message under under Email textbox as expected");
			else
				test.pass("Correct Mandatory message as " + Email_Mandatory_Error
						+ " is displyed under under Email textbox");
		} else {
			sa.assertTrue(false);
			test.fail("Message as " + Email_Mandatory_Error + " is NOT displayed under Email textbox");
		}

		// Step2: User gets Mandatory error message under Password Text-box
		if (signin.getPasswordMandatoryError().equals(Password_Mandatory_Error)) {
			
			sa.assertTrue(true);
			if (Password_Mandatory_Error.equals("NA"))
				test.pass("There is no Mandatory message under under Password textbox as expected");
			else
				test.pass("Correct Mandatory message as " + Password_Mandatory_Error
						+ " is displyed under under Password textbox");
		} else {
			sa.assertTrue(false);
			test.fail("Message as " + Password_Mandatory_Error + " is NOT displayed under Password textbox");
		}

		sa.assertAll();
	}

}
