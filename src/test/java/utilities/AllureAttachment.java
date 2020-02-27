package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class AllureAttachment {
	@Attachment(value = "{0}", type = "text/plain")
	public static String addTextAttachment(String message) {
		return message;
	}

	@Attachment
	public static byte[] captureScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

}
