package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class LeadPage extends CommonElementAndFunctions {

	@FindBy(css = "#filter-leadpage")
	private WebElement filterLeadPage;
	@FindBy(css = "[alt='Agency Lead Gen']")
	private WebElement AgencyLeadGen;
	@FindBy(css = "input[id*='firstName']")
	private WebElement firstNameInput;
	@FindBy(css = "input[id*='organizationName']")
	private WebElement organizationNameInput;
	@FindBy(css = "input[id*='email']")
	private WebElement emailInput;
	@FindBy(css = ".rangeslider__handle")
	private WebElement budgetHandle;
	@FindBy(css = ".e-freetxt-answer")
	private WebElement timeFrameInput;
	@FindBy(css = ".answer-behaviour.active")
	private WebElement answerIsSelected;

	public LeadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @desctiption create new form in order to check it on the next step
	 */
	public void createAgencyLeadGen() {
		click(filterLeadPage);
		click(AgencyLeadGen);
		click(useThisTemplate);
		click(startEditing);
		click(saveAndExit);
	}

	/**
	 * @desctiption checks the form that created by the previous method
	 */
	@Step("Lead page details: ")
	public void checkAgencyLeadGen(String firstAnswer, String secondAnswer, String firstName, String organization,
			String email, String timeFrame) {

		String mainMenuHandel = driver.getWindowHandle();// save the main page handle
		moveBetweenHandels(mainMenuHandel);// move focus to the new tab that opens
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("20", progressBar);
		click(getElementInListByValue(listOfAnswers, firstAnswer));
		waitForProgressBarWidth("30", progressBar);
		click(getElementInListByValue(listOfAnswers, secondAnswer));
		waitForElementToBeFixAtLocation(answerIsSelected);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("60", progressBar);
		type(firstNameInput, firstName);
		type(organizationNameInput, organization);
		type(emailInput, email);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("70", progressBar);
		dragAndDropByXY(budgetHandle, 300, 0);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("80", progressBar);
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		type(timeFrameInput, timeFrame);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("90", progressBar);
		click(moveToNextQuestionButton);
		closeCurrentTab();// close the tab that used to check the form
		switchToWindow(mainMenuHandel);// move the focus back to the main window
	}

}
