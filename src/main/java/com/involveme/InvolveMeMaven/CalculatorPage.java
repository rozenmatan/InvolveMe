package com.involveme.InvolveMeMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends Template{

	@FindBy(css="#filter-calculator")
	private WebElement filterCalculator;
	@FindBy(css="[alt='Personal Loan Calculator']")
	private WebElement personalLoanCalculator;
	@FindBy(css=".e-freetxt-answer")
	private WebElement loanAmountInput;
	@FindBy(css=".rangeslider--horizontal>.rangeslider__handle")
	private WebElement loanTerm;
	
	
	public CalculatorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void createPersonalLoanCalculator() {//the method create new form in order to check it on the next step
		
		click(filterCalculator);
		click(personalLoanCalculator);
		click(useThisTemplate);
		click(startEditing);
		click(saveAndExit);
		
	}
	
	public void checkPersonalLoanCalculator() {//the method checks the form that created by the previous method
		
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		waitForElementToBeClickable(moveToNextQuestionButton);
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		type(loanAmountInput, "15000");
		dragAndDropByXY(loanTerm, 123, 0);//1 year means move X by 41
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}

}
