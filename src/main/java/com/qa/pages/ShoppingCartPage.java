package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	
	/* WebElements */
	//Element1
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;
	
	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;
	
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement DropdownLogout;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	WebElement SignoutLink;
	
	/* Constructor to initialize webdriver all web-elements defined above */
	public ShoppingCartPage(WebDriver driver) {
		// This initElements method will create all WebElements
        this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/* Action Methods */
	public boolean CheckPresenceSearchTextbox() {
		return SearchTextbox.isDisplayed();
	}
	
	public boolean GetDefaultValSearchTextbox() {
		return SearchTextbox.getAttribute("value").isEmpty();
	}

	public boolean GetStateSearchIconSearchTextbox() {
		return SearchIconSearchTextBox.isEnabled();
	}

	public void SetSearchTextbox(String str) {
		SearchTextbox.sendKeys(str);
	}
	
	
	public void ClickDropdownLogout() {
		DropdownLogout.click();
	}
	
	public void ClickSignoutButton() {
		SignoutLink.click();
	}
}
