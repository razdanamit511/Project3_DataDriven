package com.qa.testcases.ts004;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.GearPage;
import com.qa.pages.HomePage;
import com.qa.pages.MenPage;
import com.qa.pages.MyAccountPage;
import com.qa.pages.MyWishlistPage;
import com.qa.pages.SalePage;
import com.qa.pages.ShoppingCartPage;
import com.qa.pages.SignInPage;
import com.qa.pages.TrainingsPage;
import com.qa.pages.WhatsNewPage;
import com.qa.pages.WomenPage;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;
   
 public class TS004_TC005 extends ReportUtil{

	private Logger logger1 = LogManager.getLogger(TS004_TC005.class);

	@Test(description = "Verify that user gets an error message as part of result outcome as follows provided user enters any inappropriate search keyword\r\n"
			+ "\r\n"
			+ "Error message: \"Your search returned no results.\"", groups = { "Smoke", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS004_TC005(String Email_Val, String Password_Val, String Search_Val, String Search_Message) throws Exception {
		
		System.out.println("Email val :"+Email_Val+", Password val :"+Password_Val+", Search val :"+Search_Val);
		
		/* Create objects of pages you need for execution */
		ForgotPasswordPage forgotpassword = new ForgotPasswordPage(driver);
		SignInPage signpage = new SignInPage(driver);
		MyAccountPage myaccountpage = new MyAccountPage(driver);
		MyWishlistPage mywishlistpage = new MyWishlistPage(driver);
		HomePage homepage = new HomePage(driver);
		WhatsNewPage whatsnewpage = new WhatsNewPage(driver);
		WomenPage womenpage = new WomenPage(driver);
		MenPage menpage = new MenPage(driver);
		GearPage gearpage = new GearPage(driver);
		TrainingsPage trainingpage = new TrainingsPage(driver);
		SalePage salepage = new SalePage(driver);
		ShoppingCartPage shoppingcartpage = new ShoppingCartPage(driver);

		/* Test steps */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //Explicit wait

		// Creation and initialization of SoftAssert class
		SoftAssert sa = new SoftAssert();

		/* Step1: User logs into application through signIn page */
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign In page");
		test.info("Launched Sign In page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(Email_Val);
		logger1.info("User enters "+Email_Val+" in Email textbox");
		test.info("User enters "+Email_Val+" in Email textbox");

		// Step2: Enter password in Password text-box.
		signpage.SetPassword(Password_Val);
		logger1.info("User enters "+Password_Val+" value in Password textbox");
		test.info("User enters "+Password_Val+" value in Password textbox");


		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.info("User clicked on SignIn button");

		
		// User lands on Home Page after successful login
		// User lands on Home Page after successful login
		if (driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/")) {
			sa.assertTrue(true);
			logger1.info("User landed on Home page");
			test.pass("User landed on Home page");
		} else {
			sa.assertTrue(false);
			logger1.info("User didn't landed on Home page");
			test.fail("User didn't landed on Home page");
		}

		// Step3: Check presence of Search text-box on Home page
		if (homepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Home page");
			test.pass("Search textbox is displayed on Home page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT displayed on Home page");
			test.fail("Search textbox is NOT displayed on Home page");
		}


		homepage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on My Account page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on My Account page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
	
		homepage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+homepage.GetNoSearchResultsMessage());
		
		if(homepage.GetNoSearchResultsMessage().equals(Search_Message)) {
			sa.assertTrue(true);
		logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
		}
		
		// User clicks on drop-down icon
		homepage.ClickDropdownLogout();
		logger1.info("User clicked on dropdown logout.");
		test.pass("User clicked on dropdown logout.");

		// User clicks on SigninOut link
		homepage.ClickSignoutButton();
		logger1.info("User clicked on Signout button.");
		test.pass("User clicked on Signout button.");

		sa.assertAll(); // imp step to validate outcome of softAsserrs.
	}
	
}
