package com.qa.testcases.ts003;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.ForgotPasswordPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC002 extends ReportUtil{
	
	private Logger logger1 = LogManager.getLogger(TS003_TC002.class);
	
	@Test(description = "Verify that 'Required field' error message is displayed under all Mandatory fields provded user clicks on 'Reset my password' button without entering any value in Mandatory field textbox.", groups = {"Smoke","Sanity","Functional"}, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS003_TC002(String Email_Val, String Email_Mandatory_Error) throws Exception {
		
		System.out.println("Email value :"+Email_Val+", Email mandatory error value :"+Email_Mandatory_Error);
		
		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		ForgotPasswordPage ForgotPassword = new ForgotPasswordPage(driver);

		//SoftAssert object creation and initialization
		SoftAssert sa=new SoftAssert();

		Thread.sleep(3000);
		
		// Step1: Open Sign in page
		driver.get(config.getForgotPasswordPageURL());
		logger1.info("Launched Forgot password page");
		test.pass("Launched Forgot password page");

		
		Thread.sleep(3000);
		
		//Step2: User enters value in Email text-box
		ForgotPassword.SetEmailTextbox(Email_Val);
		logger1.info("User entered value as "+Email_Val+" in email textbox.");
		test.pass("User entered value as "+Email_Val+" in email textbox.");

		Thread.sleep(3000);
		
		//Step2: User clicks on "Reset my password" button.
		ForgotPassword.ClickResetMyPasswordButton();
		logger1.info("Clicked Forgot Password button");
		test.pass("Clicked Forgot Password button");
		
		Thread.sleep(3000);
		
		System.out.println("Mandatory error actual :"+ForgotPassword.GetMandatoryEmailErrorMessage());
		
		//Step3: User checks presence of "This is a required field." message for Email text box.
		if (ForgotPassword.GetMandatoryEmailErrorMessage().equals(Email_Mandatory_Error)) {
			
			if(Email_Mandatory_Error.equals("NA")) {
				sa.assertTrue(true);
				logger1.info("Mandatory email error is NOT dispalyed on Forgot Password page as expected.");
				test.pass("Mandatory email error is NOT dispalyed on Forgot Password page as expected.");
			}else {
				sa.assertTrue(true);
				logger1.info("Mandatory email error as "+Email_Mandatory_Error+"is present on Forgot Password page.");
				test.pass("Mandatory email error as "+Email_Mandatory_Error+"is present on Forgot Password page.");
			}

		} else {
			sa.assertTrue(false);
			logger1.info("Mandatory email error is NOT present on Forgot Password page.");
			test.fail("Mandatory email error is NOT present on Forgot Password page.");
		}

		sa.assertAll();
		
	}
	

}
