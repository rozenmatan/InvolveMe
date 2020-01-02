package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.LeadPage; 

@Epic("Lead page")
public class LeadPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form ")
	public void createAgencyLeadGen() {
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Templates");
		leadPage.createAgencyLeadGen();
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createAgencyLeadGen")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkAgencyLeadGen() {
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Projects");
		leadPage.clickOnProjectListByValue("Agency Lead Gen");
		leadPage.checkAgencyLeadGen("Video Production","Smartphone","Matan","Automation","rozenmatan1989@gmail.com","5");
	}
}
