package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;



public class FormPageTest extends BaseTest{

	@Test
	public void createContractForm() {//the method opens the templates page and create new form 
		FormPage formPage = new FormPage(driver);
		formPage.clickOnTopMenuByValue("Templates");
		formPage.createContractForm();
	}
	@Test(dependsOnMethods = "createContractForm")
	public void checkContractForm() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		FormPage formPage = new FormPage(driver);
		formPage.clickOnTopMenuByValue("ProjecTs");
		formPage.clickOnProjectListByValue("Contact Form");
		formPage.checkContractForm("Matan","rozenmatan1989@gmail.com","0544999379","Marketing","Advertising","Hello World");
	}
}
