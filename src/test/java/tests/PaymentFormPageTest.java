package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.PaymentFormPage;

@Epic("Payment form page")
public class PaymentFormPageTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form ")
	public void createOnlineDonationForm() {
		PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
		paymentFormPage.clickOnTopMenuByValue("Templates");
		paymentFormPage.createOnlineDonationForm();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createOnlineDonationForm")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkOnlineDonationForm() {
		PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
		paymentFormPage.clickOnTopMenuByValue("Projects");
		paymentFormPage.clickOnProjectListByValue("Online Donation Form");
		paymentFormPage.checkOnlineDonationForm("Matan", "Rozen", "1200");
	}
}
