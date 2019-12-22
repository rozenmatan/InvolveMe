package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.PaymentFormPage;

@Epic("Payment form page")
public class PaymentFormPageTest extends BaseTest{

		@Severity(SeverityLevel.NORMAL)
		@Test
		public void createOnlineDonationForm() {//the method opens the templates page and create new form 
			PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
			paymentFormPage.clickOnTopMenuByValue("Templates");
			paymentFormPage.createOnlineDonationForm();
		}
		@Severity(SeverityLevel.NORMAL)
		@Test(dependsOnMethods = "createOnlineDonationForm")
		public void checkOnlineDonationForm() {//the method opens the page with all ready projects and clicks and checks on the relevant one
			PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
			paymentFormPage.clickOnTopMenuByValue("Projects");
			paymentFormPage.clickOnProjectListByValue("Online Donation Form");
			paymentFormPage.checkOnlineDonationForm("Matan","Rozen","1200");
		}
}
