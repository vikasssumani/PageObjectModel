Feature: Page object model with Cucumber test

Scenario: to login into CRM applicaiton
Given Open CRM link
When Validate the title of CRM login page
When Login into the app
Then validate homepage title
Then validate login 

@Test1
Scenario: Test1
Given This is Test1

@Test2 @Test1
Scenario: Test3
Given Test2 need to test

@Test3 @Test1 @Test2
Scenario: Test3
Given Testing Test3