package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class FormPage extends CommonElementAndFunctions {

	@FindBy(css = "#filter-form")
	private WebElement filterSurvey;
	@FindBy(css = "[alt='Contact Form']")
	private WebElement contactForm;
	@FindBy(css = ".initialEnter>div:nth-child(4)>.wrapper>.component-needs-validation>div:nth-child(1)>label>input")
	private WebElement firstNameInput;
	@FindBy(css = ".initialEnter>div:nth-child(4)>.wrapper>.component-needs-validation>div:nth-child(2)>label>input")
	private WebElement emailInput;
	@FindBy(css = ".initialEnter>div:nth-child(4)>.wrapper>.component-needs-validation>div:nth-child(3)>label>input")
	private WebElement phoneInput;
	@FindBy(css = ".initialEnter>div:nth-child(5)>div>.c-dropdown>.el-select>.el-input")
	private WebElement needHelpDropDown;
	@FindBy(css = ".initialEnter>div:nth-child(6)>div>.c-dropdown>.el-select>.el-input")
	private WebElement hearAboutUsDropDown;
	@FindBy(css = ".el-select-dropdown__item")
	private List<WebElement> dropDownList;
	@FindBy(css = ".el-input__suffix>.el-input__suffix-inner")
	private List<WebElement> dropDownArrows;
	@FindBy(css = ".e-freetxt-answer")
	private WebElement messegeTextArea;
	@FindBy(css = ".el-checkbox__input>.el-checkbox__inner")
	private List<WebElement> checkBoxs;
	@FindBy(css = ".el-input__icon.is-reverse")
	private WebElement dropDownIsOpen;

	public FormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @desctiption
	 */
	public void createContractForm() {// create new form in order to check it on the next step
		click(filterSurvey);
		click(contactForm);
		editAndPublish();
	}

	/**
	 * @desctiption
	 */
	@Step("Form details: ")
	public void checkContractForm(String name, String email, String phone, String firstDropDownValue,
			String secondDropDownValue, String textAreaValue) {// checks the form that created by the previous method

		String mainMenuHandel = driver.getWindowHandle();// save the main page handle
		moveBetweenHandels(mainMenuHandel);// move focus to the new tab that opens
		waitForElementToBeFixAtLocation(moveToNextQuestionButton);
		type(firstNameInput, name);
		type(emailInput, email);
		type(phoneInput, phone);
		type(messegeTextArea, textAreaValue);
		click(checkBoxs.get(1));
		click(moveToNextQuestionButton);
		closeCurrentTab();// close the tab that used to check the form
		switchToWindow(mainMenuHandel);// move the focus back to the main window
	}

}
