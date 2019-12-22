package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Template extends BasePage{

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
	
	public Template(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected void editAndPublish() {//the method is doing the create and publish procedure in several cases
		click(useThisTemplate);
		click(startEditing);
		click(firstPublishButton);
		click(secondPublishButton);
		click(publishNowButton);
	}
	
	public void clickOnTopMenuByValue(String str) {//the method clicks on one of top menu items by value
		waitForElementToBeClickable(dropDown);
		click(getElementInListByValue(topMenu, str));
	}
	
	public void clickOnProjectListByValue(String str) {//the method clicks on one of the project that created by value
		click(getElementInListByValue(projectsList, str));
	}
	

}
