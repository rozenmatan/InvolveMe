package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.AllArguments;
import utilities.AllureAttachment;

public abstract class BasePage {
	protected WebDriver driver;
	private int timeOutInSeconds = 40;
	
	public BasePage(WebDriver driver) {
		writeToLog(">>>>BasePage Constractor");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		writeToLog("<<<<BasePage Constractor");
	}
	/**
	 * @desctiption type text to an element
	 */
	protected void type(WebElement el,String str) {
		writeToLog(">>>>type");
		waitForElementToBeClickable(el);
		highlightElement(el, "blue");
		el.clear();
		el.sendKeys(str);
		writeToLog("<<<<type");
	}
	/**
	 * @desctiption click on element
	 */
	protected void click(WebElement el) {
		writeToLog(">>>>click");
		waitForElementToBeClickable(el);
		highlightElement(el, "blue");
		el.click();
		writeToLog("<<<<click");
	}
	/**
	 * @desctiption wait until element will be visible
	 */
	protected void waitForElementToBeVisible(WebElement el) {
		writeToLog(">>>>waitForElementToBeVisible");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(el));
		writeToLog("<<<<waitForElementToBeVisible");
	}
	/**
	 * @desctiption wait until text will be present and show ton element
	 */
	protected void waitForTextToBePresentOnElement(final WebElement el,final String txt) {
		writeToLog(">>>>waitForTextToBePresentOnElement");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				writeToLog("<<<<waitForTextToBePresentOnElement");
				return el.getText().equals(txt);
			}
		});
		
	}
	/**
	 * @desctiption wait until element will be clickable
	 */
	protected void waitForElementToBeClickable(WebElement el) {
		writeToLog(">>>>waitForElementToBeClickable");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		writeToLog("<<<<waitForElementToBeClickable");
	}
	/**
	 * @desctiption return existing text on an element
	 */
	protected String getText(WebElement el) {
		writeToLog(">>>>getText");
		highlightElement(el, "orange");
		writeToLog("<<<<getText");
		return el.getText();
	}
	/**
	 * @desctiption return an element that contains a specific text
	 */
	protected WebElement getElementInListByValue(final List <WebElement> list,String value) {
		writeToLog(">>>>getElementInListByValue");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				writeToLog("<<<<waitForTextNotToBeEmpty");
				return list.size() !=0 && list.get(0).getText().length()>0;
			}
		});
		
		for(WebElement el: list) {
			if(el.getText().equalsIgnoreCase(value)) {
				writeToLog("<<<<getElementInListByValue**element**");
				return el;
			}
				
		}
		writeToLog("<<<<getElementInListByValue**null**");
		return null;
	}
	/**
	 * @desctiption waits until the top progress bar will reach to a specific value(usually check that a page is finish loads)
	 */
	protected void waitForProgressBarWidth(final String width,final WebElement progressBar) {
		writeToLog(">>>>waitForProgressBarWidth");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				writeToLog("ProgressBarWidth: "+progressBar.getAttribute("style").toString());
				writeToLog("<<<<waitForProgressBarWidth");
				return progressBar.getAttribute("style").toString().equalsIgnoreCase("width: "+width+"%;") ;
			}
		});
	}
	/**
	 * @desctiption waits until an element is fixed and not in motion(usually check that a page is finish loads)
	 */
	protected void waitForElementToBeFixAtLocation(final WebElement el) {
		writeToLog(">>>>waitForElementToBeAtLocation");
		waitForElementToBeVisible(el);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				int x = el.getLocation().getX();
				int y = el.getLocation().getY();
				writeToLog("X: "+x);
				writeToLog("Y: "+y);
				if(el.getLocation().getX() == x && el.getLocation().getY() == y)
					return true;
				return false;
			}
		});
		writeToLog("<<<<waitForElementToBeAtLocation");
	}
	/**
	 * @desctiption moves between windows 
	 */
	protected void moveBetweenHandels(String parentHandel) {
		writeToLog(">>>>moveBetweenHandels");
		Set<String> handels = driver.getWindowHandles();
		for(String h:handels) {
			if(!h.equals(parentHandel)) {
				switchToWindow(h);
				writeToLog("<<<<moveBetweenHandels");
				return;
			}
		}
	}
	/**
	 * @desctiption does the switch action
	 */
	protected void switchToWindow(String handle) {
		writeToLog(">>>>switchToWindow");
		driver.switchTo().window(handle);
		writeToLog("<<<<switchToWindow");
	}
	/**
	 * @desctiption choose a drop down element by value
	 */
	protected void chooseSelectElementByValue(WebElement el,String value) {
		writeToLog(">>>>chooseSelectElementByValue");
		Select select = new Select(el);
		select.selectByValue(value);
		writeToLog("<<<<chooseSelectElementByValue");
	}
	/**
	 * @desctiption choose a drop down element by visible text
	 */
	protected void chooseSelectElementByVisibleText(WebElement el,String visibleText) {
		writeToLog(">>>>chooseSelectElementByVisibleText");
		Select select = new Select(el);
		select.selectByValue(visibleText);
		writeToLog("<<<<chooseSelectElementByVisibleText");
	}
	/**
	 * @desctiption choose a drop down element by index
	 */
	protected void chooseSelectElementByIndex(WebElement el,int index) {
		writeToLog(">>>>chooseSelectElementByIndex");
		Select select = new Select(el);
		select.selectByIndex(index);
		writeToLog("<<<<chooseSelectElementByIndex");
	}
	/**
	 * @desctiption close the current open tab
	 */
	protected void closeCurrentTab() {
		writeToLog(">>>>closeCurrentTab");
		driver.close();
		writeToLog("<<<<closeCurrentTab");
	}
	/**
	 * @desctiption moves element via X and Y
	 */
	protected void dragAndDropByXY(WebElement el,int x,int y) {
		writeToLog(">>>>dragAndDropByXY");
		Actions act = new Actions(driver);
		act.dragAndDropBy(el, x, y).release().perform();
		highlightElement(el, "blue");
		writeToLog("<<<<dragAndDropByXY");
	}
	/**
	 * @desctiption moves element to a target element
	 */
	protected void dragAndDropToElement(WebElement source,WebElement target) {
		writeToLog(">>>>dragAndDropToElement");
		Point coordinates = target.getLocation();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseMove(coordinates.getX(),coordinates.getY());
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).release(target).perform();
		writeToLog("<<<<dragAndDropToElement");
	}
	/**
	 * @desctiption highlight an element
	 */
	protected void highlightElement(WebElement element, String color) {
		writeToLog(">>>>highlightElement");
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 2px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
		writeToLog("<<<<highlightElement");

	}
	/**
	 * @desctiption writing to allure log 
	 */
	protected void writeToLog(String str) {
		AllureAttachment.addTextAttachment(str);
	}
}
