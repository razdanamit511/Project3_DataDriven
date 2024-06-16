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

public class TS004_TC004 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS004_TC004.class);

	@Test(description = "Verify that user is able to get products as part of searched results based on the keyword been entered by user in search textbox followed by click on search icon and a label as follows :-Search results for: '<entered keyword>'", groups = { "Functional", "Sanity" }, dataProvider = "excelData", dataProviderClass = DataGenerator.class)
	public void TS004_TC004(String Email_Val, String Password_Val, String Search_Val, String Search_Count) throws Exception {

		int Search_Count_Int=Integer.valueOf(Search_Count);
		
		System.out.println("Email val :"+Email_Val+", Password val :"+Password_Val+", Search val :"+Search_Val+", Search count :"+Search_Count_Int);
	
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
		test.pass("Launched Sign In page");


		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(Email_Val);
		logger1.info("User enters "+Email_Val+" in Email textbox");
		test.pass("User enters "+Email_Val+" in Email textbox");


		// Step2: Enter password in Password text-box.
		signpage.SetPassword(Password_Val);
		logger1.info("User enters "+Password_Val+" value in Password textbox");
		test.pass("User enters "+Password_Val+" value in Password textbox");


		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.pass("User clicked on SignIn button");

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

		System.out.println("Search result label :"+homepage.GetSearchResultsLabel());
		
		if(homepage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
			sa.assertTrue(true);
		logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
		}
		
		
		int numElements = 0;
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements.size(); i++) {

			System.out.println("Link text :" + listElements.get(i).getText());
			if (listElements.get(i).getText().endsWith(Search_Val)) {
				numElements=numElements+1;
			}
		}

		
		if(numElements==Search_Count_Int) {
			sa.assertTrue(true);
			logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
			test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
		}else {
			sa.assertTrue(false);
			logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
			test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
		}

		
		// Step3: User navigates to MyAccount page.
		driver.navigate().to(config.getMyAccountPageURL());
		logger1.info("User navigates to My Account page");
		test.pass("User navigates to My Account page");
		
		// Step3: Check presence of Search text-box on Home page
		if (myaccountpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Home page");
			test.pass("Search textbox is displayed on Home page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is NOT displayed on Home page");
			test.fail("Search textbox is NOT displayed on Home page");
		}


		myaccountpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on My Account page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on My Account page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
		

		myaccountpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+myaccountpage.GetSearchResultsLabel());
		
		if(myaccountpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
			sa.assertTrue(true);
		logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
		}
		
		
		int numElements1 = 0;
		List<WebElement> listElements1 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements1.size(); i++) {

			System.out.println("Link text :" + listElements1.get(i).getText());
			if (listElements1.get(i).getText().endsWith(Search_Val)) {
				numElements1=numElements1+1;
			}
		}

		
		if(numElements1==Search_Count_Int) {
			sa.assertTrue(true);
			logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
			test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
		}else {
			sa.assertTrue(false);
			logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
			test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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
		
		mywishlistpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on My Wishlits page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on My Wishlist page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
		

		mywishlistpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+mywishlistpage.GetSearchResultsLabel());
		
		if(mywishlistpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
			sa.assertTrue(true);
		logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
		}
		
		
		int numElements2 = 0;
		List<WebElement> listElements2 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements2.size(); i++) {

			System.out.println("Link text :" + listElements2.get(i).getText());
			if (listElements2.get(i).getText().endsWith(Search_Val)) {
				numElements2=numElements2+1;
			}
		}

		
		if(numElements2==Search_Count_Int) {
			sa.assertTrue(true);
			logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
			test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
		}else {
			sa.assertTrue(false);
			logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
			test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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
		
		
		whatsnewpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
		

		whatsnewpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+whatsnewpage.GetSearchResultsLabel());
		
		if(whatsnewpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
			sa.assertTrue(true);
		logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
		}
		
		
		int numElements3 = 0;
		List<WebElement> listElements3 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements3.size(); i++) {

			System.out.println("Link text :" + listElements3.get(i).getText());
			if (listElements3.get(i).getText().endsWith(Search_Val)) {
				numElements3=numElements3+1;
			}
		}

		
		if(numElements3==Search_Count_Int) {
			sa.assertTrue(true);
			logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
			test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
		}else {
			sa.assertTrue(false);
			logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
			test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
		}

		
		// Step3: User navigates to Women page.
		driver.navigate().to(config.getWomenPageURL());
		logger1.info("User navigates to Womens page");
		test.pass("User navigates to Womens page");
		
		// Step3: Check presence of Search text-box on Home page
		if (womenpage.CheckPresenceSearchTextbox()) {
			sa.assertTrue(true);
			logger1.info("Search textbox is displayed on Women  page");
			test.pass("Search textbox is displayed on Women page");
		} else {
			sa.assertTrue(false);
			logger1.info("Search textbox is displayed on Women page");
			test.fail("Search textbox is displayed on Women page");
		}
		
		womenpage.SetSearchTextbox(Search_Val);
		logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
		test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

		
		// Explicitly wait until SerachIcon becomes enabled.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
		

		womenpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.pass("User clicked on Search icon");

		System.out.println("Search result label :"+womenpage.GetSearchResultsLabel());
		
		if(womenpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
			sa.assertTrue(true);
		logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
		test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
		}else {
			sa.assertTrue(false);
			logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
			test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
		}
		
		
		int numElements4 = 0;
		List<WebElement> listElements4 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements4.size(); i++) {

			System.out.println("Link text :" + listElements4.get(i).getText());
			if (listElements4.get(i).getText().endsWith(Search_Val)) {
				numElements4=numElements4+1;
			}
		}

		
		if(numElements4==Search_Count_Int) {
			sa.assertTrue(true);
			logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
			test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
		}else {
			sa.assertTrue(false);
			logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
			test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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

				menpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
				

				menpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+menpage.GetSearchResultsLabel());
				
				if(menpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
					sa.assertTrue(true);
				logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
				}
				
				
				int numElements5 = 0;
				List<WebElement> listElements5 = driver.findElements(By.tagName("a"));
				for (int i = 0; i < listElements5.size(); i++) {

					System.out.println("Link text :" + listElements5.get(i).getText());
					if (listElements5.get(i).getText().endsWith(Search_Val)) {
						numElements5=numElements5+1;
					}
				}

				
				if(numElements5==Search_Count_Int) {
					sa.assertTrue(true);
					logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
					test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
				}else {
					sa.assertTrue(false);
					logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
					test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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
		
				gearpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
				

				gearpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+gearpage.GetSearchResultsLabel());
				
				if(gearpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
					sa.assertTrue(true);
				logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
				}
				
				
				int numElements6 = 0;
				List<WebElement> listElements6 = driver.findElements(By.tagName("a"));
				for (int i = 0; i < listElements6.size(); i++) {

					System.out.println("Link text :" + listElements6.get(i).getText());
					if (listElements6.get(i).getText().endsWith(Search_Val)) {
						numElements6=numElements6+1;
					}
				}

				
				if(numElements6==Search_Count_Int) {
					sa.assertTrue(true);
					logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
					test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
				}else {
					sa.assertTrue(false);
					logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
					test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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
				
				trainingpage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
				

				trainingpage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+trainingpage.GetSearchResultsLabel());
				
				if(trainingpage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
					sa.assertTrue(true);
				logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
				}
				
				
				int numElements7 = 0;
				List<WebElement> listElements7 = driver.findElements(By.tagName("a"));
				for (int i = 0; i < listElements7.size(); i++) {

					System.out.println("Link text :" + listElements7.get(i).getText());
					if (listElements7.get(i).getText().endsWith(Search_Val)) {
						numElements7=numElements7+1;
					}
				}

				
				if(numElements7==Search_Count_Int) {
					sa.assertTrue(true);
					logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
					test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
				}else {
					sa.assertTrue(false);
					logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
					test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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

				salepage.SetSearchTextbox(Search_Val);
				logger1.info("User enters "+Search_Val+" search keyword in Search textbox on What's New page");
				test.pass("User enters "+Search_Val+" search keyword in Search textbox on What's New page");

				
				// Explicitly wait until SerachIcon becomes enabled.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));
				

				salepage.ClickSearchIconSearchTextbox();
				logger1.info("User clicked on Search icon");
				test.pass("User clicked on Search icon");

				System.out.println("Search result label :"+salepage.GetSearchResultsLabel());
				
				if(salepage.GetSearchResultsLabel().endsWith("'"+Search_Val+"'")) {
					sa.assertTrue(true);
				logger1.info("Search results label got displayed for searched keyword i.e. "+Search_Val);
				test.pass("Search results label got displayed for searched keyword i.e. "+Search_Val);
				}else {
					sa.assertTrue(false);
					logger1.info("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
					test.fail("Search results label is NOT displayed for searched keyword i.e. "+Search_Val);
				}
				
				
				int numElements8 = 0;
				List<WebElement> listElements8 = driver.findElements(By.tagName("a"));
				for (int i = 0; i < listElements8.size(); i++) {

					System.out.println("Link text :" + listElements8.get(i).getText());
					if (listElements8.get(i).getText().endsWith(Search_Val)) {
						numElements8=numElements8+1;
					}
				}

				
				if(numElements8==Search_Count_Int) {
					sa.assertTrue(true);
					logger1.info("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
					test.pass("Correct count for searched element got dispalyed for "+Search_Val+" keyword.");
				}else {
					sa.assertTrue(false);
					logger1.info("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
					test.fail("Incorrect count or not result is dispalyed for "+Search_Val+" keyword.");
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

