package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.PersoanllityPage;


@Epic("Personallity page")
public class PersonallityPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void createWhatAnimalAreYouForm() {//the method opens the templates page and create new form 
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Templates");
		persoanllityPage.createWhatAnimalAreYouTest("-2");
	}
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createWhatAnimalAreYouForm")
	public void checkWhatAnimalAreYouForm() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Projects");
		persoanllityPage.clickOnProjectListByValue("What Animal Are You?");
		persoanllityPage.checkWhatAnimalAreYouTest("Volcano","2","Fire","On the Moon");
	}
}
