package com.qa.testcases.ts004;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class TS004_TC001 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS004_TC001.class);

	@Test(description = "Ensure that the search textbox is present on below mentioned pages post login: -" + "Home Page"
			+ "What's New page" + "Women's page" + "Mens's page" + "Gear's page" + "Trainings page" + "Sale's page"
			+ "Shopping Cart page" + "My Account page" + "My Wishlist page", groups = { "Regression",
					"Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS004_TC001(String Email_Val, String Password_Val) throws Exception {

		/* Create objects of pages you need for execution */
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

		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
		// Get data of Sheet4
		// Map<String, String> TestData_Sheet4 = XLUtils.getDataForTest("TS004_TC001",
		// "Sheet4");

		// Creation of SoftAssert object and initialization.
		SoftAssert sa = new SoftAssert();

		/* Test steps */

		/* Step1: User logs into application through signIn page */
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign In page");
		test.pass("Launched Sign In page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(Email_Val);
		logger1.info("User enters " + Email_Val + " value in Email textbox");
		test.pass("User enters " + Email_Val + " value in Email textbox");

		Thread.sleep(3000);

		// Step2: Enter password in Password text-box.
		signpage.SetPassword(Password_Val);
		logger1.info("User enters valid password " + Password_Val + " value in Password textbox");
		test.pass("User enters valid password " + Password_Val + " value in Password textbox");

		Thread.sleep(3000);

		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.pass("User clicked on SignIn button");

		Thread.sleep(3000);

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
	
		Thread.sleep(3000);

		// check presence of Search text-box.
		if (homepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Home page");
			test.pass("Search textbox is present on Home page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Home page");
			test.fail("Search textbox is NOT present on Home page");
		}

		// User navigates to MyAccount page
		driver.navigate().to(config.getMyAccountPageURL());
        logger1.info("User navigates to My Account Webpage.");
		test.pass("User navigates to My Account webpage.");

		Thread.sleep(3000);

		// check presence of Search text-box.
		if (myaccountpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on MyAccount page");
			test.pass("Search textbox is present on MyAccount page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on MyAccount page");
			test.fail("Search textbox is NOT present on MyAccount page");
		}

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(config.getMyWishlistPageURL());
		logger1.info("User navigates to MyWishList page");
		test.pass("User navigates to MyWishList page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on MyWishlist page
		// check presence of Search text-box.
		if (mywishlistpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on MyWishlist page");
			test.pass("Search textbox is present on MyWishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on MyWishlist page");
			test.fail("Search textbox is NOT present on MyWishlist page");
		}

		Thread.sleep(3000);

		// Step3: User navigates to What's New page.
		driver.navigate().to(config.getWhatsNewPageURL());
		logger1.info("User navigates to Whats New page");
		test.pass("User navigates to Whats New page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on What's New page
		if (whatsnewpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on What's New page");
			test.pass("Search textbox is present on What's New page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on What's New page");
			test.fail("Search textbox is NOT present on What's New page");
		}

		Thread.sleep(3000);

		//User navigates to women-page
		driver.navigate().to(config.getWomenPageURL());
		logger1.info("User navigates to Women page");
		test.pass("User navigates to Women page");
		
		// Step4: User checks presence of search text-box on Women's Page.
		if (womenpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Women page");
			test.pass("Search textbox is present on Women page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Women page");
			test.fail("Search textbox is NOT present on Women page");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Men page.
		driver.navigate().to(config.getMenPageURL());
		logger1.info("User navigates to Men's page");
		test.pass("User navigates to Men's page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Mens page
		if (menpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Men's page");
			test.pass("Search textbox is present on Men's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Men's page");
			test.fail("Search textbox is NOT present on Men's page");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Gear page.
		driver.navigate().to(config.getGearPageURL());
		logger1.info("User navigates to Gear page");
		test.pass("User navigates to Gear page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Gear page
		if (menpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Gear's page");
			test.pass("Search textbox is present on Gear's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Gear's page");
			test.fail("Search textbox is NOT present on Gear's page");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Trainings page.
		driver.navigate().to(config.getTrainingsPageURL());
		logger1.info("User navigates to Trainings page");
		test.pass("User navigates to Trainings page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Training page
		if (trainingpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Training page");
			test.pass("Search textbox is present on Training page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Training page");
			test.fail("Search textbox is NOT present on Training page");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Sale page.
		driver.navigate().to(config.getSalePageURL());
		logger1.info("User navigates to Sale page");
		test.pass("User navigates to Sale page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Sale page
		if (salepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Sale page");
			test.pass("Search textbox is present on Sale page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Sale page");
			test.fail("Search textbox is NOT present on Sale page");
		}

		/*
		 * User adds any element from What's New page in order to make traversal to cart
		 * possible
		 */

		// Navigate to What's New Page
		driver.navigate().to(config.getWhatsNewPageURL());
		logger1.info("User navigates to What's New page");
		test.pass("User navigates to What's New page");

		Thread.sleep(3000);

		// Hover cursor over element 1
		whatsnewpage.HoverOverElement1();
		logger1.info("User hovers over element 1");
		test.pass("User hovers over element 1");

		Thread.sleep(3000);

		// Click AddtoCart for element 1
		whatsnewpage.ClickAddToCartElement1Button();
		logger1.info("User clicks on Add to cart button for element1");
		test.pass("User clicks on Add to cart button for element1");

		Thread.sleep(3000);

		// User clicks on CartLink
		whatsnewpage.ClickCartLink();
		logger1.info("User clicks on Cart link");
		test.pass("User clicks on Cart link");

		Thread.sleep(3000);

		// User click son View and Edit cart option.
		whatsnewpage.ClickViewAndEditCart();
		logger1.info("User clicks on View and Edit option");
		test.pass("User clicks on View and Edit option");

		Thread.sleep(3000);

		// User navigates to Shopping cart page
		if (driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/cart/")) {
			sa.assertTrue(true);
			logger1.info("User lands on shopping cart page");
			test.pass("User lands on shopping cart page");
		} else {
			sa.assertTrue(false);
			logger1.info("User didn't lands on shopping cart page");
			test.fail("User didn't lands on shopping cart page");
		}

		Thread.sleep(3000);

		// User now checks presence of Search Text-box on Cart web page.
		if (shoppingcartpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Seach textbox exists on Shopping cart webpage");
			test.pass("Seach textbox exists on Shopping cart webpage");
		} else {
			sa.assertTrue(false);
			logger1.info("Seach textbox do not exists on Shopping cart webpage");
			test.fail("Seach textbox do not exists on Shopping cart webpage");
		}

		//User clicks on drop-down icon
		shoppingcartpage.ClickDropdownLogout();
		logger1.info("User clicked on dropdown logout.");
		test.pass("User clicked on dropdown logout.");
		
		
		//User clicks on SigninOut link
		shoppingcartpage.ClickSignoutButton();
		logger1.info("User clicked on Signout button.");
		test.pass("User clicked on Signout button.");
		
		sa.assertAll(); // imp step to validate outcome of softAsserrs.
	}

}
