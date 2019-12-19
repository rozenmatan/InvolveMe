package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;


public class PaymentFormPageTest extends BaseTest{

		@Test
		public void createOnlineDonationForm() {//the method opens the templates page and create new form 
			PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
			paymentFormPage.clickOnTopMenuByValue("Templates");
			paymentFormPage.createOnlineDonationForm();
		}
		@Test(dependsOnMethods = "createOnlineDonationForm")
		public void checkOnlineDonationForm() {//the method opens the page with all ready projects and clicks and checks on the relevant one
			PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
			paymentFormPage.clickOnTopMenuByValue("Projects");
			paymentFormPage.clickOnProjectListByValue("Online Donation Form");
			paymentFormPage.checkOnlineDonationForm("Matan","Rozen","1200");
		}
}
