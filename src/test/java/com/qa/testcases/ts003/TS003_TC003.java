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

public class TS003_TC003 extends ReportUtil{

	private Logger logger1=LogManager.getLogger(TS003_TC003.class);
	
	@Test(description = "Verify that \"Please enter a valid email address (Ex: johndoe@domain.com).\" error message is displayed under Email textbox provided user enters Invalid email address in email textbox and clicks on SignIn button", groups = {"Functional","Smoke"}, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS003_TC003(String Email_Val, String Email_Error) throws Exception {
           
		System.out.println("Email value :"+Email_Val+" and email error is :"+Email_Error);
		
		//Creation and initialization of SoftAssert
		SoftAssert sa=new SoftAssert();
		
		/*   Create objects of pages you need for execution   */
		ForgotPasswordPage forgotpassword= new ForgotPasswordPage(driver);
		
		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
	//	Map<String, String>  TestData=XLUtils.getDataForTest("TS003_TC003", "Sheet3");
		
		/*                    Test steps               */
		
		//Step1: Open Forgot Password page
		driver.get(config.getForgotPasswordPageURL());
		logger1.info("Launched Forgot password page");
		test.pass("Launched Forgot password page");
		
		Thread.sleep(3000);
		
		//Step2: Enter invalid email address in emailID text-box.
		forgotpassword.SetEmailTextbox(Email_Val);
		logger1.info("User enters invalid value as "+Email_Val+" in Email textbox");
		test.pass("User enters invalid value as "+Email_Val+" in Email textbox");
	
		Thread.sleep(3000);
		
		//Step3: User clicks on Reset My password button.
		forgotpassword.ClickResetMyPasswordButton();
		logger1.info("User clicked on Reset My Password button");
		test.pass("User clicked on Reset My Password button");
		
		Thread.sleep(3000);
		
		//Step3: Check presence of error message for invalid email input including error message text
		if(forgotpassword.GetMandatoryEmailErrorMessage().equals(Email_Error)) {
			logger1.info("Error message "+Email_Error+" is displayed for invalid value in Email textbox.");
			test.pass("Error message "+Email_Error+" is displayed for invalid value in Email textbox.");
		}else {
			logger1.info("Error message "+Email_Error+" is NOT displayed for invalid value in Email textbox.");
			test.fail("Error message "+Email_Error+" is NOT displayed for invalid value in Email textbox.");
		}

		
		sa.assertAll();
		
	}
	
	
}
