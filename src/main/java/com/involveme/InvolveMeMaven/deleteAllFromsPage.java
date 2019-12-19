package com.involveme.InvolveMeMaven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteAllFromsPage extends Template{
	
	@FindBy(css=".justify-right>.dropdown.relative")
	private List <WebElement> FormsdropDownArrow;
	@FindBy(css="#confirm-delete-button")
	private WebElement confirmDeletionButton;
	@FindBy(css=".swal-icon--success__ring")
	private WebElement deletionSuccess;
	@FindBy(css=".px-5.flex.justify-between.text-base>span:nth-child(2)")
	private WebElement numberOfFormsInTotal;
	
	
	public deleteAllFromsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void deleteAllFroms() {
		
		while(Integer.parseInt(numberOfFormsInTotal.getText())>0) {
			
			System.out.println("Size: "+numberOfFormsInTotal.getText());
			click(FormsdropDownArrow.get(0));
			click(deleteProject);
			click(confirmDeletionButton);
			int numbersOfFormsThatLeftToDelete = Integer.parseInt(numberOfFormsInTotal.getText());
			waitForTextToBePresentOnElement(numberOfFormsInTotal, String.valueOf(numbersOfFormsThatLeftToDelete-1));
			
			
		}
	}

}
