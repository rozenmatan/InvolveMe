package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.PersoanllityPage;


@Epic("Personallity page")
public class PersonallityPageTest extends BaseTest{

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form ")
	public void createWhatAnimalAreYouForm() {
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Templates");
		persoanllityPage.createWhatAnimalAreYouTest("-2");
	}
	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createWhatAnimalAreYouForm")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkWhatAnimalAreYouForm() {
		PersoanllityPage persoanllityPage = new PersoanllityPage(driver);
		persoanllityPage.clickOnTopMenuByValue("Projects");
		persoanllityPage.clickOnProjectListByValue("What Animal Are You?");
		persoanllityPage.checkWhatAnimalAreYouTest("Volcano","2","Fire","On the Moon");
	}
}
