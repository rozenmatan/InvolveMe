package com.involveme.InvolveMeMaven;

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

public abstract class BasePage {
	protected WebDriver driver;
	private int timeOutInSeconds = 40;
	
	public BasePage(WebDriver driver) {
		writeToLog(">>>>BasePage Constractor");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		writeToLog("<<<<BasePage Constractor");
	}
	protected void type(WebElement el,String str) {//type text to an element
		writeToLog(">>>>type");
		waitForElementToBeClickable(el);
		highlightElement(el, "blue");
		el.clear();
		el.sendKeys(str);
		writeToLog("<<<<type");
	}
	protected void click(WebElement el) {//click on element
		writeToLog(">>>>click");
		waitForElementToBeClickable(el);
		highlightElement(el, "blue");
		el.click();
		writeToLog("<<<<click");
	}
	protected void waitForElementToBeVisible(WebElement el) {//the method wait until element will be visible
		writeToLog(">>>>waitForElementToBeVisible");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(el));
		writeToLog("<<<<waitForElementToBeVisible");
	}
	protected void waitForElementToBeClickable(WebElement el) {//the method wait until element will be clickable
		writeToLog(">>>>waitForElementToBeClickable");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		writeToLog("<<<<waitForElementToBeClickable");
	}
	protected String getText(WebElement el) {//return existing text on an element
		writeToLog(">>>>getText");
		highlightElement(el, "orange");
		writeToLog("<<<<getText");
		return el.getText();
	}
	protected WebElement getElementInListByValue(final List <WebElement> list,String value) {//the method return an element that contains a specific text
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
	protected void waitForProgressBarWidth(final String width,final WebElement progressBar) {//the method waits until the top progress bar will reach to a specific value
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
	protected void waitForElementToBeFixAtLocation(final WebElement el) {//the method waits until an element is fixed and not in motion(usually check that a page is finish loads)
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
	protected void moveBetweenHandels(String parentHandel) {//the method moves between windows 
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
	protected void switchToWindow(String handle) {//the method does the switch action
		writeToLog(">>>>switchToWindow");
		driver.switchTo().window(handle);
		writeToLog("<<<<switchToWindow");
	}
	protected void chooseSelectElementByValue(WebElement el,String value) {//the method choose a drop down element by value
		writeToLog(">>>>chooseSelectElementByValue");
		Select select = new Select(el);
		select.selectByValue(value);
		writeToLog("<<<<chooseSelectElementByValue");
	}
	protected void chooseSelectElementByVisibleText(WebElement el,String visibleText) {//the method choose a drop down element by visible text
		writeToLog(">>>>chooseSelectElementByVisibleText");
		Select select = new Select(el);
		select.selectByValue(visibleText);
		writeToLog("<<<<chooseSelectElementByVisibleText");
	}
	protected void chooseSelectElementByIndex(WebElement el,int index) {//the method choose a drop down element by index
		writeToLog(">>>>chooseSelectElementByIndex");
		Select select = new Select(el);
		select.selectByIndex(index);
		writeToLog("<<<<chooseSelectElementByIndex");
	}
	protected void closeCurrentTab() {//the method close the current open tab
		writeToLog(">>>>closeCurrentTab");
		driver.close();
		writeToLog("<<<<closeCurrentTab");
	}
	protected void dragAndDropByXY(WebElement el,int x,int y) {//the method moves element via X and Y
		writeToLog(">>>>dragAndDropByXY");
		Actions act = new Actions(driver);
		act.dragAndDropBy(el, x, y).release().perform();
		highlightElement(el, "blue");
		writeToLog("<<<<dragAndDropByXY");
	}
	protected void dragAndDropToElement(WebElement source,WebElement target) {//the method moves element to a target element
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
	protected void highlightElement(WebElement element, String color) {//the method highlight an element
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
	protected void writeToLog(String str) {//the method is printing to console everytime function is execute and finish 
		System.out.println(str);//In real project this method will write to a log file 
	}
}
