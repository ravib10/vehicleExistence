package com.directLine.vehicleExistence.PageObjects;

import com.directLine.vehicleExistence.ExtentListeners.ExtentTestManager;
import com.directLine.vehicleExistence.utilities.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public abstract class BasePage<T> {

	protected WebDriver driver;
	
	  private long LOAD_TIMEOUT = 20;


	    public T openPage(Class<T> clazz) {
	        T page = null;
	        try {
	            driver = DriverManager.getDriver();
	            page = PageFactory.initElements(driver, clazz);
	            ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
	            waitForPageToLoad(pageLoadCondition);
	        } catch (NoSuchElementException e) {
	       throw new IllegalStateException(String.format("This is not the %s page", clazz.getSimpleName()));
	        }
	        return page;
	    }

	    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
	        wait.until(pageLoadCondition);
	    }

	    protected abstract ExpectedCondition getPageLoadCondition();

		
		public void click(WebElement element, String elementName) {
			
			element.click();
			ExtentTestManager.logInfo("Clicking on : "+elementName);
			
		}

		public void type(WebElement element, String value, String elementName) {
			element.sendKeys(value);
			ExtentTestManager.logInfo("Typing in : "+elementName+" Entered the value as : "+value);
		
		}



	public void ISDisplayed(WebElement element, String status) {


	if (element.getText().contains(status)) {
		ExtentTestManager.logInfo(status+" :" + " is appearing in body ");
		Assert.assertTrue(true);

	}
	else
	{
		ExtentTestManager.logInfo(status+" :" + " : Doesn't exist in body ");
		Assert.assertTrue(false);
	}


	}


public void verifyCorrectDateIsAppearingOrNot(WebElement element, String date)
{
	if(element.getText().trim().equalsIgnoreCase(date.trim())) {
		ExtentTestManager.logInfo("Date appearing is same as expected, i.e. :" + date);
		Assert.assertTrue(true);
	}
	else
	{
		ExtentTestManager.logInfo("Date appearing is different then expected, i.e. expected is :" + date+" Actual is : "+element.getText());
		Assert.assertTrue(false);
	}
}

}
