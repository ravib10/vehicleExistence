package com.directLine.vehicleExistence.PageObjects;

import com.directLine.vehicleExistence.utilities.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehicleSearchHomePage extends BasePage {
    public Logger log = Logger.getLogger(VehicleSearchHomePage.class);

	@FindBy(id="vehicleReg")
	public WebElement vehicleRegSearchField;

	@FindBy(name="btnfind")
	public WebElement findVehicleButton;


	@FindBy(css="div.result")
	public WebElement resultHeader;
	
	
	@FindBy(css="div.result+div>span")
	public WebElement coverStartDate;

	@FindBy(css="div.result+div+div>span")
	public WebElement coverEndDate;


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(findVehicleButton);
	}

    public void enterVehicleRegistrationNumber(String value) {

        type(vehicleRegSearchField,value,"Vehicle Number");
        log.info("Inside enterVehicleRegistrationNumber method");

    }
	public VehicleSearchHomePage clickOnFindVehicleButton() {
            click(findVehicleButton, "FindVehicle Button");
            log.info("Inside clickOnFindVehicleButton method in VehicleSearchHomePage.java class");
        return (VehicleSearchHomePage) openPage(VehicleSearchHomePage.class);
	}


    public VehicleSearchHomePage open(String url) {

        DriverManager.getDriver().navigate().to(url);
        return (VehicleSearchHomePage) openPage(VehicleSearchHomePage.class);

    }


    public void verifyVehicleDetails( String status)
    {
        ISDisplayed(resultHeader,status);
    }

public void verifyStartDateAppearing(String date){
		verifyCorrectDateIsAppearingOrNot(coverStartDate,date);
}

	public void verifyEndDateAppearing(String date){
		verifyCorrectDateIsAppearingOrNot(coverEndDate,date);
	}
}