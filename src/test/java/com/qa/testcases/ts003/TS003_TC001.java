package com.qa.testcases.ts003;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.SignInPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC001 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS003_TC002.class);

	@Test(description = "Verify that user gets below mentioned labels/Fields on \"Forgot Password' webpage : -\r\n"
			+ "\r\n" + "Labels: -\r\n" + "\"Forgot Password\"\r\n"
			+ "\"Please enter your email address below to receive a password reset link.\"\r\n"
			+ "'Email\" ( with *)\r\n" + "\"Required * fields\"\r\n" + "\r\n" + "Buttons: -\r\n"
			+ "\"Reset my Password\"", groups = { "Regression",
					"Smoke" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS003_TC001(String Forgot_Password_Label, String Message_Label, String Email_Label) throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		ForgotPasswordPage ForgotPassword = new ForgotPasswordPage(driver);

		//SoftAssert object creation and initialization
		SoftAssert sa=new SoftAssert();

		// Step1: Open Sign in page
		driver.get(config.getForgotPasswordPageURL());
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");

		// Step2: Check ForgotPassword label
		if (ForgotPassword.GetForgotPasswordLabel().equals(Forgot_Password_Label)) {
			sa.assertTrue(true);
			
			logger1.info("Forgot password label is present on Forgot Password page.");
			test.pass("Forgot password label is present on Forgot Password page.");
		} else {
			sa.assertTrue(false);
			
			logger1.info("Forgot password label is NOT present on Forgot Password page.");
			test.fail("Forgot password label is NOT present on Forgot Password page.");
		}

		Thread.sleep(3000);

		// Step3: Check Info message label
		if (ForgotPassword.GetInfoMessageLabel().equals(Message_Label)) {
			sa.assertTrue(true);
			logger1.info("Info message is present on Forgot Password page.");
			test.pass("Info message is present on Forgot Password page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Info message is NOT present on Forgot Password page.");
			test.fail("Info message is NOT present on Forgot Password page.");
		}

		Thread.sleep(3000);

		// Step4: Check Email label
		if (ForgotPassword.GetEmailLabel().equals(Email_Label)) {
			sa.assertTrue(true);
			logger1.info("Email label is present on Forgot Password page.");
			test.pass("Email label is present on Forgot Password page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Email label is NOT present on Forgot Password page.");
			test.fail("Email label is NOT present on Forgot Password page.");
		}

		Thread.sleep(3000);
		
		// Step5: Check presence of ResetMyPassword button
		if (ForgotPassword.CheckPresenceResetMyPasswordButton()) {
			sa.assertTrue(true);
			logger1.info("Reset My Password button is present on Forgot Password page.");
			test.pass("Reset My Password button is present on Forgot Password page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Reset My Password button is NOT present on Forgot Password page.");
			test.fail("Reset My Password button is NOT present on Forgot Password page.");
		}

		sa.assertAll();
	}

	
	
}
