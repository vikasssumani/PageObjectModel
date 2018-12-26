package com.crm.qa.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		features= "C:\\Users\\vikassum\\workspace_photon\\PageObjectModel\\src\\test\\java\\com\\crm\\qa\\feature\\crmlogin.feature",
		glue = {"com.crm.qa.stepdefination"},
		plugin= {"pretty"},
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {"@Test1,@Test2,@Test3"}

		)

public class TestRunner {

}
