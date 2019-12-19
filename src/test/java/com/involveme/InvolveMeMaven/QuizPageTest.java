package com.involveme.InvolveMeMaven;

import org.testng.annotations.Test;




public class QuizPageTest extends BaseTest{
	
	@Test
	public void createTechnologyQuiz() {//the method opens the templates page and create new form 
		QuizPage quizPage = new QuizPage(driver);
		quizPage.clickOnTopMenuByValue("Templates");
		quizPage.createTechnologyQuiz();
	}
	@Test(dependsOnMethods = "createTechnologyQuiz")
	public void checkTechnologyQuiz() {//the method opens the page with all ready projects and clicks and checks on the relevant one
		QuizPage quizPage = new QuizPage(driver);
		quizPage.clickOnTopMenuByValue("Projects");
		quizPage.clickOnProjectListByValue("Technology Quiz");
		quizPage.checkTechnologyQuiz("Steve Jobs","Operating System","2000","World Wide Web","Animation/video file");
		
	}

}
