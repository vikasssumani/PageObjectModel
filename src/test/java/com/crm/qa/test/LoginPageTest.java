package com.crm.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.base.TestData;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {


	public LoginPage lp;
	//public TestBase tb;
	HomePage homepage;
	
	Logger logger = Logger.getLogger(LoginPageTest.class);

	@BeforeMethod
	public void LoginPageSetup() {
		logger.info("************************ STARTING EXECUTION *********************************");
		intialinzation();
		lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void checkTitle() {
		logger.info("************************ STARTING CHECK TITLE TEST *********************************");
		logger.info("************************************************************************************");
		lp.validateTitle();
	}
	
	//@Test(priority=2)
	public void checklogo() {
		logger.info("************************ STARTING VALIDATE LOGO TEST *********************************");
		logger.info("************************************************************************************");
		lp.validateLogo();
	}
	
	//@Test(priority=3,dataProvider="testDataProvider")
	public void login(String username,String password) {
		logger.info("************************ STARTING LOGIN TEST *********************************");
		logger.info("************************************************************************************");
		homepage = lp.loginToCRM(username, password);
	}
	
	@Test(priority=4)
	public void loginWithMap(){
		logger.info("************************ STARTING LOGIN TEST *********************************");
		logger.info("************************************************************************************");
		String username= TestData.getUserLoginDetails().get("user1").split("_")[0];
		String password= TestData.getUserLoginDetails().get("user1").split("_")[1];
		homepage = lp.loginToCRM(username, password);
	}
	

	
	
	//@DataProvider
	public String[][] testDataProvider() {
		String[][] s = {{"vikas22jan","abc@123"}};
		return s;
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
