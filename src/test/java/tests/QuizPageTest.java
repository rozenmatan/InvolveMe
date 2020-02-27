package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.QuizPage;

@Epic("Quiz page")
public class QuizPageTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Test
	@Description("The method opens the templates page and create new form ")
	public void createTechnologyQuiz() {
		QuizPage quizPage = new QuizPage(driver);
		quizPage.clickOnTopMenuByValue("Templates");
		quizPage.createTechnologyQuiz();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(dependsOnMethods = "createTechnologyQuiz")
	@Description("The method opens the page with all ready projects and clicks and checks on the relevant one")
	public void checkTechnologyQuiz() {
		QuizPage quizPage = new QuizPage(driver);
		quizPage.clickOnTopMenuByValue("Projects");
		quizPage.clickOnProjectListByValue("Technology Quiz");
		quizPage.checkTechnologyQuiz("Steve Jobs", "Operating System", "2000", "World Wide Web",
				"Animation/video file");

	}

}
