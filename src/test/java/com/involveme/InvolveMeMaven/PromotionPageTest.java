package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;



public class PromotionPageTest extends BaseTest{
	
	@Test
	public void createWinTripToSanFransisco() {//the method opens the templates page and create new form 
		PromotionPage promotionPage = new PromotionPage(driver);
		promotionPage.clickOnTopMenuByValue("Templates");
		promotionPage.createWinTripToSanFransisco();
	}
	@Test(dependsOnMethods = "createWinTripToSanFransisco")
	public void checkWinTripToSanFransisco() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		PromotionPage promotionPage = new PromotionPage(driver);
		promotionPage.clickOnTopMenuByValue("Projects");
		promotionPage.clickOnProjectListByValue("Win A Trip to San Francisco");
		promotionPage.checkWinTripToSanFransisco("Matan","Rozen","rozenmatan1989@gmail.com");
	}
}
