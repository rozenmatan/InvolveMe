package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class PersoanllityPage extends Template{

	@FindBy(css="#filter-personality_test")
	private WebElement filterPersonalltyTest;
	@FindBy(css="img[src*='what-animal-are-you']")
	private WebElement whatAnimalAreYou;
	@FindBy(css="[data-pagenr='1']")
	private WebElement pageNumberTwo;
	@FindBy(css="[data-pagenr='2']")
	private WebElement pageNumberThree;
	@FindBy(css="[data-pagenr='3']")
	private WebElement pageNumberFour;
	@FindBy(css="[data-pagenr='4']")
	private WebElement pageNumberFive;
	@FindBy(css=".c-question-image-container")
	private WebElement questionsImageContainer;
	@FindBy(css=".c-question-container")
	private WebElement questionsContainer;
	@FindBy(css="div[id='accordeon-question-image-answers'] select")
	private List <WebElement> connectAnswersWithImagesToOutcome;
	@FindBy(css="div[id='accordeon-question-answers'] select")
	private List <WebElement> connectAnswersWithTextToOutcome;
	@FindBy(css=".c-answer-container>.answer-behaviour")
	private List <WebElement> listOfAnswersWithImage;
	@FindBy(css=".wrapper button")
	private List <WebElement> listOfAnswersWithText;
	@FindBy(css=".content-item-edit-container-wrapper")
	private WebElement sideMenu;
	
	public PersoanllityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void createWhatAnimalAreYouTest(String dropDownValue) {//the method create new form in order to check it on the next step
		click(filterPersonalltyTest);
		click(whatAnimalAreYou);
		click(useThisTemplate);
		click(startEditing);
		click(pageNumberTwo);
		click(questionsImageContainer);
		waitForElementToBeFixAtLocation(sideMenu);
		for (WebElement select : connectAnswersWithImagesToOutcome) {
			chooseSelectElementByValue(select, dropDownValue);
		}
		click(pageNumberThree);
		click(questionsContainer);
		waitForElementToBeFixAtLocation(sideMenu);
		for (WebElement select : connectAnswersWithTextToOutcome) {
			chooseSelectElementByValue(select, dropDownValue);
		}
		click(pageNumberFour);
		click(questionsImageContainer);
		waitForElementToBeFixAtLocation(sideMenu);
		for (WebElement select : connectAnswersWithImagesToOutcome) {
			chooseSelectElementByValue(select, dropDownValue);
		}
		click(pageNumberFive);
		click(questionsContainer);
		waitForElementToBeFixAtLocation(sideMenu);
		for (WebElement select : connectAnswersWithTextToOutcome) {
			chooseSelectElementByValue(select, dropDownValue);
		}
		click(firstPublishButton);
		click(secondPublishButton);
		click(publishNowButton);
	}
	@Step("Personallity page details: ")
	public void checkWhatAnimalAreYouTest(String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {//the method checks the form that created by the previous method
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(getElementInListByValue(listOfAnswersWithImage, firstAnswer));
		click(getElementInListByValue(listOfAnswersWithImage, firstAnswer));
		waitForElementToBeFixAtLocation(getElementInListByValue(listOfAnswersWithText, secondAnswer));
		click(getElementInListByValue(listOfAnswersWithText, secondAnswer));
		waitForElementToBeFixAtLocation(getElementInListByValue(listOfAnswersWithImage, thirdAnswer));
		click(getElementInListByValue(listOfAnswersWithImage, thirdAnswer));
		waitForElementToBeFixAtLocation(getElementInListByValue(listOfAnswersWithText, fourthAnswer));
		click(getElementInListByValue(listOfAnswersWithText, fourthAnswer));
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}
}
