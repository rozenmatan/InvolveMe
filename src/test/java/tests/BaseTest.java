package tests;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import pageobjects.LoginPage;
import pageobjects.deleteAllFromsPage;



public abstract class BaseTest {

	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	@Description("initiate the driver and set the URL")
	public void setup(ITestContext testContext, String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			break;
		}
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
	}
	
	@BeforeClass
	@Description("the method calls for login procedure")
	public void setupLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("rozenmatan1989@gmail.com","k6v5f3xx","correctCredentials");
	}
	
	@Description("closes the page after all tests  in class is done")
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Description("the method check the status of every test,is its failed it take a screen shot")
	@AfterMethod
	public void failedTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
	@Description("the method delete all forms that was created for the next run")
	@AfterSuite
	public void deleteAllForms() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("rozenmatan1989@gmail.com","k6v5f3xx","correctCredentials");
		deleteAllFromsPage deleteAllFromsPage = new deleteAllFromsPage(driver);
		deleteAllFromsPage.clickOnTopMenuByValue("Projects");
		deleteAllFromsPage.deleteAllFroms();
		driver.quit();
	}

}
