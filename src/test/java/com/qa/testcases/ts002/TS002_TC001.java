package com.qa.testcases.ts002;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.pages.SignInPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS002_TC001 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC001.class);

	@Test(description = "Verify that the Sign In form contains fields as per requirement 2", groups = { "Regression",
			"Smoke" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS002_TC001(String Email_Label, String Password_Label) throws Exception {

		logger1 = Logger.getLogger(TS002_TC001.class);

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		/*  Creation of Page class object.  */
		SignInPage signin = new SignInPage(driver);
		
		// SoftAssert object creation
		SoftAssert sa=new SoftAssert();
		

		//Step1: Open Sign-in page
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign IN page");
		test.pass("Launched Sign IN page");


		// Step1: Check presence of Email label
		if (signin.GetEmailLabel().equals(Email_Label)) {
			sa.assertTrue(true);
			logger1.info("Correct email label with value "+signin.GetEmailLabel()+" on signIn page ");
			test.pass("Correct email label with value "+signin.GetEmailLabel()+" on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("Incorrect email label with value "+signin.GetEmailLabel()+" on signIn page ");
			test.fail("Incorrect email label with value "+signin.GetEmailLabel()+" on signIn page ");
		}
		
		
		
		// Step2: Check presence of Password label
		if (signin.GetPasswordLabel().equals(Password_Label)) {
			sa.assertTrue(true);
			logger1.info("Correct Password label with value "+signin.GetPasswordLabel()+" on signIn page ");
			test.pass("Correct Password label with value "+signin.GetPasswordLabel()+" on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("Incorrect password label with value "+signin.GetPasswordLabel()+" on signIn page ");
			test.fail("Incorrect password label with value "+signin.GetPasswordLabel()+" on signIn page ");
		}		
		
		
		// Step3: Check presence of Email Text-box
		if (signin.CheckEmailTextboxPresence()) {
			sa.assertTrue(true);
			logger1.info("Email textbox is present on signIn page ");
			test.pass("Email textbox is present on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("Email textbox is NOT present on signIn page ");
			test.fail("Email textbox is NOT present on signIn page ");
		}		
		

		
		// Step4: Check presence of Password Text-box
		if (signin.CheckPasswordTextboxPresence()) {
			sa.assertTrue(true);
			logger1.info("Password textbox is present on signIn page ");
			test.pass("Password textbox is present on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("Password textbox is NOT present on signIn page ");
			test.fail("Password textbox is NOT present on signIn page ");
		}	
		
		// Step5: Check presence of Forgot password hyper-link
		if (signin.CheckForgotPasswordHypelinkPresence()) {
			sa.assertTrue(true);
			logger1.info("Forgot password hyperlink is present on signIn page ");
			test.pass("Forgot password hyperlink is present on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("Forgot password hyperlink is NOT present on signIn page ");
			test.fail("Forgot password hyperlink is NOT present on signIn page ");
		}	
		
		
		
		// Step6: Check presence of Sign-in button
		if (signin.CheckSignInButtonPresence()) {
			sa.assertTrue(true);
			logger1.info("SignIn button is present on signIn page ");
			test.pass("SignIn button is present on signIn page ");
		} else {
			sa.assertTrue(false);
			logger1.info("SignIn button is NOT present on signIn page ");
			test.fail("SignIn button is NOT present on signIn page ");
		}	
		
		
		
	    sa.assertAll();
	}

}
