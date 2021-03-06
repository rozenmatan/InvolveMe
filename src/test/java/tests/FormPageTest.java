package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.FormPage;

@Epic("Form page")
public class FormPageTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form ")
	public void createContractForm() {
		FormPage formPage = new FormPage(driver);
		formPage.clickOnTopMenuByValue("Templates");
		formPage.createContractForm();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createContractForm")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkContractForm() {
		FormPage formPage = new FormPage(driver);
		formPage.clickOnTopMenuByValue("ProjecTs");
		formPage.clickOnProjectListByValue("Contact Form");
		formPage.checkContractForm("Matan", "rozenmatan1989@gmail.com", "0544999379", "Marketing", "Advertising",
				"Hello World");
	}
}
