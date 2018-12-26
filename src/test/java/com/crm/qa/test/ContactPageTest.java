package com.crm.qa.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	ContactPage cp;
	public TestUtil tu;
	
	@BeforeMethod
	@Parameters({"username","password"})
	public void ContactPageSetUp(String un,String pw) throws InterruptedException {
		intialinzation();
		tu = new TestUtil();
		lp=new LoginPage();
		hp=new HomePage();
		cp=new ContactPage();
		hp = lp.loginToCRM(un,pw);
		tu.frameSwitch();
		cp = hp.clickContactLink();
		Thread.sleep(2000L);
		
	}

	@DataProvider
	public Object[][] NewContactData() throws IOException {
		Object[][] data=tu.getTestData();
		return data;
	}
	
	@Test(priority=1,dataProvider="NewContactData")
	public void createNewContact(String title,String fn,String ln) {
		hp.goToCreateContact();
		cp.createContact(title,fn,ln);
	}
	
	@Test(priority=2)
	public void selectGivenContact() {
		cp.selectContact("NEWCONTACT", "PAGEOBJECT");
	}
	

	
}
