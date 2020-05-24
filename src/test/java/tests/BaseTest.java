package tests;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.qameta.allure.Description;
import pageobjects.LoginPage;
import pageobjects.deleteAllFromsPage;
import utilities.ChooseEnvironment;

public abstract class BaseTest extends api.BastTest {

	protected WebDriver driver;
	private final String email = "rozenmatan1989@gmail.com";
	private final String password = "12345678";
	

	@Parameters({"ip"})
	@BeforeSuite
	public void waitForEc2InstanceToBeUp(String ip) {
		try {
			if(!ip.equals("localhost")) {
				TimeUnit.SECONDS.sleep(45);
				System.out.println("In order to watch the Selenoid UI please go to URL: http://"+ip+":8081");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Parameters({ "browser", "env", "video", "ip" })
	@BeforeMethod
	@Description("initiate the driver and set the URL")
	public void setup(ITestContext testContext, String browser, String env, String video, String ip, ITestResult result)
			throws MalformedURLException {
		ChooseEnvironment chooseEnv = new ChooseEnvironment(browser, env, video, ip, result);
		driver = chooseEnv.getWebDriver();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
	}

	@BeforeMethod
	@Description("the method calls for login procedure")
	public void setupLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(email, password, "correctCredentials");
	}

	@Description("closes the page after the test is done")
	@AfterMethod(dependsOnMethods = "failedTest")
	public void afterMethod() {
		driver.quit();
	}

	@Description("the method check the status of every test,is its failed it take a screen shot")
	@AfterMethod
	public void failedTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}

	@Parameters({ "browser", "env", "video", "ip" })
	@Description("the method delete all forms that was created for the next run")
	@AfterSuite
	public void deleteAllForms(String browser, String env, String video, String ip, ITestResult result)
			throws MalformedURLException {
		ChooseEnvironment chooseEnv = new ChooseEnvironment(browser, env, video, ip, result);
		driver = chooseEnv.getWebDriver();
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(email, password, "correctCredentials");
		deleteAllFromsPage deleteAllFromsPage = new deleteAllFromsPage(driver);
		deleteAllFromsPage.clickOnTopMenuByValue("Projects");
		deleteAllFromsPage.deleteAllFroms();
		driver.quit();
	}

}
