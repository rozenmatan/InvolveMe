package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.PromotionPage;

@Epic("Promotion page")
public class PromotionPageTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form")
	public void createWinTripToSanFransisco() {
		PromotionPage promotionPage = new PromotionPage(driver);
		promotionPage.clickOnTopMenuByValue("Templates");
		promotionPage.createWinTripToSanFransisco();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createWinTripToSanFransisco")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkWinTripToSanFransisco() {
		PromotionPage promotionPage = new PromotionPage(driver);
		promotionPage.clickOnTopMenuByValue("Projects");
		promotionPage.clickOnProjectListByValue("Win A Trip to San Francisco");
		promotionPage.checkWinTripToSanFransisco("Matan", "Rozen", "rozenmatan1989@gmail.com");
	}
}
