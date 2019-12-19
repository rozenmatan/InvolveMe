package com.involveme.InvolveMeMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentFormPage extends Template{

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
	
	public void createOnlineDonationForm() {//the method create new form in order to check it on the next step
		click(filterPaymentForm);
		click(onlineDonationForm);
		click(useThisTemplate);
		click(startEditing);
		click(saveAndExit);
	}
	
	public void checkOnlineDonationForm(String firstName, String lastName, String donationAmount) {//the method checks the form that created by the previous method
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
