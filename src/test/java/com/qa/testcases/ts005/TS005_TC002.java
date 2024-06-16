package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CheckoutPaymentsPage;
import com.qa.pages.CheckoutShippingPage;
import com.qa.pages.CreateAnAccountPage;
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
import com.qa.testcases.ts004.TS004_TC002;
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS005_TC002 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS005_TC002.class);

	@Test(description = "Verify that the search textbox is empty and enabled by default with search icon disabled by default", groups = {
			"Regression", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS005_TC002(String Number_Run) throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.

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
		CreateAnAccountPage createaccountpage = new CreateAnAccountPage(driver);
		CheckoutShippingPage checkoutshippingpage = new CheckoutShippingPage(driver);
		CheckoutPaymentsPage checkoutpaymentpage = new CheckoutPaymentsPage(driver);

		Thread.sleep(3000);

		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
		// Get data of Sheet4
//		Map<String, String> TestData = XLUtils.getDataForTest("TS005_TC002", "Sheet5");

		/* Test steps */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); //Explicit wait

		// Creation and initialization of SoftAssert class
		SoftAssert sa = new SoftAssert();
		


		                               /* Step1: Validation for Home page */
		
		// 1. User opens to HomePage page.
		driver.get(config.getHomePageURL());
		logger1.info("User opens to Home Page page");
		test.info("User opens to Home Page page");		
		
		// Step3: Check presence of Search text-box on Home page
		if (homepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Account page");
			test.pass("Search textbox is displayed on My Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Account page");
			test.fail("Search textbox is displayed on My Account page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (homepage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT empty by default");
			test.fail("Search textbox is NOT empty by default");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		System.out.println("Default state of Search textbox :"+homepage.GetStateSearchIconSearchTextbox());
		if (homepage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to MyAccount page.
		driver.navigate().to(config.getMyAccountPageURL());
		logger1.info("User navigates to My Account page");
		test.pass("User navigates to My Account page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		if (myaccountpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Account page");
			test.pass("Search textbox is displayed on My Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Account page");
			test.fail("Search textbox is displayed on My Account page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (myaccountpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (myaccountpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(config.getMyWishlistPageURL());
		logger1.info("User navigates to My WishList page");
		test.pass("User navigates to My WishList page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		if (mywishlistpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (mywishlistpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (mywishlistpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}



		// Step3: User navigates to What's New page.
		driver.navigate().to(config.getWhatsNewPageURL());
		logger1.info("User navigates to What's New page");
		test.pass("User navigates to What's New page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		if (whatsnewpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on What's New page");
			test.pass("Search textbox is displayed on My What's New page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on What's New page");
			test.fail("Search textbox is displayed on What's New page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (whatsnewpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on What's New page");
			test.pass("Search textbox is empty by default on What's New page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on What's New page");
			test.fail("Search textbox is empty by default on What's New page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (whatsnewpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Women page.
		driver.navigate().to(config.getWomenPageURL());
		logger1.info("User navigates to Womens page");
		test.pass("User navigates to Womens page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		if (womenpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Women's page");
			test.pass("Search textbox is displayed on Women's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Women's page");
			test.fail("Search textbox is displayed on Women's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (womenpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on Women's page");
			test.pass("Search textbox is empty by default on Women's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on Women's page");
			test.fail("Search textbox is empty by default on Women's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (womenpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Men page.
		driver.navigate().to(config.getMenPageURL());
		logger1.info("User navigates to Men's page");
		test.pass("User navigates to Men's page");

		Thread.sleep(3000);
		// Step3: Check presence of Search text-box on Home page
		if (menpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Men's page");
			test.pass("Search textbox is displayed on Men's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Men's page");
			test.fail("Search textbox is displayed on Men's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (menpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on Men's page");
			test.pass("Search textbox is empty by default on Men's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on Men's page");
			test.fail("Search textbox is empty by default on Men's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (menpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Gear page.
		driver.navigate().to(config.getGearPageURL());
		logger1.info("User navigates to Gear's page");
		test.pass("User navigates to Gear's page");

		Thread.sleep(3000);
		// Step3: Check presence of Search text-box on Home page
		if (gearpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Gear's page");
			test.pass("Search textbox is displayed on Gear's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Gear's page");
			test.fail("Search textbox is displayed on Gear's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (gearpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on Gear's page");
			test.pass("Search textbox is empty by default on Gear's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on Gear's page");
			test.fail("Search textbox is empty by default on Gear's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (gearpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Training's page.
		driver.navigate().to(config.getTrainingsPageURL());
		logger1.info("User navigates to Training's page");
		test.pass("User navigates to Training's page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Trainings page
		Thread.sleep(3000);
		// Step3: Check presence of Search text-box on Home page
		if (trainingpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Training's page");
			test.pass("Search textbox is displayed on Training's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Training's page");
			test.fail("Search textbox is displayed on Training's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (trainingpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on Training's page");
			test.pass("Search textbox is empty by default on Training's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on Training's page");
			test.fail("Search textbox is empty by default on Training's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (trainingpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);

		// Step3: User navigates to Sale page.
		driver.navigate().to(config.getSalePageURL());
		logger1.info("User navigates to Sale page");
		test.pass("User navigates to Sale page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Trainings page
		Thread.sleep(3000);
		// Step3: Check presence of Search text-box on Home page
		if (salepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Sale's page");
			test.pass("Search textbox is displayed on Sale's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Sale's page");
			test.fail("Search textbox is displayed on Sale's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search text-box.
		if (salepage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default on Sale's page");
			test.pass("Search textbox is empty by default on Sale's page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default on Sale's page");
			test.fail("Search textbox is empty by default on Sale's page");
		}

		Thread.sleep(3000);

		// Checking default state of Search Icon inside Search text-box.
		if (salepage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		Thread.sleep(3000);


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
		if (driver.getCurrentUrl().equals(config.getCartPageURL())) {
			sa.assertTrue(true);
			logger1.info("User lands on shopping cart page");
			test.pass("User lands on shopping cart page");
		} else {
			sa.assertTrue(false);
			logger1.info("User do not lands on shopping cart page");
			test.fail("User do not lands on shopping cart page");
		}

		Thread.sleep(3000);

		// User now checks presence of Search Text-box on Cart web page.
		if (shoppingcartpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Seach textbox exists on Shopping cart webpage");
			test.pass("Seach textbox exists on Shopping cart webpage");
		} else {
			sa.assertTrue(false);
			logger1.info("Seach textbox Do not exists on Shopping cart webpage");
			test.fail("Seach textbox do not exists on Shopping cart webpage");
		}

// New validation for TS004_TC002 
		if (shoppingcartpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Seach textbox is not empty by default.");
			test.fail("Seach textbox is not empty by default.");
		}

		if (shoppingcartpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		sa.assertAll(); // imp step to validate outcome of softAsserrs.
		
	}

}
