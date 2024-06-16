package com.qa.testcases.ts002;

import static org.testng.Assert.assertTrue;

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

public class TS002_TC003 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC003.class);

	@Test(description = "Verify that user is able to Sign in successfully provided user enters correct username and password in username and password textboxes followed by click on Sign In button", groups = {"Sanity", "Functional" },dataProvider = "excelData", dataProviderClass = DataGenerator.class )
	public void TS002_TC003(String Email_Val, String Password_Val) throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		SignInPage signin = new SignInPage(driver);

		// SoftAssert object creation
		SoftAssert sa = new SoftAssert();
		
		
		// Call XLUtil class method to fetch test data we need for execution.
	//	Map<String, String> TestData = XLUtils.getDataForTest("TS002_TC005", "Sheet2");

		Thread.sleep(3000);
		// Step1: Open Sign in page
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign IN page");
		test.pass("Launched Sign IN page");

		Thread.sleep(3000);

		// Step1:set value in Email text box
		signin.SetEmail(Email_Val);
		logger1.info("User entered "+Email_Val+" in Email textbox");
		test.pass("User entered "+Email_Val+" in Email textbox");

		Thread.sleep(3000);
		// Step2: Set value in Password text box
		signin.SetPassword(Password_Val);
		logger1.info("User entered "+Password_Val+" in Password textbox");
		test.pass("User entered "+Password_Val+" in Password textbox");

		// Step3: Click on SignIn button
		signin.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.pass("User clicked on SignIn button");
		
		// Step4: User lands on My Account web page.
		
		if(driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/")) {
			sa.assertTrue(true);
			logger1.info("User landed on Home page after successful login");
			test.pass("User landed on Home page after successful login");
		}else {
			sa.assertTrue(false);
			logger1.info("Login failed!!!!");
			test.fail("Login failed!!!!");
		}
		
		sa.assertAll();

	}

}
