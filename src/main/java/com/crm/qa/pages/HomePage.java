package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;
//import com.crm.qa.stepdefination.loginpage;

public class HomePage extends TestBase {

	Actions a = new Actions(driver);
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[contains(text(),'User')]")
	WebElement user;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContact;
	
	public String checkUser() {
		explictwait.until(ExpectedConditions.visibilityOf(user));
		return user.getText();
	}
	
	public boolean validateLogoutLink() {
		return logoutLink.isDisplayed();
	}
	
	public ContactPage clickContactLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public void goToCreateContact() {
		a.moveToElement(contactsLink).build().perform();
		newContact.click();
	}

}
