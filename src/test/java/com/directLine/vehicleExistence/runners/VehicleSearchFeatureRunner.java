package com.directLine.vehicleExistence.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;

@CucumberOptions(
		features="src/test/resources/features/VehicleSearch.feature",
		glue="com.directLine.vehicleExistence.steps"

		)

public class VehicleSearchFeatureRunner {

	@Test
	public void runCukes() {
				new TestNGCucumberRunner(getClass()).runCukes();

	}

}
