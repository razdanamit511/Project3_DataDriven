package com.qa.testcases.ts001;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC005 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC005.class);

	@Test(description = "Verify that the password is in encrypted form when entered", groups = { "Functional",
			"Smoke" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS001_TC005(String Password) throws Exception {

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// Create object of page classes that are in use of current test execution.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Create object of XLUtil class to read test data from testdata.xlsx.
		// Map<String, String> TestData=XLUtils.getDataForTest("TS001_TC005", "Sheet1");

		// we need to create an object in order to use them
		SoftAssert sa = new SoftAssert();

		/* Test steps */

		// Step1
		driver.get(config.getCreateAnAccountPageURL());
		logger1.info("Launched Create An Account page");
		test.pass("Launched Create An Account page");

		Thread.sleep(3000);

		CreateAccount.SetPasswordTextbox(Password);
		logger1.info("Entered " + Password + " in Password textbox");
		test.pass("Entered " + Password + " in Password textbox");

		Thread.sleep(3000);

		// Step2: Check value entered is entered in encrypted form i.e. ******* form.

		if (driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type").equals("password")) {
			logger1.info("Entered password in Password textbox is in encrypted form i.e. masked form");
			test.pass("Entered password in Password textbox is in encrypted form i.e. masked form");
		} else {
			logger1.info("Entered password in Password textbox is NOT in encrypted form i.e. masked form");
			test.fail("Entered password in Password textbox is NOT in encrypted form i.e. masked form");
		}

		// the asserts used till now will not throw any exception if they fail. The  @Test will not fail either.
		// If you need the test method to fail at the end, showing all exceptions, you need to use assertAll()
		sa.assertAll();
	}

}
