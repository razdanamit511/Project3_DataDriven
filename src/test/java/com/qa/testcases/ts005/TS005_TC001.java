package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.qa.util.DataGenerator;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

import dev.failsafe.Timeout;

public class TS005_TC001 extends ReportUtil {
	private Logger logger1 = LogManager.getLogger(TS005_TC001.class);

	@Test(description = "Ensure that the search textbox is present on below mentioned pages pre-login: -" + "Home Page"
			+ "What's New page" + "Women's page" + "Mens's page" + "Gear's page" + "Trainings page" + "Sale's page"
			+ "Shopping Cart page" +", Sign In page"
			+ "and Not on below mentioned page :-\r\n" + "Checkout's Shipping page\r\n"
			+ "Checkout's Payment page", groups = { "Smoke", "Regression" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS005_TC001(String demoval) throws Exception {


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
		CreateAnAccountPage createaccountpage=new CreateAnAccountPage(driver);
		ForgotPasswordPage forgotpasswordpage=new ForgotPasswordPage(driver);
		/* Test steps */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); //Explicit wait

		// Creation and initialization of SoftAssert class
		SoftAssert sa = new SoftAssert();
		
		
		// User opens Home page
		driver.get(config.getHomePageURL());
        logger1.info("User navigates to Home Webpage.");
		test.pass("User navigates to Home webpage.");
		
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
		
		
		
		
		// User navigates to What's New page page
		driver.navigate().to(config.getWhatsNewPageURL());
        logger1.info("User navigates to What's New Webpage.");
		test.pass("User navigates to What's New Webpage.");
		
		// check presence of Search text-box.
		if (whatsnewpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  What's New page.");
			test.pass("Search textbox is present on  What's New page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on What's New page.");
			test.fail("Search textbox is NOT present on What's New page.");
		}
		
		
		
		
		// User navigates to Women's New page page
		driver.navigate().to(config.getWomenPageURL());
        logger1.info("User navigates to Women's Webpage.");
		test.pass("User navigates to Women's Webpage.");
		
		// check presence of Search text-box.
		if (womenpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Women's page.");
			test.pass("Search textbox is present on  Women's page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Women's page.");
			test.fail("Search textbox is NOT present on Women's page.");
		}
	
		
		
		
		
		
		// User navigates to Men's New page page
		driver.navigate().to(config.getMenPageURL());
        logger1.info("User navigates to Men's Webpage.");
		test.pass("User navigates to Men's Webpage.");
		
		// check presence of Search text-box.
		if (menpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Men's page.");
			test.pass("Search textbox is present on  Men's page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Men's page.");
			test.fail("Search textbox is NOT present on Men's page.");
		}
		
		
		
		
		// User navigates to Gear's page
		driver.navigate().to(config.getGearPageURL());
        logger1.info("User navigates to Gear's Webpage.");
		test.pass("User navigates to Gear's Webpage.");
		
		// check presence of Search text-box.
		if (gearpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Gear's page.");
			test.pass("Search textbox is present on  Gear's page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Men's page.");
			test.fail("Search textbox is NOT present on Men's page.");
		}
		
		
		
		// User navigates to Training's page
		driver.navigate().to(config.getTrainingsPageURL());
        logger1.info("User navigates to Training's Webpage.");
		test.pass("User navigates to Training's Webpage.");
		
		// check presence of Search text-box.
		if (trainingpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Training's page.");
			test.pass("Search textbox is present on  Training's page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Training's page.");
			test.fail("Search textbox is NOT present on Training's page.");
		}
		
		
		
		
		
		// User navigates to Sale's page
		driver.navigate().to(config.getSalePageURL());
        logger1.info("User navigates to Sale's Webpage.");
		test.pass("User navigates to Sale's Webpage.");
		
		// check presence of Search text-box.
		if (salepage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Sale's page.");
			test.pass("Search textbox is present on  Sale's page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Sale's page.");
			test.fail("Search textbox is NOT present on Sale's page.");
		}
		
		
		
		
		
		// User navigates to SignIn page
		driver.navigate().to(config.getSignInPageURL());
        logger1.info("User navigates to SignIn Webpage.");
		test.pass("User navigates to SignIn Webpage.");
		
		// check presence of Search text-box.
		if (signpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  SignIn page.");
			test.pass("Search textbox is present on  SignIn page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on SignIn page.");
			test.fail("Search textbox is NOT present on SignIn page.");
		}
		
		
		
		
		// User navigates to Create An Account page
		driver.navigate().to(config.getCreateAnAccountPageURL());
        logger1.info("User navigates to Create An Account Webpage.");
		test.pass("User navigates to Create An Account Webpage.");
		
		// check presence of Search text-box.
		if (createaccountpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on  Create An Account page.");
			test.pass("Search textbox is present on  Create An Account page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Create An Account page.");
			test.fail("Search textbox is NOT present on Create An Account page.");
		}
		
		
		
		
		// User navigates to Forgot password page
		driver.navigate().to(config.getForgotPasswordPageURL());
        logger1.info("User navigates to Forgot password Webpage.");
		test.pass("User navigates to Forgot password Webpage.");
		
		// check presence of Search text-box.
		if (forgotpasswordpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is present on Forgot password page.");
			test.pass("Search textbox is present on Forgot password page.");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT present on Forgot password page.");
			test.fail("Search textbox is NOT present on Forgot password page.");
		}
		
		
		
		//checking presence of Search text-box on Shopping Cart web-page.
		
		//1. Navigate to What's New webpage.
		driver.navigate().to(config.getWhatsNewPageURL());
		
		//2. 	// Hover cursor over element 1
		whatsnewpage.HoverOverElement1();
		logger1.info("User hovers over element 1");
		test.pass("User hovers over element 1");


		// Click AddtoCart for element 1
		whatsnewpage.ClickAddToCartElement1Button();
		logger1.info("User clicks on Add to cart button for element1");
		test.pass("User clicks on Add to cart button for element1");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]")));
		
		
		// User clicks on CartLink
		whatsnewpage.ClickCartLink();
		logger1.info("User clicks on Cart link");
		test.pass("User clicks on Cart link");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a")));

		
		// User click son View and Edit cart option.
		whatsnewpage.ClickViewAndEditCart();
		logger1.info("User clicks on View and Edit option");
		test.pass("User clicks on View and Edit option");


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
	}

}
