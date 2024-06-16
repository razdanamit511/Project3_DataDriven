package com.qa.testcases.ts004;

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

public class TS004_TC003 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS004_TC003.class);

	@Test(description = "Verify that search icon with search textbox gets enabled as soon as user enters any string/char in search textbox", groups = {
			"Regression", "Functional", "Smoke",
			"Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS004_TC003(String Email_Val, String Password_Val, String Search_val) throws Exception {

		/* Create objects of pages you need for execution */
		// ForgotPasswordPage forgotpassword = new ForgotPasswordPage(driver);
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

		/* Get test data using XLUtil utility */
		// Map<String, String> TestData=XLUtils.getDataForTest("TS004_TC003", "Sheet4");

		/* Test steps */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.

		// Creation and initialization of SoftAssert class
		SoftAssert sa = new SoftAssert();

		/* Step1: User logs into application through signIn page */
		driver.get(config.getSignInPageURL());
		logger1.info("Launched Sign In page");
		test.info("Launched Sign In page");

		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(Email_Val);
		logger1.info("User enters email value in Email textbox");
		test.info("User enters email value in Email textbox");

		// Step2: Enter password in Password text-box.
		signpage.SetPassword(Password_Val);
		logger1.info("User enters valid password value in Password textbox");
		test.info("User enters valid password value in Password textbox");

		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.info("User clicked on SignIn button");

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
			logger1.info("Search textbox is displayed on My Account page");
			test.pass("Search textbox is displayed on My Account page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT displayed on My Account page");
			test.fail("Search textbox is NOT displayed on My Account page");
		}

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

		// Checking default state of Search Icon inside Search text-box.
		System.out.println("SearchICOn state before entring data :" + homepage.GetStateSearchIconSearchTextbox());
		// Checking default state of Search Icon inside Search text-box.
		if (homepage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT disabled by default");
			test.fail("Search icon of search textbox is NOT disabled by default");
		} else {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is disabled by default");
			test.pass("Search icon of search textbox is disabled by default");
		}

		// User enters value in Search text-box.
		homepage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// User click son View and Edit cart option.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		System.out.println("SearchICOn state after entring data :" + homepage.GetStateSearchIconSearchTextbox());
		if (homepage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}

		// Step3: User navigates to MyAccount page.
		driver.navigate().to(config.getMyAccountPageURL());
		logger1.info("User navigates to My Account page");
		test.pass("User navigates to My Account page");

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

		// User enters value in Search text-box.
		myaccountpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (myaccountpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(config.getMyWishlistPageURL());
		logger1.info("User navigates to My WishList page");
		test.pass("User navigates to My WishList page");

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

		// User enters value in Search text-box.
		mywishlistpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (mywishlistpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(config.getMyWishlistPageURL());
		logger1.info("User navigates to My WishList page");
		test.pass("User navigates to My WishList page");

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

		// User enters value in Search text-box.
		mywishlistpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (mywishlistpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}

		
		
		
		
		// Step3: User navigates to What's New page.
		driver.navigate().to(config.getWhatsNewPageURL());
		logger1.info("User navigates to What's New page");
		test.pass("User navigates to What's New page");

		// Step3: Check presence of Search text-box on Home page
		if (whatsnewpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (whatsnewpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		whatsnewpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (whatsnewpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}

		
		
		
		
		
		// Step3: User navigates to Women page.
		driver.navigate().to(config.getWomenPageURL());
		logger1.info("User navigates to Womens page");
		test.pass("User navigates to Womens page");
		
		// Step3: Check presence of Search text-box on Home page
		if (womenpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (womenpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		womenpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (womenpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}
		
		
	
		// Step3: User navigates to Men page.
		driver.navigate().to(config.getMenPageURL());
		logger1.info("User navigates to Men's page");
		test.pass("User navigates to Men's page");
		
		// Step3: Check presence of Search text-box on Home page
		if (menpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (menpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		menpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (menpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}
		
		
		
		
		
		// Step3: User navigates to Gear page.
		driver.navigate().to(config.getGearPageURL());
		logger1.info("User navigates to Gear's page");
		test.pass("User navigates to Gear's page");
		
		// Step3: Check presence of Search text-box on Home page
		if (gearpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (gearpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		gearpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (gearpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}
		
		
		
		
		
		// Step3: User navigates to Training's page.
		driver.navigate().to(config.getTrainingsPageURL());
		logger1.info("User navigates to Training's page");
		test.pass("User navigates to Training's page");
		
		
		// Step3: Check presence of Search text-box on Home page
		if (trainingpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (trainingpage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		trainingpage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (trainingpage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}
		
		
		
		
		
		// Step3: User navigates to Sale page.
		driver.navigate().to(config.getSalePageURL());
		logger1.info("User navigates to Sale page");
		test.pass("User navigates to Sale page");
		
		
		// Step3: Check presence of Search text-box on Home page
		if (salepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.pass("Search textbox is displayed on My Wishlist page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on My Wishlist page");
			test.fail("Search textbox is displayed on My Wishlist page");
		}

		// Checking default state of Search text-box.
		if (salepage.GetDefaultValSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is empty by default");
			test.pass("Search textbox is empty by default");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is empty by default");
			test.fail("Search textbox is empty by default");
		}

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

		// User enters value in Search text-box.
		salepage.SetSearchTextbox(Search_val);
		logger1.info("Entered value :" + Search_val + " in search text-box");
		test.pass("Entered value :" + Search_val + " in search text-box");

		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// Checking default state of Search Icon inside Search text-box.
		if (salepage.GetStateSearchIconSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search icon of search textbox is now enabled");
			test.pass("Search icon of search textbox is now enabled");
		} else {
			sa.assertTrue(false);
			logger1.info("Search icon of search textbox is NOT enabled");
			test.fail("Search icon of search textbox is NOT enabled");
		}
		
		
	
		// Navigate to What's New Page
		driver.navigate().to(config.getWhatsNewPageURL());
		logger1.info("User navigates to What's New page");
		test.pass("User navigates to What's New page");
		
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

				// User clicks on drop-down icon
				shoppingcartpage.ClickDropdownLogout();
				logger1.info("User clicked on dropdown logout.");
				test.pass("User clicked on dropdown logout.");

				// User clicks on SigninOut link
				shoppingcartpage.ClickSignoutButton();
				logger1.info("User clicked on Signout button.");
				test.pass("User clicked on Signout button.");

				sa.assertAll(); // imp step to validate outcome of softAsserrs.
		
	}

}
