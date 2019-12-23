package tests;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import pageobjects.LoginPage;
import pageobjects.deleteAllFromsPage;



public abstract class BaseTest {

	WebDriver driver;

	
	@BeforeClass
	public void setup(ITestContext testContext) {//initiate the driver and set the URL
		if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(System.getProperty("browser").equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		}
		else if(System.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		//driver = new SafariDriver();
		//driver = new EdgeDriver();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
	}
	
	@BeforeClass
	public void setupLogin() {//the method calls for login procedure
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("rozenmatan1989@gmail.com","k6v5f3xx","correctCredentials");
	}
	
	@AfterClass
	public void afterClass() {//closes the page after all tests  in class is done
		driver.quit();
	}
	
	@AfterMethod
	public void failedTest(ITestResult result) {//the method check the status of every test,is its failed it take a screen shot
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
	
	@AfterSuite
	public void deleteAllForms() {//the method delete all forms that was created for the next run
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
