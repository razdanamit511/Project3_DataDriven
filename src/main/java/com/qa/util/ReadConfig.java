package com.qa.util;

import java.io.FileInputStream;

import java.util.Properties;

/* Utility file to read data of Config.properties file. */

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\razda\\eclipse-workspace\\Projects\\Project3_DataDriven\\src\\main\\java\\com\\qa\\config\\config.properties");

			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}

	}

	public String getApplicationUrl() {
		return pro.getProperty("baseurl");
	}

	public String getBrowserName() {
		return pro.getProperty("browser");
	}

	public String getEnvironementName() {
		return pro.getProperty("environmentName");
	}

	public String getprojectName() {
		return pro.getProperty("projectName");
	}

	public String getTestDataFilePath() {
		return pro.getProperty("testDataXL");
	}

	public String getSignInPageURL() {
		return pro.getProperty("SignInPageURL");
	}
	
	public String getCreateAnAccountPageURL() {
		return pro.getProperty("CreateAnAccountPageURL");
	}
	
	public String getWhatsNewPageURL() {
		return pro.getProperty("WhatsNewPageURL");
	}
	
	public String getWomenPageURL() {
		return pro.getProperty("WomenPageURL");
	}
	
	public String getMenPageURL() {
		return pro.getProperty("MenPageURL");
	}
	
	public String getGearPageURL() {
		return pro.getProperty("GearPageURL");
	}
	
	public String getTrainingsPageURL() {
		return pro.getProperty("TrainingsPageURL");
	}
	
	public String getSalePageURL() {
		return pro.getProperty("SalePageURL");
	}
	
	public String getCartPageURL() {
		return pro.getProperty("CartPageURL");
	}
	
	public String getCheckoutShippingPageURL() {
		return pro.getProperty("CheckoutShippingPageURL");
	}
	
	public String getCheckoutPaymentPageURL() {
		return pro.getProperty("CheckoutPaymentPageURL");
	}
	
	public String getForgotPasswordPageURL() {
		return pro.getProperty("ForgotPasswordPageURL");
	}
	
	public String getMyWishlistPageURL() {
		return pro.getProperty("MyWishListPageURL");
	}
	
	public String getHomePageURL() {
		return pro.getProperty("HomePageURL");
	}
	
	public String getMyAccountPageURL() {
		return pro.getProperty("MyAccountURL");
	}
}
