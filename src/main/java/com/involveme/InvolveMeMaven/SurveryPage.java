package com.involveme.InvolveMeMaven;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurveryPage extends Template{


	@FindBy(css="#filter-survey")
	private WebElement filterSurvey;
	@FindBy(css="[alt='Employee Feedback Form']")
	private WebElement employeeSurvery;
	@FindBy(css=".rating-items-container>.rating-item")
	private List<WebElement> ratingGrade;
	@FindBy(css=".c-question-container.is-snappable")
	private WebElement questionContainer;
	
	public SurveryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void createEmployeeSurvery() {//the method create new form in order to check it on the next step
		click(filterSurvey);
		click(employeeSurvery);
		editAndPublish();
	}
	public void checkEmployeeSurvery(String firstAnswer, String secondAnswer) {//the method checks the form that created by the previous method
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		//waitForElementToBeClickable(moveToNextQuestionButton);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("25", progressBar);
		click(getElementInListByValue(listOfAnswers, firstAnswer));
		waitForProgressBarWidth("37.5", progressBar);
		click(getElementInListByValue(listOfAnswers, secondAnswer));
		waitForProgressBarWidth("50", progressBar);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("62.5", progressBar);
		click(ratingGrade.get(ratingGrade.size()-1));
		waitForProgressBarWidth("75", progressBar);
		click(ratingGrade.get(ratingGrade.size()-1));
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}

}
