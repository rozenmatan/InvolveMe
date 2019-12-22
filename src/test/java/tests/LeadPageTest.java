package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.LeadPage; 

@Epic("Lead page")
public class LeadPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void createAgencyLeadGen() {//the method opens the templates page and create new form 
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Templates");
		leadPage.createAgencyLeadGen();
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createAgencyLeadGen")
	public void checkAgencyLeadGen() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Projects");
		leadPage.clickOnProjectListByValue("Agency Lead Gen");
		leadPage.checkAgencyLeadGen("Video Production","Smartphone","Matan","Automation","rozenmatan1989@gmail.com","5");
	}
}
