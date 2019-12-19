package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;



public class PersonallityPageTest extends BaseTest{

	@Test
	public void createWhatAnimalAreYouForm() {//the method opens the templates page and create new form 
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Templates");
		persoanllityPage.createWhatAnimalAreYouTest("-2");
	}
	
	@Test(dependsOnMethods = "createWhatAnimalAreYouForm")
	public void checkWhatAnimalAreYouForm() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Projects");
		persoanllityPage.clickOnProjectListByValue("What Animal Are You?");
		persoanllityPage.checkWhatAnimalAreYouTest("Volcano","2","Fire","On the Moon");
	}
}
