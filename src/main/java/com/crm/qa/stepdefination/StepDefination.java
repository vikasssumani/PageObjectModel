package com.crm.qa.stepdefination;


import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	@Before(order=0)
	public void beforehook() {
		System.out.println("this is before hook");
	}
	@After(order=0)
	public void afterhook() {
		System.out.println("this is after hook");
	}
	
	@Before("@Test1")
	public void beforetaggedhook() {
		System.out.println("this is before tagged hook");
	}
	@After("@Test1")
	public void aftertaggedhook() {
		System.out.println("this is after tagged hook");
	}
	
	@Given("^Open CRM link$")
	public void open_CRM_link() throws Throwable {
	   intialinzation();
	}

	@When("^Validate the title of CRM login page$")
	public void validate_the_title_of_CRM_login_page() throws Throwable {
		loginpage = new LoginPage();
		loginpage.validateTitle();
	}

	@When("^Login into the app$")
	public void login_into_the_app() throws Throwable {
		homepage=loginpage.loginToCRM(p.getProperty("username"), p.getProperty("password"));
	}

	@Then("^validate homepage title$")
	public void validate_homepage_title() throws Throwable {
		String user = homepage.checkUser();
		Assert.assertTrue(user.contains("Vikas Sumani"));
	}

	@Then("^validate login$")
	public void validate_login() throws Throwable {
	   homepage.clickContactLink();
	}
	
	@Given("^This is Test(\\d+)$")
	public void this_is_Test(int arg1) throws Throwable {
		System.out.println("This is Test1");
	}

	@Given("^Test(\\d+) need to test$")
	public void test_need_to_test(int arg1) throws Throwable {
		System.out.println("This is Test2");
	}

	@Given("^Testing Test(\\d+)$")
	public void testing_Test(int arg1) throws Throwable {
		System.out.println("This is Test3");
	}
}
