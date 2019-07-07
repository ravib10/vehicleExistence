package com.directLine.vehicleExistence.steps;

import com.aventstack.extentreports.Status;
import com.directLine.vehicleExistence.ExtentListeners.ExtentManager;
import com.directLine.vehicleExistence.ExtentListeners.ExtentTestManager;
import com.directLine.vehicleExistence.PageObjects.VehicleSearchHomePage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DirectLineSteps extends BaseSteps {

	public VehicleSearchHomePage home;

	protected Scenario scenario;
//	static String scenarioName;
	static int x = 0;

	@Before
	public synchronized void  before(Scenario scenario) {

		//x is to add the scenario number in report.
		x = x + 1;
		this.scenario = scenario;
		ExtentTestManager.startTest("Scenario No : " + x + " : " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
		setUpFramework();


	}

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {

			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {

			ExtentTestManager.scenarioPass();
		}

		ExtentManager.getReporter().flush();

		quit();

	}

	@And("I click on findVehicle button")
	public void iClickOnFindVehiclebutton() {

		home.clickOnFindVehicleButton();

	}


    @Given("^Launch browser \"([^\"]*)\"$")
    public void launchBrowser(String browserName) throws Throwable {
        openBrowser(browserName);
        ExtentTestManager.logInfo("Browser Opened : "+browserName);
    }

    @And("^user navigates to the URL$")
    public void userNavigatesToTheURL() throws Throwable {

        home = new VehicleSearchHomePage().open(getConfig().getProperty("testsiteurl"));
    }

    @And("^user enter value \"([^\"]*)\" in search field$")
    public void userEnterValueInsearchField(String arg0) throws Throwable {
        home.enterVehicleRegistrationNumber(arg0);
    }

	@Then("^Verify vehicle details are appearing on the homepage or not \"([^\"]*)\"$")
	public void verifyVehicleDetailsAreAppearingOnTheHomepageOrNot(String vehicleNumber) {
	    home.verifyVehicleDetails(getConfig().getProperty("success"));

	}

	@Then("^Verify error message is appearing on the homepage or not \"([^\"]*)\"$")
	public void verifyErrorMessageIsAppearingOnTheHomepageOrNot(String vehicleNumber) throws Throwable {
		home.verifyVehicleDetails(getConfig().getProperty("failure"));
	}

	@And("^Verify correct startDate \"([^\"]*)\" is appearing$")
	public void verifyCorrectStartDateIsAppearing(String arg0) throws Throwable {
		home.verifyStartDateAppearing(arg0);
	}

	@And("^Verify correct endDate \"([^\"]*)\" is appearing$")
	public void verifyCorrectEndDateIsAppearing(String arg0) throws Throwable {
		home.verifyEndDateAppearing(arg0);
	}

	}

