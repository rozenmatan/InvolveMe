package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.SurveryPage;


@Epic("Survey page")
public class SurveyPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void createEmployeeSurvery() {//the method opens the templates page and create new form 
		SurveryPage surveryPage = new SurveryPage(driver);
		surveryPage.clickOnTopMenuByValue("Templates");
		surveryPage.createEmployeeSurvery();
	}
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createEmployeeSurvery")
	public void checkEmployeeSurvery() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		SurveryPage surveryPage = new SurveryPage(driver);
		surveryPage.clickOnTopMenuByValue("Projects");
		surveryPage.clickOnProjectListByValue("Employee Feedback Form");;
		surveryPage.checkEmployeeSurvery("Manager","Engineering");
		
	}
}
