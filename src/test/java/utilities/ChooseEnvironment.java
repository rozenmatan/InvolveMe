package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChooseEnvironment {

	private WebDriver driver;
	private DesiredCapabilities cap;
	
	public ChooseEnvironment(String browser, String env, String video, ITestResult result) throws MalformedURLException {
		if (env.equalsIgnoreCase("local")) {
			
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
		} else if (env.equalsIgnoreCase("docker")) {

			cap = new DesiredCapabilities();
			
			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				cap.setVersion("79.0");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				cap.setVersion("73.0");
				break;
			case "opera":
				cap.setBrowserName("opera");
				cap.setVersion("66.0");
				break;
			}
			cap.setCapability("enableVNC", true);
			if (result != null)
				cap.setCapability("videoName", result.getMethod().getMethodName());
			else
				cap.setCapability("videoName", "deleteAllForms");
			cap.setCapability("enableVideo", video.equalsIgnoreCase("true"));
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), cap);
		}
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
