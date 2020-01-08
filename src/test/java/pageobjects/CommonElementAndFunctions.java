package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElementAndFunctions extends BasePage{

	@FindBy(css=".wrapper>.c-button")
	protected WebElement moveToNextQuestionButton;
	@FindBy(css=".btn.btn-secondary.save-btn")
	protected WebElement firstPublishButton;
	@FindBy(css=".relative.h-10")
	protected WebElement secondPublishButton; 
	@FindBy(css=".bg-gray-300.overflow-hidden")
	protected WebElement publishNowButton;
	@FindBy(css=".p-4.block")
	protected List<WebElement> topMenu;
	@FindBy(css=".leading-tight.text-lg.font-medium>a")
	protected List <WebElement> projectsList;
	@FindBy(css=".c-button-group-button.e-use-template.float-right")
	protected WebElement useThisTemplate;
	@FindBy(css=".swal-button")
	protected WebElement startEditing;
	@FindBy(css=".justify-right>.dropdown.relative .pl-4.pr-4.w-full")
	protected WebElement deleteProject;
	@FindBy(css=".swal-button.swal-button--danger")
	protected WebElement confirmDeletion;
	@FindBy(css=".answer-behaviour")
	protected List <WebElement> listOfAnswers;
	@FindBy(css=".boldfont")
	protected WebElement questionTitle;
	@FindBy(css=".e-close.nav-link")
	protected WebElement saveAndExit;
	@FindBy(css=".e-btn-next")
	protected WebElement moveToNextQuestionArrowRightButton;
	@FindBy(css=".progress-bar")
	protected WebElement progressBar;
	@FindBy(css="#nav-dropdown")
	protected WebElement dropDown;
	
	public CommonElementAndFunctions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @desctiption doing the create and publish procedure in several cases
	 */
	protected void editAndPublish() {
		click(useThisTemplate);
		click(startEditing);
		click(firstPublishButton);
		click(secondPublishButton);
		click(publishNowButton);
	}
	/**
	 * @desctiption clicks on one of top menu items by value
	 */
	public void clickOnTopMenuByValue(String str) {
		waitForElementToBeClickable(dropDown);
		click(getElementInListByValue(topMenu, str));
	}
	/**
	 * @desctiption clicks on one of the project that created by value
	 */
	public void clickOnProjectListByValue(String str) {
		click(getElementInListByValue(projectsList, str));
	}
	

}
