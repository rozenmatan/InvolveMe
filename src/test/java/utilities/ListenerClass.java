package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Attachment;

public class ListenerClass extends TestListenerAdapter{
	@Attachment
	public byte[] captureScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE ) {
			Object webDriverAttrubute = result.getTestContext().getAttribute("WebDriver");
				if(webDriverAttrubute instanceof WebDriver) {
					captureScreenshot((WebDriver)webDriverAttrubute);
				}
		}

	}
}
