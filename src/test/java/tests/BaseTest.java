package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import pageobjects.LoginPage;
import pageobjects.deleteAllFromsPage;



public abstract class BaseTest {

	WebDriver driver;
	DesiredCapabilities cap;

	@Parameters( {"browser","env","video"} )
	@BeforeMethod
	@Description("initiate the driver and set the URL")
	public void setup(ITestContext testContext, String browser, String env,String video, ITestResult result) throws MalformedURLException {
		chooseBrowserAndEnv(browser, env, video, result);
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
	}

	@BeforeMethod
	@Description("the method calls for login procedure")
	public void setupLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("rozenmatan1989@gmail.com","k6v5f3xx","correctCredentials");
	}
	
	@Description("closes the page after the test is done")
	@AfterMethod(dependsOnMethods = "failedTest")
	public void afterMethod() {
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
	
	@Parameters({ "browser","env","video"})
	@Description("the method delete all forms that was created for the next run")
	@AfterSuite
	public void deleteAllForms(String browser, String env, String video, ITestResult result) throws MalformedURLException {
		chooseBrowserAndEnv(browser, env, video, result);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("rozenmatan1989@gmail.com","k6v5f3xx","correctCredentials");
		deleteAllFromsPage deleteAllFromsPage = new deleteAllFromsPage(driver);
		deleteAllFromsPage.clickOnTopMenuByValue("Projects");
		deleteAllFromsPage.deleteAllFroms();
		driver.quit();
	}

	public void chooseBrowserAndEnv(String browser, String env, String video,ITestResult result) throws MalformedURLException {
		boolean enableVideoFlag = false;
		
		if(video.equalsIgnoreCase("true"))
			enableVideoFlag = true;
		
		if(env.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
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
			}
		}else if(env.equalsIgnoreCase("docker")) {
			
			switch (browser.toLowerCase()) {
				case "chrome":
					cap = new DesiredCapabilities();
					cap.setBrowserName("chrome");
					cap.setVersion("79.0");
					break;
				case "firefox":
					cap = new DesiredCapabilities();
					cap.setBrowserName("firefox");
					cap.setVersion("71.0");
					break;
				case "opera":
					cap = new DesiredCapabilities();
					cap.setBrowserName("opera");
					cap.setVersion("66.0");
					break;
			}
			cap.setCapability("enableVNC", true);
			if(result != null)
				cap.setCapability("videoName",result.getMethod().getMethodName());
			else
				cap.setCapability("videoName","deleteAllForms");
			cap.setCapability("enableVideo", enableVideoFlag);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
	}

}
