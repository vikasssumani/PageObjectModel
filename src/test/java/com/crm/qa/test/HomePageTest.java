package com.crm.qa.test;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.base.TestData;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	public LoginPage lp;
	public HomePage hp;
	public TestUtil tu;
	public Logger logger = Logger.getLogger(HomePageTest.class);
	
	@BeforeMethod
	public void ConatctPageSetUp() {
		intialinzation();
		lp=new LoginPage();
		tu= new TestUtil();
		hp = lp.loginToCRM(p.getProperty("username"),p.getProperty("password"));
		tu.frameSwitch();
	}
	
	@Test(priority=1)
	public void validateUserName() {
		Assert.assertTrue(hp.checkUser().contains("Vikas Sumani"));
	}
	
	@Test(priority=2)
	public void validateLogOut() {
		Assert.assertTrue(hp.validateLogoutLink());
	}
	
	@Test(priority=3)
	public void goToContantPage() {
		hp.clickContactLink();
	}
	
	@Test(priority=4)
	public void setMonth(){
		logger.info("************************ STARTING SET MONTH TEST *********************************");
		logger.info("************************************************************************************");
		Select month = new Select(driver.findElement(By.name("slctMonth")));
		month.selectByVisibleText(TestData.getMonth().get(1));
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
