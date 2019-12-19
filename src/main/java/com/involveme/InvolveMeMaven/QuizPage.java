package com.involveme.InvolveMeMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuizPage extends Template{

	@FindBy(css="#filter-quiz")
	private WebElement filterQuiz;
	@FindBy(css="[alt='Technology Quiz']")
	private WebElement technologyQuiz;
	@FindBy(css=".feedback-box>.feedback-text.correct")
	private WebElement correctFeedback;
	@FindBy(css=".btn-group.float-right.rel>button")
	private WebElement quizDropDownMenu;
	@FindBy(css=".c-menu-video>.svg-wrapper")
	private WebElement videoElementToDrag;
	@FindBy(css=".has-spacer>.c-spacer-container ")
	private WebElement elementToDropOn;
	@FindBy(css=".feedback-box>.feedback-text.correct")
	private WebElement answerFeedback;
	@FindBy(css="[data-pagenr='6']")
	private WebElement lastPageInEditablePageContainer;
	
	public QuizPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void createTechnologyQuiz() {//the method create new form in order to check it on the next step
		click(filterQuiz);
		click(technologyQuiz);
		click(useThisTemplate);
		click(startEditing);
		click(lastPageInEditablePageContainer);
		//dragAndDropToElement(videoElementToDrag, elementToDropOn);
		click(firstPublishButton);
		click(secondPublishButton);
		click(publishNowButton);
	}
	public void checkTechnologyQuiz(String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String fifthAnswer) {//the method checks the form that created by the previous method
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("28.5714", progressBar);
		click(getElementInListByValue(listOfAnswers, firstAnswer));
		waitForElementToBeFixAtLocation(answerFeedback);
		click(moveToNextQuestionArrowRightButton);
		waitForProgressBarWidth("42.8571", progressBar);
		click(getElementInListByValue(listOfAnswers, secondAnswer));
		waitForElementToBeFixAtLocation(answerFeedback);	
		click(moveToNextQuestionArrowRightButton);
		waitForProgressBarWidth("57.1429", progressBar);
		click(getElementInListByValue(listOfAnswers, thirdAnswer));
		waitForElementToBeFixAtLocation(answerFeedback);	
		click(moveToNextQuestionArrowRightButton);
		waitForProgressBarWidth("71.4286", progressBar);
		click(getElementInListByValue(listOfAnswers, fourthAnswer));
		waitForElementToBeFixAtLocation(answerFeedback);	
		click(moveToNextQuestionArrowRightButton);
		waitForProgressBarWidth("85.7143", progressBar);
		click(getElementInListByValue(listOfAnswers, fifthAnswer));
		waitForElementToBeFixAtLocation(answerFeedback);
		click(moveToNextQuestionArrowRightButton);
		waitForProgressBarWidth("100", progressBar);
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window

		
	}
}
