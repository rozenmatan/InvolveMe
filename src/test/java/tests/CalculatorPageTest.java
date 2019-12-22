package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.CalculatorPage;

@Epic("Calculator page")
public class CalculatorPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void createPersonalLoanCalculator() {//the method opens the templates page and create new form 
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		calculatorPage.clickOnTopMenuByValue("Templates");
		calculatorPage.createPersonalLoanCalculator();
	}
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createPersonalLoanCalculator")
	public void checkPersonalLoanCalculator() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		calculatorPage.clickOnTopMenuByValue("Projects");
		calculatorPage.clickOnProjectListByValue("Personal Loan Calculator");
		calculatorPage.checkPersonalLoanCalculator("15000");
	}
}
