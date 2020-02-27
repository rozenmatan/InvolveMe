package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		Object webDriverAttrubute = result.getTestContext().getAttribute("WebDriver");
		if (webDriverAttrubute instanceof WebDriver) {
			AllureAttachment.captureScreenshot((WebDriver) webDriverAttrubute);
		}

	}
}
