package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class TS005_TC005 extends ReportUtil{

	private Logger logger1 = LogManager.getLogger(TS005_TC005.class);
	
	@Test(description = "Verify that user gets an error message as part of result outcome as follows provided user enters any inappropriate search keyword\r\n"
			+ "\r\n"
			+ "Error message: \"Your search returned no results.\"", groups = {"Functional","Sanity"}, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS005_TC005(String Search_Val, String Search_Message) throws Exception {
		
		
		System.out.println("Search val :"+Search_Val+", Search Message :"+Search_Message);
		
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
		CreateAnAccountPage createaccountpage=new CreateAnAccountPage(driver);
		ForgotPasswordPage forgotpasswordpage=new ForgotPasswordPage(driver);
		/* Test steps */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //Explicit wait

		// Creation and initialization of SoftAssert class
		SoftAssert sa = new SoftAssert();

		/* Step1: User opens Home Page */
		driver.get(config.getHomePageURL());
		logger1.info("Launched Home Web page");
		test.info("Launched Home Web page");

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


		whatsnewpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on My Account page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on My Account page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
	
		whatsnewpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+whatsnewpage.GetNoSearchResultsMessage());
		
		if(whatsnewpage.GetNoSearchResultsMessage().equals(Search_Message)) {
			sa.assertTrue(true);
		logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
		
		
		womenpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on My Account page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on My Account page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
	
		womenpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+womenpage.GetNoSearchResultsMessage());
		
		if(womenpage.GetNoSearchResultsMessage().equals(Search_Message)) {
			sa.assertTrue(true);
		logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				menpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on Mens page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on Mens page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				menpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+menpage.GetNoSearchResultsMessage());
				
				if(menpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				gearpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on Gear page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on Gear page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				gearpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+gearpage.GetNoSearchResultsMessage());
				
				if(gearpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				trainingpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on trainingpage page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on trainingpage page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				trainingpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+trainingpage.GetNoSearchResultsMessage());
				
				if(trainingpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				
				salepage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on salepage page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on salepage page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				salepage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+salepage.GetNoSearchResultsMessage());
				
				if(salepage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				signpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on sign in  page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on sign in  page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				signpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+signpage.GetNoSearchResultsMessage());
				
				if(signpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				
				createaccountpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on Create an account  page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on Create an account page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				createaccountpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+createaccountpage.GetNoSearchResultsMessage());
				
				if(createaccountpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
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
				
				forgotpasswordpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on forgot password  page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on forgot password page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
			
				forgotpasswordpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+forgotpasswordpage.GetNoSearchResultsMessage());
				
				if(forgotpasswordpage.GetNoSearchResultsMessage().equals(Search_Message)) {
					sa.assertTrue(true);
				logger1.info("No Search results label got displayed for searched keyword i.e. "+Search_Message);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Message);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Message);
				}	
				
	
				
		sa.assertAll(); // imp step to validate outcome of softAsserrs.
	}
	
}
