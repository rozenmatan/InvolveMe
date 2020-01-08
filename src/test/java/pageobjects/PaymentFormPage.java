package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class PaymentFormPage extends CommonElementAndFunctions{

	@FindBy(css="#filter-payment")
	private WebElement filterPaymentForm;
	@FindBy(css="[alt='Online Donation Form']")
	private WebElement onlineDonationForm;
	@FindBy(css="[placeholder='First Name*']")
	private WebElement firstNameInput;
	@FindBy(css="[placeholder='Last Name']")
	private WebElement lastNameInput;
	@FindBy(css=".e-freetxt-answer")
	private WebElement donationInput;
	public PaymentFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @desctiption create new form in order to check it on the next step
	 */
	public void createOnlineDonationForm() {
		click(filterPaymentForm);
		click(onlineDonationForm);
		click(useThisTemplate);
		click(startEditing);
		click(saveAndExit);
	}
	/**
	 * @desctiption checks the form that created by the previous method
	 */
	@Step("Donation form details: ")
	public void checkOnlineDonationForm(String firstName, String lastName, String donationAmount) {
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(firstNameInput);
		type(firstNameInput, firstName);
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(lastNameInput);
		type(lastNameInput, lastName);
		click(moveToNextQuestionButton);
		waitForElementToBeFixAtLocation(donationInput);
		type(donationInput, donationAmount);
		click(moveToNextQuestionButton);
		waitForProgressBarWidth("35.7143", progressBar);
		click(moveToNextQuestionButton);
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}

}
