package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//HomePage homepage;
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(xpath="//*[@value='Login']")
	WebElement Loginbtn;
	
	
	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateTitle() {
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	public void validateLogo() {
		String logo_text = crmLogo.getAttribute("alt");
		Assert.assertEquals(logo_text, "free crm logo");
	}
	
	public HomePage loginToCRM(String un,String pwrd) {
		Username.sendKeys(un);
		Password.sendKeys(pwrd);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click()",Loginbtn);
//		Loginbtn.click();
		return new HomePage();
		
	}
	

}
