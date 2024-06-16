package com.qa.testcases.ts003;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.SignInPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC004 extends ReportUtil {
	private Logger logger1 = LogManager.getLogger(TS003_TC004.class);

	@Test(description ="Verify that 'If there is an account associated with <email id> you will receive an email with a link to reset your password.' message is displayed provided user enters valid email address in email address textbox followed by click on Rest my account button", groups = {
			"Functional", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS003_TC004(String Email_Val, String Reset_Pass_Success_Message) throws Exception {

		//SoftAssert object creation and initialization
		SoftAssert sa=new SoftAssert();
		
		/* Create objects of pages you need for execution */
		ForgotPasswordPage forgotpassword = new ForgotPasswordPage(driver);
        SignInPage signpage=new SignInPage(driver);
		
		/* Test steps */

		// Step1: Open Forgot Password page
		driver.get(config.getForgotPasswordPageURL());
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		forgotpassword.SetEmailTextbox(Email_Val);
		logger1.info("User entered "+Email_Val+"value in Email textbox");
		test.info("User entered "+Email_Val+"value in Email textbox");
		Thread.sleep(3000);

		// Step3: User clicks on Reset My password button.
		forgotpassword.ClickResetMyPasswordButton();
		logger1.info("User clicked on Reset My Password button");
		test.info("User clicked on Reset My Password button");

		Thread.sleep(3000);

		//User lands on SignIn Page
		if(driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/")) {
			logger1.info("User lands on Customer SignIn page");
			test.pass("User lands on  Customer SignIn page");
		}else {
			logger1.info("User did not land on Customer SignIn page");
			test.fail("User did not land on Customer SignIn page");
		}
	
		
		Thread.sleep(3000);
		
		// Step3: Check presence of success message for reset password email input including
		String successMessage = signpage.GetForgotPasswordSuccessMessage();
		
		if(signpage.GetForgotPasswordSuccessMessage().equals(successMessage)) {
			logger1.info("Reset my password success message :"+successMessage+" is displayed");
			test.pass("Reset my password success message :"+successMessage+" is displayed");
		}else {
			logger1.info("Reset my password success message is NOT displayed");
			test.fail("Reset my password success message is NOT displayed");
		}

		
		sa.assertAll(); // V IMP STEP..to validate softassert results.
		
	}

}
