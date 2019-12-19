package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;


public class CalculatorPageTest extends BaseTest{

	@Test
	public void createPersonalLoanCalculator() {//the method opens the templates page and create new form 
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		calculatorPage.clickOnTopMenuByValue("Templates");
		calculatorPage.createPersonalLoanCalculator();
	}
	@Test(dependsOnMethods = "createPersonalLoanCalculator")
	public void checkPersonalLoanCalculator() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		calculatorPage.clickOnTopMenuByValue("Projects");
		calculatorPage.clickOnProjectListByValue("Personal Loan Calculator");
		calculatorPage.checkPersonalLoanCalculator();
	}
}
