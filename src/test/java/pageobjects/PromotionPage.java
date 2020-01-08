package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class PromotionPage extends CommonElementAndFunctions{

	@FindBy(css="#filter-promotion")
	private WebElement filterPromotion;
	@FindBy(css="img[src*='win-a-trip-to-san-francisco']")
	private WebElement sanFransiscoForm;
	@FindBy(css="input[id*='firstName']")
	private WebElement firstNameInput;	
	@FindBy(css="input[id*='lastName']")
	private WebElement lastNameInput;
	@FindBy(css="input[id*='email']")
	private WebElement emailInput;
	
	
	
	
	
	public PromotionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @desctiption create new form in order to check it on the next step
	 */
	public void createWinTripToSanFransisco() {
		click(filterPromotion);
		click(sanFransiscoForm);
		editAndPublish();
	}
	/**
	 * @desctiption checks the form that created by the previous method
	 */
	@Step("Promotion page details: ")
	public void checkWinTripToSanFransisco(String firstName, String lastName, String email) {
		String mainMenuHandel = driver.getWindowHandle();//save the main page handle
		moveBetweenHandels(mainMenuHandel);//move focus to the new tab that opens
		type(firstNameInput, firstName);
		type(lastNameInput, lastName);
		type(emailInput, email);
		closeCurrentTab();//close the tab that used to check the form
		switchToWindow(mainMenuHandel);//move the focus back to the main window
	}

}
