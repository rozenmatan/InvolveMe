package com.involveme.InvolveMeMaven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteAllFromsPage extends Template{
	
	@FindBy(css="[aria-haspopup='true'].btn.btn-primary")
	private List <WebElement> FormsdropDownArrow;
	@FindBy(css=".swal-button--confirm")
	private WebElement confirmDeletionButton;
	@FindBy(css=".swal-icon--success__ring")
	private WebElement deletionSuccess;
	
	
	public deleteAllFromsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void deleteAllFroms() {
		
		while(FormsdropDownArrow.size()>0) {
			
			click(FormsdropDownArrow.get(0));
			click(deleteProject);
			click(confirmDeletionButton);
			waitForElementToBeVisible(deletionSuccess);
			click(confirmDeletionButton);
			
			
		}
	}

}
