package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CalculatorPage extends CommonElementAndFunctions{

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
	/**
	 * @desctiption
	 */
	public void createPersonalLoanCalculator() {//create new form in order to check it on the next step
		
		click(filterCalculator);
		click(personalLoanCalculator);
		click(useThisTemplate);
		click(startEditing);
		click(saveAndExit);
		
	}
	/**
	 * @desctiption
	 */
	@Step("loan amount: {0}")
	public void checkPersonalLoanCalculator(String loanAmount) {//checks the form that created by the previous method
		
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		waitForElementToBeClickable(moveToNextQuestionButton);
		click(moveToNextQuestionButton);
		waitForElementToBeClickable(loanAmountInput);
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		type(loanAmountInput, loanAmount);
		dragAndDropByXY(loanTerm, 123, 0);//1 year means move X by 41
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}

}
