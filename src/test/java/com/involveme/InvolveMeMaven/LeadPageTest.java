package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test; 


public class LeadPageTest extends BaseTest{

	@Test
	public void createAgencyLeadGen() {//the method opens the templates page and create new form 
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Templates");
		leadPage.createAgencyLeadGen();
	}
	
	@Test(dependsOnMethods = "createAgencyLeadGen")
	public void checkAgencyLeadGen() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		LeadPage leadPage = new LeadPage(driver);
		leadPage.clickOnTopMenuByValue("Projects");
		leadPage.clickOnProjectListByValue("Agency Lead Gen");
		leadPage.checkAgencyLeadGen("Video Production","Smartphone","Matan","Automation","rozenmatan1989@gmail.com","5");
	}
}
