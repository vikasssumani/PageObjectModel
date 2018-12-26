package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	Select s ;
	public ContactPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactPageCheck;
	
	@FindBy(name="title")
	WebElement Title;
	

	@FindBy(name="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement last_name;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement save_button;

	public void createContact(String title,String firstName,String lastName) {
		s = new Select(Title);
		s.selectByVisibleText(title);
		first_name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		save_button.click();
	}
	
	public void selectContact(String firstName,String lastName) {
		String xpath_expression = "//a[text()='"+firstName+" "+ lastName+"']//parent::td//preceding-sibling::td";
		driver.findElement(By.xpath(xpath_expression)).click();;
	}

}
