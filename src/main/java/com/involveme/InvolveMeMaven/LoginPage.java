package com.involveme.InvolveMeMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	@FindBy(css="[type='email']")
	private WebElement emailField;
	@FindBy(css="[type='password']")
	private WebElement passwordField;
	@FindBy(css="[type='submit']")
	private WebElement loginButton;
	@FindBy(css="#nav-dropdown")
	private WebElement selectorAfterSuccessLogin;
	@FindBy(css=".alert.alert-danger")
	private WebElement errorMessageAfterFaildLogin;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String login(String email,String password,String state) {
		type(emailField,email);
		type(passwordField, password);
		click(loginButton);
		if(state.equalsIgnoreCase("correctcredentials"))
			waitForElementToBeVisible(selectorAfterSuccessLogin);//check the main text after login page
		else if(state.equalsIgnoreCase("wrongcredentials")) {
			waitForElementToBeVisible(errorMessageAfterFaildLogin);//check the error exist
			
			return getText(errorMessageAfterFaildLogin);
		}
		return "";
	}
	
	

}
