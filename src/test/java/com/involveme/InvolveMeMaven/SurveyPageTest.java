package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;



public class SurveyPageTest extends BaseTest{

	@Test
	public void createEmployeeSurvery() {//the method opens the templates page and create new form 
		SurveryPage surveryPage = new SurveryPage(driver);
		surveryPage.clickOnTopMenuByValue("Templates");
		surveryPage.createEmployeeSurvery();
	}
	@Test(dependsOnMethods = "createEmployeeSurvery")
	public void checkEmployeeSurvery() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		SurveryPage surveryPage = new SurveryPage(driver);
		surveryPage.clickOnTopMenuByValue("Projects");
		surveryPage.clickOnProjectListByValue("Employee Feedback Form");;
		surveryPage.checkEmployeeSurvery("Manager","Engineering");
		
	}
}
